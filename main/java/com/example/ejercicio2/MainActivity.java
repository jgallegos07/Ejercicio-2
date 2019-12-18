package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {

    Button botonInsertar, botonGetName;
    EditText textoName, textoWeight, textoRotten, textoName2;
    CheckBox textoRoteen;
    Spinner lista;

    final BBDD_Helper dbHelper = new BBDD_Helper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        botonInsertar = (Button)findViewById(R.id.buttonAdd);
        botonGetName = (Button)findViewById(R.id.buttonGetByName);


        textoName = (EditText)findViewById(R.id.textName);
        textoWeight = (EditText)findViewById(R.id.textWeight);
        textoRoteen = (CheckBox)findViewById(R.id.checRotten) ;
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
                values.put(EstructuraBBDD.NOMBRE_CAMPO5, textoRotten.getText().toString());

                long newRowId = db.insert(EstructuraBBDD.TABLE_NAME, null,values);

                Toast.makeText(getApplicationContext(), "Se inserto el registro correctamente con clave: " +newRowId, Toast.LENGTH_LONG).show();

            }
        });

    }

    public void ejecutar_vista(View view) {
        Intent i=new Intent(this,Vista.class);
        startActivity(i);
    }
    public void ejecutar_vista2(View view) {
        Intent i=new Intent(this,Vista2.class);
        startActivity(i);
    }
    public void ejecutar_vista3(View view) {
        Intent i=new Intent(this,Vista3.class);
        startActivity(i);
    }
}
