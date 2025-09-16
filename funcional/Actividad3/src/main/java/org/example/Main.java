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

        Alumno alumno1 = new Alumno("Juan",5,"Matematicas");
        Alumno alumno2 = new Alumno("Pedro",3,"Matematicas");
        Alumno alumno3 = new Alumno("Miguel",9,"Matematicas");
        Alumno alumno4 = new Alumno("Eduardo",7,"Lengua");
        Alumno alumno5 = new Alumno("Alberto",6,"Lengua");
        Alumno alumno6 = new Alumno("Matias",10,"Lengua");

        List<Alumno>list = Arrays.asList(alumno1,alumno2,alumno3,alumno4,alumno5,alumno6);
        //operacion intermedia

        System.out.println("Filter: ");
        List<String> filters = list.stream()
                .filter(alumno -> alumno.nota() >= 7)
                .map(alumno -> alumno.nombre().toUpperCase())
                .sorted()
                .collect(Collectors.toList());

        System.out.println(filters);


        double promedio = list.stream()
                .mapToInt(Alumno::nota)
                .average()
                .orElse(0.0);

        System.out.println("El promedio es " + promedio);

        Map<String, List<Alumno>> agrupadosPorCurso = list.stream()
                .collect(Collectors.groupingBy(Alumno::curso));


        agrupadosPorCurso.forEach((curso, alumnos) ->
                System.out.println(curso + " -> " + alumnos));



        List<Alumno> top3 = list.stream()
                .sorted(Comparator.comparingInt(Alumno::nota).reversed())
                .limit(3)
                .collect(Collectors.toList());


        System.out.println(top3);


    }
}