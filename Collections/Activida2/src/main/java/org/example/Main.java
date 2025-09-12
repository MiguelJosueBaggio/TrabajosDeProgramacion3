package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Alumno alumno1 = new Alumno("Juan Perz",9);
        Alumno alumno2 = new Alumno("Carlos Sanchez",8);
        Alumno alumno3 = new Alumno("Miguel Baggio",10);
        Alumno alumno4 = new Alumno("Alberto Rodriguez",7);
        Alumno alumno5 = new Alumno("Jhon Mujica",6);



        List<Alumno>alumnos = new ArrayList<>();
         alumnos.add(alumno1);
         alumnos.add(alumno2);
         alumnos.add(alumno3);
         alumnos.add(alumno1);
         alumnos.add(alumno4);
         alumnos.add(alumno5);




         for (Alumno alumno:alumnos){
             System.out.println(alumno);
         }






    }
}