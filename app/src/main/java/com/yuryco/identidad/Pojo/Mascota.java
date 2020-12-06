package com.yuryco.identidad.Pojo;

public class Mascota {

    private int idMascota;
    private String nombre;
    private int numRaiting;
    private int foto;

    public Mascota(int idMascota,String nombre, int numRaiting , int foto ) {
        this.nombre = nombre;
        this.numRaiting = numRaiting;
        this.foto = foto;
        this.idMascota = idMascota;
    }

    public Mascota() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumRaiting() {
        return numRaiting;
    }

    public void setNumRaiting(int numRaiting) {
        this.numRaiting = numRaiting;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }
}
