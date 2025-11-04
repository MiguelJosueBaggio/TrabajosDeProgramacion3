package com.example.demo.entities.dtos.dtos;

import com.example.demo.entities.dtos.Alumno;
import com.example.demo.entities.dtos.Curso;
import com.example.demo.entities.dtos.Profesor;
import com.example.demo.repositories.CursoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProfesorMapper {

    public static ProfesorDto toDTO(Profesor profe){
        ProfesorDto profeDto = new ProfesorDto.ProfesorDtoBuilder()
                .id(profe.getId())
                .edad(profe.getEdad())
                .nombre(profe.getNombre())
                .apellido(profe.getApellido())
                .dni(profe.getDni())
                .build();

        if (profeDto.getCursos_nombres() != null && !profeDto.getCursos_nombres().isEmpty()) {
            List<Curso> cursos = profeDto.getCursos_nombres() .stream()
                    .map(nombre -> Curso.builder().nombre(nombre).build())
                    .collect(Collectors.toList());
            profe.setCursos(cursos);
        }


        return profeDto;
    }


    public static Profesor toEntity(ProfesorCreate profesorCreate){
        Profesor profe = new Profesor();
        profe.setNombre(profesorCreate.getNombre());
        profe.setApellido(profesorCreate.getApellido());
        profe.setEdad(profesorCreate.getEdad());
        profe.setDni(profesorCreate.getDni());
        profe.setEmail(profesorCreate.getEmail());






        return profe;
    }


}
