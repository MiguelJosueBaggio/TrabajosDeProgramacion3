package org.example;

public class ProductoDTO {

    private String codigo;
    private String nombre;
    private double precio;

    public ProductoDTO() {
    }

    public ProductoDTO(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String codigo() {
        return codigo;
    }

    public ProductoDTO setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public String nombre() {
        return nombre;
    }

    public ProductoDTO setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public double precio() {
        return precio;
    }

    public ProductoDTO setPrecio(double precio) {
        this.precio = precio;
        return this;
    }


    @Override
    public String toString() {
        return "ProductoDTO{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
