package com.example.demo.entities.dtos;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Curso {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "profesor_id") // clave foránea
    private Profesor profesor;

    @ManyToMany(mappedBy = "cursos")
    private List<Alumno> alumnos;

    public void agregarAlumno (Alumno alumno){
        if (!alumnos.contains(alumno)) {
            alumnos.add(alumno);

        }
    }

    @Builder.Default
    private boolean eliminado = false;
}
