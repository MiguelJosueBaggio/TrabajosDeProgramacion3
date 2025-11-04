package com.example.demo.entities.dtos.dtos;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder


public class CursoDto {
     private Long id;
    private String nombre;

    private String profesor_Nombre;
    private List<String> alumnos_nombres;

}
