package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

      Producto producto1 = new Producto("CPU","Tecnologia",800000,15);
      Producto producto2 = new Producto("Ventiladot","Hogar",8000,150);
        Producto producto3 = new Producto("Estufa","Hogar",8000,154);
        Producto producto4 = new Producto("Celular","Tecnologia",700000,150);
        Producto producto5 = new Producto("Mouse","Tecnologia",500,21);

        List<Producto> productos = Arrays.asList(producto1,producto2,producto3,producto4,producto5);


        List<Producto> resultado = productos.stream()
                .filter(p -> p.precio() > 100)
                .sorted(Comparator.comparingDouble(Producto::precio).reversed())
                .toList();

        resultado.forEach(System.out::println);

          /*Punto2*/


        Map<String, Integer> stockPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::categoria,
                        Collectors.summingInt(Producto::stock)
                ));

        stockPorCategoria.forEach((cat, stock) ->
                System.out.println(cat + " -> " + stock));

              /*punto3*/

        String listado = productos.stream()
                .map(p -> p.precio() + " " + p.precio())
                .collect(Collectors.joining("; "));

        System.out.println(listado);

        /*punto 4*/
        double promedioGeneral = productos.stream()
                .collect(Collectors.averagingDouble(Producto::precio));

        System.out.println("Promedio general: " + promedioGeneral);



        Map<String, Double> promedioPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::categoria,
                        Collectors.averagingDouble(Producto::precio)
                ));

        promedioPorCategoria.forEach((cat, prom) ->
                System.out.println(cat + " -> " + prom));




    }
}