package com.example.demo.entities.dtos.dtos;

import com.example.demo.entities.dtos.Alumno;
import com.example.demo.entities.dtos.Curso;

import java.util.List;
import java.util.stream.Collectors;

public class  AlumnoMapper {
//Oobtenesmoa datos a traves de la base de datos
    public static AlumnoDto toDTO(Alumno alumno){
        AlumnoDto alumnoDto = new AlumnoDto.AlumnoDtoBuilder()
                .id(alumno.getId())
                .edad(alumno.getEdad())
                .nombre(alumno.getNombre())
                .apellido(alumno.getApellido())
                .dni(alumno.getDni())
                .build();

       if (alumnoDto.getCursosNombres() != null && !alumnoDto.getCursosNombres().isEmpty()) {
            List<Curso> cursos = alumnoDto.getCursosNombres() .stream()
                    .map(nombre -> Curso.builder().nombre(nombre).build())
                    .collect(Collectors.toList());
            alumno.setCursos(cursos);
        }


        return alumnoDto;
    }//Creamos regidtros a la base de datos a traves delfront end
    public static Alumno toEntity(AlumnoCreate alumnoCreate){
        Alumno alumno = new Alumno();
        alumno.setNombre(alumnoCreate.getNombre());
        alumno.setApellido(alumnoCreate.getApellido());
        alumno.setEdad(alumnoCreate.getEdad());
        alumno.setDni(alumnoCreate.getDni());






        return alumno;
    }
}
