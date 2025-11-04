package com.example.demo.entities.dtos;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private int edad;

    @Builder.Default
    private boolean eliminado = false;


    @ManyToMany
    @JoinTable(
            name = "alumno_curso",
            joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    @Builder.Default
    private List<Curso> cursos = new ArrayList<>();

    public void agregarCursos(Curso curso){
        if (!cursos.contains(curso)) {
            cursos.add(curso);

        }
    }

}
