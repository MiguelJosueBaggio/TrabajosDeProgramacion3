package com.example.demo.entities.dtos.dtos;

import com.example.demo.entities.dtos.Alumno;

import java.util.List;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CursoEdit {
    private String dni;
    private String nombre;
    private Long profesor_id;
    private List<Alumno>alumnos;
}
