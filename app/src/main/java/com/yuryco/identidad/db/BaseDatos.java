package com.yuryco.identidad.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.yuryco.identidad.Pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos( Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE "+ConstantesBaseDatos.TABLE_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_MASCOTA_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_ID_MASCOTA + " INTEGER UNIQUE," +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE   + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_RATING + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO    + " INTEGER " +
                ")";


        String queryCrearTablaRatingMascota = "CREATE TABLE "+ConstantesBaseDatos.TABLE_RATING_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_RATING_ID_MASCOTA_R            + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_RATING_FK_ID_MASCOTA   + " INTEGER, " +
                ConstantesBaseDatos.TABLE_RATING_NUMERO_RATING  + " INTEGER, " +
                " FOREIGN KEY ( " + ConstantesBaseDatos.TABLE_RATING_FK_ID_MASCOTA + " ) " +
                " REFERENCES "+ ConstantesBaseDatos.TABLE_MASCOTA     + " ( " + ConstantesBaseDatos.TABLE_MASCOTA_ID+" ) " +
                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaRatingMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ ConstantesBaseDatos.TABLE_MASCOTA );
        db.execSQL("DROP TABLE IF EXISTS  "+ ConstantesBaseDatos.TABLE_RATING_MASCOTA );
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerCincoMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT "+ ConstantesBaseDatos.TABLE_MASCOTA_ID_MASCOTA+","+
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE+","+
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO+" FROM " + ConstantesBaseDatos.TABLE_MASCOTA
                + " ORDER BY " +
                ConstantesBaseDatos.TABLE_MASCOTA_ID + " DESC LIMIT 5";
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros =   db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual  = new Mascota();
            mascotaActual.setIdMascota(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryRating  = "SELECT COUNT("+ConstantesBaseDatos.TABLE_RATING_NUMERO_RATING+") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_RATING_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_RATING_FK_ID_MASCOTA + "=" + mascotaActual.getIdMascota();

            Cursor registroRating = db.rawQuery(queryRating, null);
            if(registroRating.moveToNext()){
                mascotaActual.setNumRaiting(registroRating.getInt(0));
            }else{
                mascotaActual.setNumRaiting(0);
            }

            mascotas.add(mascotaActual);
        }
        db.close();
        return  mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            db.insert(ConstantesBaseDatos.TABLE_MASCOTA,null,contentValues);
        }catch (SQLiteConstraintException e){
            Toast.makeText(context,"Esta mascota ya esta en tus preferidos",Toast.LENGTH_LONG).
                    show();
        }
        db.close();
    }

    public void insertarRatingMascota( ContentValues contentValues){
        SQLiteDatabase db  = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_RATING_MASCOTA, null , contentValues);
        db.close();
    }

    public int obtenerRatingMascota(Mascota mascota){
        int ratingMascota = 0;
        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_RATING_NUMERO_RATING+")"+
                " FROM "+ ConstantesBaseDatos.TABLE_RATING_MASCOTA +
                " WHERE "+ ConstantesBaseDatos.TABLE_RATING_FK_ID_MASCOTA + "= "+mascota.getIdMascota();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if(registros.moveToNext()){
            ratingMascota = registros.getInt(0);
        }

        db.close();
        return ratingMascota;
    }
}