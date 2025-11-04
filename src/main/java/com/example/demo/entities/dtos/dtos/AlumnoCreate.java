package com.example.demo.entities.dtos.dtos;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AlumnoCreate {

    private String nombre;
    private String apellido;
    private String dni;
    private int edad;
    private List<Long> id_cursos;


}
