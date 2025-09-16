package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        List<String>nombres = new ArrayList<>();

        nombres.add("Miguel");
        nombres.add("Josue");
        nombres.add("Baggio");

        List<Integer>numeros= new ArrayList<>();

        numeros.add(39);
        numeros.add(18);
        numeros.add(25);

        util.imprimirLista(nombres);
        util.imprimirLista(numeros);
    }
}