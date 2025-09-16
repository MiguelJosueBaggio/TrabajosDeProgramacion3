package org.example;

import java.util.List;

public class util<T> {


    public static <T>void imprimirLista( List<T> elemento){

        for (T x:elemento){
            System.out.println(x);
        };



    }
}
