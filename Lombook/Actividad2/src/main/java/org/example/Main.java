package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Usuario usuario1= Usuario.builder()
                .id(1666)
                .email("sksk@mail")
                .nombre("pepe")

                .build();


                Usuario usuario2= Usuario.builder()
                .id(1894)
                .email("jaja@mail")
                .nombre("Luis")

                .build();


                Usuario usuario3= Usuario.builder()
                .id(195)
                .email("mj@mail")
                .nombre("Miguel")

                .build();


        List<Usuario>usuarios= new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        System.out.println(usuarios);

    }
}