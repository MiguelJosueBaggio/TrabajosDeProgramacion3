package org.example;

import java.util.Objects;

public class Producto {

    private String codigo;
    private String descripcion;

    public Producto() {
    }

    public Producto(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String codigo() {
        return codigo;
    }

    public Producto setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public String descripcion() {
        return descripcion;
    }

    public Producto setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(codigo, producto.codigo) && Objects.equals(descripcion, producto.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, descripcion);
    }
}
