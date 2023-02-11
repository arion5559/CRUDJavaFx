package com.example.crudjavafx;

public class Personajes {
    private int id;
    private String nombre;
    private int nivelVitalidad;
    private int nivelFuerza;
    private int nivelDestreza;
    private int nivelMagia;
    private float dinero;
    private int idUsuario;

    public Personajes(int id, String nombre, int nivelVitalidad,
                      int nivelFuerza, int nivelDestreza, int nivelMagia,
                      float dinero, int idUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.nivelVitalidad = nivelVitalidad;
        this.nivelFuerza = nivelFuerza;
        this.nivelDestreza = nivelDestreza;
        this.nivelMagia = nivelMagia;
        this.dinero = dinero;
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelVitalidad() {
        return nivelVitalidad;
    }

    public void setNivelVitalidad(int nivelVitalidad) {
        this.nivelVitalidad = nivelVitalidad;
    }

    public int getNivelFuerza() {
        return nivelFuerza;
    }

    public void setNivelFuerza(int nivelFuerza) {
        this.nivelFuerza = nivelFuerza;
    }

    public int getNivelDestreza() {
        return nivelDestreza;
    }

    public void setNivelDestreza(int nivelDestreza) {
        this.nivelDestreza = nivelDestreza;
    }

    public int getNivelMagia() {
        return nivelMagia;
    }

    public void setNivelMagia(int nivelMagia) {
        this.nivelMagia = nivelMagia;
    }

    public float getDinero() {
        return dinero;
    }

    public void setDinero(float dinero) {
        this.dinero = dinero;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Personajes [id=" + id + ", nombre=" + nombre + ", nivelVitalidad=" + nivelVitalidad + ", nivelFuerza=" + nivelFuerza + ", nivelDestreza=" + nivelDestreza + ", nivelMagia=" + nivelMagia + ", dinero=" + dinero + ", idUsuario=" + idUsuario + "]";
    }


}
