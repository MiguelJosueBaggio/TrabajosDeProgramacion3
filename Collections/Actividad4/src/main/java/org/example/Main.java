package org.example;

import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Curso curso1 = new Curso("Matematicas","Gonzalez");
        Curso curso2 = new Curso("Lengua","Fernandez");
        Curso curso3 = new Curso("Historia","Juarez");
        Curso curso4 = new Curso("Sociales","Marinez");
        Curso curso5 = new Curso("Matematicas","Gonzalez");
        Curso curso6 = new Curso("Ingles","Gonzalez");
        Curso curso7 = new Curso("Quimica","Ramirez");

        HashMap<String,Curso>cursos = new HashMap<>();
        cursos.put("c1",curso1);
        cursos.put("c2",curso2);
        cursos.put("c2",curso2);
        cursos.put("c3",curso3);
        cursos.put("c4",curso4);
        cursos.put("c5",curso5);
        cursos.put("c6",curso6);
        cursos.put("c7",curso7);

        System.out.println( cursos.entrySet());;






    }
}