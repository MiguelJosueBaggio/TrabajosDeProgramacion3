package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    private static HashSet<Producto>productos= new HashSet<>();/*Se hace estaticos para poder crear una lista de productos que pertenezca a la clase y no alas instancias*/

    public Producto(int codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public static HashSet<Producto> productos() {
        return productos;
    }

    public static void setProductos(HashSet<Producto> productos) {
        Producto.productos = productos;
    }

    public int codigo() {
        return codigo;
    }

    public Producto setCodigo(int codigo) {
        this.codigo = codigo;
        return this;
    }

    public String nombre() {
        return nombre;
    }

    public Producto setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public double precio() {
        return precio;
    }

    public Producto setPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public static void agregarProducto(Producto producto){
        if (!productos.contains(producto)) {productos.add(producto);

        }else System.out.println("producto repetido");



    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return codigo == producto.codigo && Double.compare(precio, producto.precio) == 0 && Objects.equals(nombre, producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, precio);
    }


    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}

