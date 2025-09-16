package org.example;

public class Alumno {

    private String nombre;
    private int nota;
    private String curso;

    public Alumno(String nombre, int nota, String curso) {
        this.nombre = nombre;
        this.nota = nota;
        this.curso = curso;
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

    public String curso() {
        return curso;
    }

    public Alumno setCurso(String curso) {
        this.curso = curso;
        return this;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", nota=" + nota +
                ", curso='" + curso + '\'' +
                '}';
    }
}
