package com.example.lenovo_user.votacionapp.helper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lenovo_user.votacionapp.modelo.Persona;

import java.util.ArrayList;
import java.util.List;
public class HelperPersonaBD  extends SQLiteOpenHelper{
    public HelperPersonaBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE persona(id Integer PRIMARY KEY AUTOINCREMENT,  cedula varchar UNIQUE NOT NULL , nombre varchar NOT NULL, recinto varchar NOT NULL, junta varchar NOT NULL,direccion varchar NOT NULL, provincia varchar NOT NULL, canton varchar NOT NULL,parroquia varchar NOT NULL,zona varchar NOT NULL)");
    }

    public void insertar (Persona persona){
        ContentValues valores = new ContentValues();
        valores.put("cedula",persona.getCedula());
        valores.put("nombre",persona.getNombre());
        valores.put("recinto",persona.getRecinto());
        valores.put("junta",persona.getJunta());
        valores.put("direccion",persona.getDireccion());
        valores.put("provincia",persona.getProvincia());
        valores.put("canton",persona.getCanton());
        valores.put("parroquia",persona.getParroquia());
        valores.put("zona",persona.getZona());
        this.getWritableDatabase().insert("persona",null,valores);
    }

    public List<Persona> obtenerPersonas(){
        List<Persona> lista = new ArrayList<Persona>();
        String resultado = null;
        Cursor cursor = this.getReadableDatabase().rawQuery("select * from Persona",null);
        if (cursor.moveToFirst()){
            do{
                String cedula = cursor.getString(cursor.getColumnIndex("cedula"));
                String nombre = cursor.getString(cursor.getColumnIndex("nombre"));
                String recinto = cursor.getString(cursor.getColumnIndex("recinto"));
                String junta = cursor.getString(cursor.getColumnIndex("junta"));
                String direccion = cursor.getString(cursor.getColumnIndex("direccion"));
                String provincia = cursor.getString(cursor.getColumnIndex("provincia"));
                String canton = cursor.getString(cursor.getColumnIndex("canton"));
                String parroquia = cursor.getString(cursor.getColumnIndex("parroquia"));
                String zona = cursor.getString(cursor.getColumnIndex("zona"));

                Persona persona= new Persona();
                persona.setCedula(cedula);
                persona.setNombre(nombre);
                persona.setRecinto(recinto);
                persona.setJunta(junta);
                persona.setDireccion(direccion);
                persona.setProvincia(provincia);
                persona.setCanton(canton);
                persona.setParroquia(parroquia);
                persona.setZona(zona);


                lista.add(persona);

            }while (cursor.moveToNext());
        }
        return lista;
    }

    public List<Persona> leerCedula(String cedula1){
        List<Persona> lista = new ArrayList<Persona>();
        Cursor cursor = this.getReadableDatabase().rawQuery("select * from Persona where 'cedula='+cedula1",null);
        String consulta = "";
        if (cursor.moveToFirst()){
            do{
                String cedula = cursor.getString(cursor.getColumnIndex("cedula"));
                String nombre = cursor.getString(cursor.getColumnIndex("nombre"));
                String recinto = cursor.getString(cursor.getColumnIndex("recinto"));
                String junta = cursor.getString(cursor.getColumnIndex("junta"));
                String direccion = cursor.getString(cursor.getColumnIndex("direccion"));
                String provincia = cursor.getString(cursor.getColumnIndex("provincia"));
                String canton = cursor.getString(cursor.getColumnIndex("canton"));
                String parroquia = cursor.getString(cursor.getColumnIndex("parroquia"));
                String zona = cursor.getString(cursor.getColumnIndex("zona"));
                Persona persona = new Persona();
                persona.setCedula(cedula);
                persona.setNombre(nombre);
                persona.setRecinto(recinto);
                persona.setJunta(junta);
                persona.setDireccion(direccion);
                persona.setProvincia(provincia);
                persona.setCanton(canton);
                persona.setParroquia(parroquia);
                persona.setZona(zona);
                lista.add(persona);


            }while (cursor.moveToNext());
        }
        return lista;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
