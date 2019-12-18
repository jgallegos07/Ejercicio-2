package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Vista3 extends AppCompatActivity {

    Button botonInsertar,botonSelectAll,botonSelectLast,botonGetName;
    EditText textoName, textoWeight, textoName2, textoResultado;
    CheckBox textoRoteen;
    Spinner lista;

    final BBDD_Helper dbHelper = new BBDD_Helper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista3);

        /*

        botonInsertar = (Button)findViewById(R.id.buttonAdd);
        botonSelectAll = (Button)findViewById(R.id.buttonGetAll);
        botonSelectLast = (Button)findViewById(R.id.buttonGetLast);
        botonGetName = (Button)findViewById(R.id.buttonGetByName);

        textoName = (EditText)findViewById(R.id.textName);
        textoWeight = (EditText)findViewById(R.id.textWeight);
        textoName2 = (EditText)findViewById(R.id.textName2);

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

         */
    }

    public void ejecutar_vista(View view) {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
