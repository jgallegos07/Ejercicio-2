package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button botonInsertar,botonSelectAll,botonSelectLast,botonGetName;
    EditText textoName, textoWeight, textoName2, textoResultado;
    CheckBox textoRoteen;
    Spinner lista;

    final BBDD_Helper dbHelper = new BBDD_Helper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        botonInsertar = (Button)findViewById(R.id.buttonAdd);
        botonSelectAll = (Button)findViewById(R.id.buttonGetAll);
        botonSelectLast = (Button)findViewById(R.id.buttonGetLast);
        botonGetName = (Button)findViewById(R.id.buttonGetByName);

        textoName = (EditText)findViewById(R.id.textName);
        textoWeight = (EditText)findViewById(R.id.textWeight);
        textoName2 = (EditText)findViewById(R.id.textName2);

        textoResultado = (EditText)findViewById(R.id.textResultado);

        textoRoteen = (CheckBox)findViewById(R.id.checRotten);


        lista = (Spinner)findViewById(R.id.spinner);

        final List<String> categories = new ArrayList<String>();


        categories.add("flavourless");
        categories.add("flat");
        categories.add("spicy");
        categories.add("mild");
        categories.add("bitter");
        categories.add("sour");
        categories.add("sweet");
        categories.add("salty");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        lista.setAdapter(dataAdapter);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

              /*
        Boton insertar para añadir frutas a la base de datos
         */
        botonInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = dbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();

                values.put(EstructuraBBDD.NOMBRE_CAMPO2, textoName.getText().toString());
                values.put(EstructuraBBDD.NOMBRE_CAMPO3, textoWeight.getText().toString());
                values.put(EstructuraBBDD.NOMBRE_CAMPO4, lista.getSelectedItem().toString());
                values.put(EstructuraBBDD.NOMBRE_CAMPO5, textoRoteen.getText().toString());

                long newRowId = db.insert(EstructuraBBDD.TABLE_NAME, null,values);

                Toast.makeText(getApplicationContext(), "Se inserto el registro correctamente con clave: " +newRowId, Toast.LENGTH_LONG).show();

            }
        });

        botonSelectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = dbHelper.getReadableDatabase();

                String tabla = "fruitis";

                String[] columnas = new String[]{"" + textoName, "" + textoWeight, "" + lista, "" + textoRoteen};

                Cursor c = db.query(tabla, columnas, null, null, null, null, null);

                if (c.moveToFirst()) {
                    do {
                        String nombre = c.getString(c.getColumnIndex("name"));
                        String peso = c.getString(c.getColumnIndex("weight"));
                        String tipo = c.getString(c.getColumnIndex("type"));
                        String podri = c.getString(c.getColumnIndex("rotten"));
                    } while (c.moveToNext());


                    Toast.makeText(getApplicationContext(), "El registro es: " + textoResultado, Toast.LENGTH_LONG).show();


                }
                textoResultado.setText(" nombre " + c.getString(0) + " weight  " + c.getString(1) + " tipo "
                        + c.getString(2) + "  rotten " + c.getString(3) + ".");
            }
        });

        botonSelectLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = dbHelper.getReadableDatabase();

                String tabla="fruitis";

                String [] columnas = new String[]{""+textoName,""+textoWeight,""+lista,""+textoRoteen};

                Cursor c = db.query(tabla,columnas,null,null,null,null,null);

                String resultado ="";

                String nombre = c.getColumnName(0);
                String weight = c.getColumnName(1);
                String type = c.getColumnName(2);
                String rotten = c.getColumnName(3);

                for (c.moveToFirst(); !c.isAfterLast();c.moveToNext()){
                    textoResultado.setText( resultado + " N " + c.getString(0) + "  W " + c.getString( 1) +" T "
                            + c.getString(2)+ " R  " + c.getString(3)+ ".");
                }

                Toast.makeText(getApplicationContext(),"El registro es: " + resultado,Toast.LENGTH_LONG).show();


            }
        });

        textoName2.setVisibility(View.GONE);

        botonGetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textoName2.setVisibility(View.VISIBLE);

                SQLiteDatabase db = dbHelper.getReadableDatabase();


                //incluimos un try para evitar que de error cuando buscamos un nombre que no existe


                    String nombre = textoName2.getText().toString();
                    Cursor fila = db.rawQuery(
                            "select name,weight,lista,rotten from articulos where name=" + nombre, null);
                    if (fila.moveToFirst()) {
                        textoName2.setText(fila.getString(0));
                        textoWeight.setText(fila.getString(1));
                        lista.getSelectedItem().toString();
                        textoRoteen.setText(fila.getString(3));
                    } else
                        Toast.makeText(getApplicationContext(),"No existe la fruta con ese nombre",Toast.LENGTH_LONG).show();

                    textoResultado.setText("Nombre" + textoName2 + " - Peso " + textoWeight + " - Tipo " + lista + " - Podrido " +textoRoteen);

                    //la información recuperada la tenemos en una tabla virtual
                    //de tres columnas, en la 0 y en la 1 tenemos nombre, apellido y dirección


            }
        });

        }

    public void ejecutar_vista(View view) {
        Intent i=new Intent(this,Vista.class);
        startActivity(i);
    }
}
