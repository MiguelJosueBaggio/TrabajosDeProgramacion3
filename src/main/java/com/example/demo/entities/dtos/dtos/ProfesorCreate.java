package com.example.demo.entities.dtos.dtos;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class ProfesorCreate {
    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private int edad;
    private List<Long>cursos_Id;

}
