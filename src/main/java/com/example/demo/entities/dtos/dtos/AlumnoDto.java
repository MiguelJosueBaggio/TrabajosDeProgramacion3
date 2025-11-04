package com.example.demo.entities.dtos.dtos;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class AlumnoDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private int edad;
    private List<String> cursosNombres;
}
