package org.example;

import java.util.Objects;

public class Curso {

    private String nombre;
    private String docente;

    public Curso() {
    }

    public Curso(String nombre, String docente) {
        this.nombre = nombre;
        this.docente = docente;
    }

    public String docente() {
        return docente;
    }

    public Curso setDocente(String docente) {
        this.docente = docente;
        return this;
    }

    public String nombre() {
        return nombre;
    }

    public Curso setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", docente='" + docente + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(nombre, curso.nombre) && Objects.equals(docente, curso.docente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, docente);
    }
}
