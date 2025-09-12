package org.example;

public class Alumno {

    private String nombre;
    private int nota;

    public Alumno(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public Alumno() {
    }

    public String nombre() {
        return nombre;
    }

    public Alumno setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public int nota() {
        return nota;
    }

    public Alumno setNota(int nota) {
        this.nota = nota;
        return this;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", nota=" + nota +
                '}';
    }
}
