package com.example.crudjavafx;

public class ClasesPersonajes {
    private int nivelVitalidad;
    private int nivelFuerza;
    private int nivelDestreza;
    private int nivelMagia;

    public ClasesPersonajes(int nivelVitalidad, int nivelFuerza, int nivelDestreza, int nivelMagia) {
        super();
        this.nivelVitalidad = nivelVitalidad;
        this.nivelFuerza = nivelFuerza;
        this.nivelDestreza = nivelDestreza;
        this.nivelMagia = nivelMagia;
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

    @Override
    public String toString() {
        return "ClasePersonaje [nivelVitalidad=" + nivelVitalidad + ", nivelFuerza=" + nivelFuerza + ", nivelDestreza="
                + nivelDestreza + ", nivelMagia=" + nivelMagia + "]";
    }

    public static String mostrarClases() {
        String clases = "";
        clases += ("1. Caballero:" + (char) 10
                + "Vitalidad: 10" + (char) 10
                + "Fuerza: 14" + (char) 10
                + "Destreza: 7" + (char) 10
                + "Magia: 3" + (char) 10);
        clases += (char) 10;
        clases += ("2. Ladrón:" + (char) 10
                + "Vitalidad: 8" + (char) 10
                + "Fuerza: 7" + (char) 10
                + "Destreza: 16" + (char) 10
                + "Magia: 3" + (char) 10);
        clases += (char) 10;
        clases += ("3. Mago:" + (char) 10
                + "Vitalidad: 7" + (char) 10
                + "Fuerza: 8" + (char) 10
                + "Destreza: 5" + (char) 10
                + "Magia: 14" + (char) 10);
        clases += (char) 10;
        clases += ("4. Guerrero:" + (char) 10
                + "Vitalidad: 14" + (char) 10
                + "Fuerza: 14" + (char) 10
                + "Destreza: 3" + (char) 10
                + "Magia: 3" + (char) 10);
        clases += (char) 10;
        clases += ("5. Marginado:" + (char) 10
                + "Vitalidad: 9" + (char) 10
                + "Fuerza: 9" + (char) 10
                + "Destreza: 9" + (char) 10
                + "Magia: 9" + (char) 10);
        return clases;
    }
}
