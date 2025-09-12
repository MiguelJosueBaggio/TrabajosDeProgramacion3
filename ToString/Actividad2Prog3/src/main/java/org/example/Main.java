package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Estudiante estudiante1= new Estudiante("Julio Verne",30,"Progrmacion");
        Estudiante estudiante2 = new Estudiante("Luis Sanchez",39,"Sistemas");
        Estudiante estudiante3 = new Estudiante("Carlos Ruiz",19,"Ingenieria civil");
        Estudiante estudiante4 = new Estudiante("Juan Baggio",39,"Programacion");

        List<Estudiante> estudiantes = new ArrayList<>();

        estudiantes.add(estudiante1);
        estudiantes.add(estudiante2);
        estudiantes.add(estudiante3);
        estudiantes.add(estudiante4);
        System.out.println(estudiantes );

    }
}