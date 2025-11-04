package com.example.demo.entities.dtos.dtos;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class CursoCreate {


    private String nombre;
    private Long id_profesor;
    private List<Long>alumnos_id;
}
