package com.example.bdmary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class baseDatos extends SQLiteOpenHelper {
    private static final String NOMBRE_BD="bdproyecto.bd";
    private static final int VERSION_BD=1;
    private static final String TABLA_ESTUDIANTES="create table estudiantes(codigo text primary key, nombre text, carrera text)";

    public baseDatos(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_ESTUDIANTES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS estudiantes");
        db.execSQL(TABLA_ESTUDIANTES);
    }

    public void agregarEstudiante(String codigo, String nombre, String carrera){
        SQLiteDatabase bd=getReadableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO estudiantes VALUES ('"+codigo+"','"+nombre+"', '"+carrera+"')");
            bd.close();
        }
    }

    public List<estudianteModelo> mostrarEstudiantes(){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM estudiantes",null);
        List<estudianteModelo> listEstudiantes=new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                listEstudiantes.add(new estudianteModelo(cursor.getString(0),cursor.getString(1),cursor.getString(2)));
            }while (cursor.moveToNext());
        }
        return listEstudiantes;
    }

    public estudianteModelo buscarEstudiantes(estudianteModelo listEstudiantes, String codigo){
        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM estudiantes WHERE CODIGO='"+codigo+"'",null);

        if (cursor.moveToFirst()){
            do{
                listEstudiantes.setCarrera(cursor.getString(1));
                listEstudiantes.setNombre(cursor.getString(2));
            }while (cursor.moveToNext());
        }
        return listEstudiantes;
    }

    public void editarEstudiante(String codigo, String nombre, String carrera){
        SQLiteDatabase db= getReadableDatabase();
        if(db!=null){
            db.execSQL("UPDATE estudiantes SET CODIGO='"+codigo+"', NOMBRE='"+nombre+"', CARRERA='"+carrera+"' WHERE CODIGO='"+codigo+"'");
            db.close();
        }
    }

    public void eliminarEstudiantes(String codigo){
        SQLiteDatabase db= getReadableDatabase();
        if(db!=null){
            db.execSQL("Delete from estudiantes WHERE CODIGO='"+codigo+"'");
            db.close();
        }
    }

}


