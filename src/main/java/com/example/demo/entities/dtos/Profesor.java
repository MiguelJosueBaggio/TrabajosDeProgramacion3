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
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private int edad;
  @OneToMany
    @JoinColumn(name = "profesor_Id")
    @Builder.Default
    private List<Curso>cursos = new ArrayList<>();

    @Builder.Default
    private boolean eliminado = false;

    public void agregarCursos(Curso curso){
        if (!cursos.contains(curso)) {
            cursos.add(curso);

        }
    }
}
