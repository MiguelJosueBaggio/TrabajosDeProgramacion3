package com.example.demo.entities.dtos.dtos;

import java.util.List;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class ProfesorDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private int edad;
    private List<String> cursos_nombres;

}
