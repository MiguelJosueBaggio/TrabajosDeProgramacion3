package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        Producto producto1 = Producto.builder()
                .codigo("A1")
                .nombre("CPU")
                .precio(15000.5)
                .autor("Jobs")
                .build();




        Producto producto2 = Producto.builder()
                .codigo("A2")
                .nombre("Mouse")
                .precio(1000.5)
                .autor("Gate")
                .build();

        Producto producto3 = Producto.builder()
                .codigo("B1")
                .nombre("Pantalla")
                .precio(2000.5)
                .autor("Musk")
                .build();


        ProductoDTO productoDTO1 = new ProductoDTO();
        productoDTO1.setCodigo("A1");
        productoDTO1.setNombre("CPU");
        productoDTO1.setPrecio(15000.5);

        ProductoDTO productoDTO2 = new ProductoDTO();
        productoDTO2.setCodigo("A2");
        productoDTO2.setNombre("Mouse");
        productoDTO2.setPrecio(1000.5);

        ProductoDTO productoDTO3 = new ProductoDTO();
        productoDTO3.setCodigo("B1");
        productoDTO3.setNombre("Pantalla");
        productoDTO3.setPrecio(2000.5);


        List<ProductoDTO>productoDTOS = new ArrayList<>();
        productoDTOS.add(productoDTO1);
        productoDTOS.add(productoDTO2);
        productoDTOS.add(productoDTO3);


        for (ProductoDTO productoDTO:productoDTOS){

            System.out.println(productoDTO);
        }


    }
}