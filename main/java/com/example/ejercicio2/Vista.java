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

public class Vista extends AppCompatActivity {

    Button botonInsertar,botonSelectAll,botonSelectLast,botonGetName;
    EditText textoName, textoWeight, textoName2, textoResultado;
    CheckBox textoRoteen;
    Spinner lista;

    final BBDD_Helper dbHelper = new BBDD_Helper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista);

        /*

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

         */
    }


    public void ejecutar_vista(View view) {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
