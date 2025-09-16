package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {





        Caja<String>cajaString1 = new Caja<>("Perro");
        Caja<String>cajaString2= new Caja<>("Gato");
        Caja<Integer>cajaInte1= new Caja<>(20);
        Caja<Integer>integerCaja2= new Caja<>(5);

           List lista = new ArrayList<>();

           lista.add(cajaString1);
           lista.add(cajaString2);
           lista.add(cajaInte1);
           lista.add(integerCaja2);


           for (Object list:lista){

               System.out.println(list);
           }

    }
}