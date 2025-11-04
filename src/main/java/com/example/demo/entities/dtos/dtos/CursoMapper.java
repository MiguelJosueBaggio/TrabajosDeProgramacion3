package com.example.demo.entities.dtos.dtos;

import com.example.demo.entities.dtos.Alumno;
import com.example.demo.entities.dtos.Curso;
import com.example.demo.entities.dtos.Profesor;
import com.example.demo.repositories.AlumnoRepository;
import com.example.demo.repositories.CursoRepository;
import com.example.demo.repositories.ProfesorRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CursoMapper {
    public static CursoDto toDTO(Curso curso){
        CursoDto cursoDto = new CursoDto.CursoDtoBuilder()
                .id(curso.getId())
                .profesor_Nombre(curso.getProfesor().getNombre())
                .nombre(curso.getNombre())

                .build();

        if (cursoDto.getAlumnos_nombres() != null && !cursoDto.getAlumnos_nombres().isEmpty()) {
            List<Alumno> alumnos = cursoDto.getAlumnos_nombres() .stream()
                    .map(nombre -> Alumno.builder().nombre(nombre).build())
                    .collect(Collectors.toList());
            curso.setAlumnos(alumnos);
        }


        return cursoDto;
    }

    public static Curso toEntity(CursoCreate cursoCreate){
        Curso curso = new Curso();
        curso.setNombre(cursoCreate.getNombre());
       /* if (cursoCreate.getId_profesor() != null) {
            Profesor profesor = profesorRepository.findById(cursoCreate.getId_profesor())
                    .orElseThrow(() -> new RuntimeException("profesor"));
            curso.setProfesor(profesor);
        }*/


      /*  if(cursoCreate.getAlumnos_id() != null && !cursoCreate.getAlumnos_id().isEmpty()){
            List<Alumno> alumnos = alumnoRepository.findAllById(cursoCreate.getAlumnos_id());
            curso.setAlumnos(alumnos);
        }*/



        return curso;
    }





}
