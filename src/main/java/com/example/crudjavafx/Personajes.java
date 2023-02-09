package com.example.crudjavafx;

public class Personajes {
    private String nombre;
    private int nivelVitalidad;
    private int nivelFuerza;
    private int nivelDestreza;
    private int nivelMagia;
    private float dinero;

    public Personajes(String nombre, int nivelVitalidad, int nivelFuerza, int nivelDestreza, int nivelMagia,
                      float dinero) {
        this.nombre = nombre;
        this.nivelVitalidad = nivelVitalidad;
        this.nivelFuerza = nivelFuerza;
        this.nivelDestreza = nivelDestreza;
        this.nivelMagia = nivelMagia;
        this.dinero = dinero;
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

    @Override
    public String toString() {
        return "Nombre=" + nombre + ", Vitalidad=" + nivelVitalidad + ", Fuerza=" + nivelFuerza + ", Destreza="
                + nivelDestreza + ", Magia=" + nivelMagia + ", Dinero=" + dinero;
    }

}
