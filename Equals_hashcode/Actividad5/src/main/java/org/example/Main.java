package org.example;



import org.example.Producto;

import java.util.ArrayList;
import java.util.List;

import static org.example.Producto.productos;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Producto producto1 = new Producto(1663,"Robot",100000);
        Producto producto2= new Producto(1588,"CPU",50000);
        Producto producto3 = new Producto(1663,"Robot",100000);
        Producto.productos().add(producto1); /*Lista estaticq qeu pertenece a la clase producto y no asus instanciass*/
        Producto.productos().add(producto2);
        Producto.productos().add(producto3);
        System.out.println(Producto.productos());






    }

}