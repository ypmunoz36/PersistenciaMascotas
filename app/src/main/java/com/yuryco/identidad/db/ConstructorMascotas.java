package com.yuryco.identidad.db;

import android.content.ContentValues;
import android.content.Context;

import com.yuryco.identidad.Pojo.Mascota;
import com.yuryco.identidad.R;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerTodosDatos(){
        ArrayList<Mascota> mascotas =new ArrayList<Mascota>();
        mascotas.add(new Mascota( 1,"Catty ",0, R.drawable.mascota1));
        mascotas.add(new Mascota(2,"Axl", 0 , R.drawable.mascota2));
        mascotas.add(new Mascota(3,"Firulais", 0,  R.drawable.mascota3));
        mascotas.add(new Mascota(4,"Max", 0,  R.drawable.mascota4));
        mascotas.add(new Mascota(5,"Ronny", 0, R.drawable.mascota5));
        mascotas.add(new Mascota(3,"Caty", 0,  R.drawable.m6));
        mascotas.add(new Mascota(4,"Lola", 0,  R.drawable.m7));
        mascotas.add(new Mascota(5,"Michi", 0, R.drawable.m8));
        return mascotas;
    }

    public void darRaitMascota(Mascota m){
        BaseDatos db =new BaseDatos(context);
        ContentValues contentValues =new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_ID_MASCOTA, m.getIdMascota());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,m.getNombre());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,m.getFoto());

        db.insertarMascota(contentValues);

        ContentValues contentValues2 =new ContentValues();
        contentValues2.put(ConstantesBaseDatos.TABLE_RATING_FK_ID_MASCOTA,m.getIdMascota());
        contentValues2.put(ConstantesBaseDatos.TABLE_RATING_NUMERO_RATING, LIKE);
        db.insertarRatingMascota(contentValues2);
    }

    public ArrayList<Mascota> obtenerCincoMascotas(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerCincoMascotas();
    }

    public int obtenerRatingMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerRatingMascota(mascota);
    }
}
