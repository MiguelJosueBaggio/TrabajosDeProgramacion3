package com.example.demo.services;

import com.example.demo.entities.dtos.Alumno;
import com.example.demo.entities.dtos.Curso;

import com.example.demo.entities.dtos.dtos.*;
import com.example.demo.repositories.AlumnoRepository;
import com.example.demo.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.apache.coyote.http11.Constants.a;

public class AlumnoServiceImp implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;
    private CursoRepository cursoRepository;

    @Override
    public AlumnoDto crear(AlumnoCreate a) {
        // Se transforma el DTO de creación en una entidad Persona lista para ser persistida.

        Alumno alumno = AlumnoMapper.toEntity(a);

        // Se guarda la entidad en la base de datos a través del repositorio.
        // save() retorna la entidad con el ID generado.
        alumno = alumnoRepository.save(alumno);

        // Se convierte nuevamente la entidad persistida en un DTO de salida.
        // Esto asegura que solo se expongan los datos necesarios.
        AlumnoDto alumnoDto = AlumnoMapper.toDTO(alumno);

        // Se retorna el DTO con la información final (incluye ID generado).
        return alumnoDto;
    }

    @Override
    public AlumnoDto actualizar(Long id, AlumnoEdit a) {
        // Se busca en la base de datos la Persona por su ID.
        // El repositorio retorna un Optional, que puede contener la entidad o estar vacío.
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(id);

        //SOLUCION OPTIMA AUN NO EXPLICADA
        //Persona person = personaRepository.findById(id).orElseThrow(()->new NullPointerException("No se encontró el ID del desarrollador");

        // Se valida si la Persona existe.
        if (alumnoOptional.isPresent()) {
            // Si existe, se obtiene la entidad.
            Alumno alumno = alumnoOptional.get();
            alumno.setDni(a.getDni());
            alumno.setEdad(a.getEdad());

            alumno = alumnoRepository.save(alumno);

            return AlumnoMapper.toDTO(alumno);


        }
        return null;

    }

    @Override
    public AlumnoDto buscaId(Long id) {
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(id);
        if (alumnoOptional.isPresent()) {
            if (!alumnoOptional.get().isEliminado())
                return AlumnoMapper.toDTO(alumnoOptional.get());


        }
        return null;


    }


    @Override
    public List<AlumnoDto> buscaTodos() {
        List<Alumno> alumnos = alumnoRepository.findAllByEliminadoFalse();
        List<AlumnoDto> alumnoDtos = alumnos.stream().map(AlumnoMapper::toDTO).toList();
        return alumnoDtos;
    }


    @Override
    public void eliminar(Long id) {

        Optional<Alumno> alumno = alumnoRepository.findById(id);
        if (alumno.isPresent()) {
            Alumno a = alumno.get();
            a.setEliminado(true);
            alumnoRepository.save(a);

        }
    }


    public AlumnoDto agregarCursosExistente(Long alumno_Id, Long curso_Id) {
        Optional<Alumno> alumnoOptional = alumnoRepository.findByIdAndEliminadoFalse(alumno_Id);
        if (alumnoOptional.isEmpty()) {
            throw new RuntimeException("alumno no encontrada");
        }
        Alumno alumno = alumnoOptional.get();

        Optional<Curso> cursoOptional = cursoRepository.findByIdAndEliminadoFalse(curso_Id);
        if (cursoOptional.isEmpty()) {
            throw new RuntimeException("curso no encontrado");
        }
        Curso curso = cursoOptional.get();
        alumno.agregarCursos(curso);
        alumno = alumnoRepository.save(alumno);
        return AlumnoMapper.toDTO(alumno);


    }
}