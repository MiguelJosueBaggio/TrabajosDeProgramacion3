package org.example;

import java.util.ArrayList;
import java.util.List;

public class Curso {

private String nombre;
private List<Estudiante>listaDeEstudiantes;

    public Curso() {
    }

    public Curso(String nombre) {
        this.nombre = nombre;
        this.listaDeEstudiantes = new ArrayList<>();

    }

    public String nombre() {
        return nombre;
    }

    public Curso setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public List<Estudiante> listaDeEstudiantes() {
        return listaDeEstudiantes;
    }

    public Curso setListaDeEstudiantes(List<Estudiante> listaDeEstudiantes) {
        this.listaDeEstudiantes = listaDeEstudiantes;
        return this;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", listaDeEstudiantes=" + listaDeEstudiantes +
                '}';
    }
}
