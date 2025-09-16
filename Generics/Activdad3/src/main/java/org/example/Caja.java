package org.example;

public class Caja <T>{

    private T contenido;


    public Caja() {
    }

    public Caja(T contenido) {
        this.contenido = contenido;
    }

    public T contenido() {
        return contenido;
    }

    public Caja<T> setContenido(T contenido) {
        this.contenido = contenido;
        return this;
    }

    @Override
    public String toString() {
        return "Caja{" +
                "contenido=" + contenido +
                '}';
    }
}
