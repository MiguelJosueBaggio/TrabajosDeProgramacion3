package org.example;

public class Estudiante extends Persona{
    private String carrera;

    public Estudiante(String nombre, int edad) {
        super(nombre, edad);
    }

    public Estudiante(String nombre, int edad, String carrera) {
        super(nombre, edad);
        this.carrera = carrera;
    }

    public String carrera() {
        return carrera;
    }

    public Estudiante setCarrera(String carrera) {
        this.carrera = carrera;
        return this;
    }

    @Override
    public String toString() {
        return  super.toString()  +
                " , carrera='" + carrera + '\'' +
                "} " ;
    }
}
