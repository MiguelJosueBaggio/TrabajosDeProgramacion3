package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Producto producto1 = Producto.builder()
                .codigo("A1")
                .nombre("Cuaderno")
                .proveedor("Megamaoyrista")
                .precio(3000)
                .build();

        Producto producto2 = Producto.builder()
                .codigo("A2")
                .nombre("Lapicera")
                .proveedor("Segal")
                .precio(200)
                .build();
        Producto producto3 = Producto.builder()
                .codigo("A1")
                .nombre("afiche")
                .proveedor("J&D")
                .precio(300)
                .build();



        ProductoRecord productoRecord1 = new ProductoRecord(producto1.getCodigo(), producto1.getNombre(),producto1.getPrecio());
        ProductoRecord productoRecord2 = new ProductoRecord(producto2.getCodigo(), producto2.getNombre(), producto2.getPrecio());
        ProductoRecord productoRecord3 = new ProductoRecord(producto3.getCodigo(), producto3.getNombre(), producto3.getPrecio());


        List<ProductoRecord>productoRecords= new ArrayList<>();

        productoRecords.add(productoRecord1);
        productoRecords.add(productoRecord2);
        productoRecords.add(productoRecord3);


        for (ProductoRecord productoRecord:productoRecords){
            System.out.println(productoRecord);

        }



    }
}