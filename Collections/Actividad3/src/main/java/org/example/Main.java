package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Set<Producto>productos = new HashSet<>();
        Producto producto1 = new Producto("b546","TV");
        Producto producto2 = new Producto("b510","CPU");
        Producto producto3 = new Producto("b512","PARLANTR");
        Producto producto4 = new Producto("b510","CPU");

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto2);
        productos.add(producto4);

     for (Producto producto:productos){
         System.out.println(producto);
     }



    }
}