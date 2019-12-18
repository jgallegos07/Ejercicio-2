package com.example.ejercicio2;

public class EstructuraBBDD {


    private EstructuraBBDD(){ }

    public static final String TABLE_NAME = "fruitis";
    public static final String NOMBRE_CAMPO1 = "id";
    public static final String NOMBRE_CAMPO2 = "name";
    public static final String NOMBRE_CAMPO3 = "weight";
    public static final String NOMBRE_CAMPO4 = "type";
    public static final String NOMBRE_CAMPO5 = "rotten";


    //Metodo para crear y mantener la base de datos y las tablas

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + EstructuraBBDD.TABLE_NAME +" ("+
            EstructuraBBDD.NOMBRE_CAMPO1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            EstructuraBBDD.NOMBRE_CAMPO2 + " TEXT, "+
            EstructuraBBDD.NOMBRE_CAMPO3 + " NUMBER, "+
            EstructuraBBDD.NOMBRE_CAMPO4 + " TEXT, " +
            EstructuraBBDD.NOMBRE_CAMPO5 + " BOOLEAN)";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + EstructuraBBDD.TABLE_NAME;

}
