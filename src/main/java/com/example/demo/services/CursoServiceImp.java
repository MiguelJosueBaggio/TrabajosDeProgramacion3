package com.example.demo.services;


import com.example.demo.entities.dtos.Alumno;
import com.example.demo.entities.dtos.Curso;
import com.example.demo.entities.dtos.dtos.*;

import com.example.demo.repositories.AlumnoRepository;
import com.example.demo.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CursoServiceImp implements CursoService{

    @Autowired
    private CursoRepository cursoRepository;
    private AlumnoRepository alumnoRepository;

    @Override
    public CursoDto crear(CursoCreate c) {
        // Se transforma el DTO de creación en una entidad Persona lista para ser persistida.

        Curso curso = CursoMapper.toEntity(c);

        // Se guarda la entidad en la base de datos a través del repositorio.
        // save() retorna la entidad con el ID generado.
        curso = cursoRepository.save(curso);

        // Se convierte nuevamente la entidad persistida en un DTO de salida.
        // Esto asegura que solo se expongan los datos necesarios.
        CursoDto cursoDto = CursoMapper.toDTO(curso);

        // Se retorna el DTO con la información final (incluye ID generado).
        return cursoDto;
    }

    @Override
    public CursoDto actualizar(Long id, CursoEdit c) {
        // Se busca en la base de datos la Persona por su ID.
        // El repositorio retorna un Optional, que puede contener la entidad o estar vacío.
        Optional<Curso> cursoOptional = cursoRepository.findById(id);

        //SOLUCION OPTIMA AUN NO EXPLICADA
        //Persona person = personaRepository.findById(id).orElseThrow(()->new NullPointerException("No se encontró el ID del desarrollador");

        // Se valida si la Persona existe.
        if (cursoOptional.isPresent()) {
            // Si existe, se obtiene la entidad.
            Curso curso = cursoOptional.get();
            curso.setNombre(c.getNombre());

            curso = cursoRepository.save(curso);

            return CursoMapper.toDTO(curso);


        } return null;

    }

    @Override
    public CursoDto buscaId(Long id){
        Optional<Curso> cursoOptional=cursoRepository.findById(id);
        if (cursoOptional.isPresent()) {
            if (!cursoOptional.get().isEliminado())
                return CursoMapper.toDTO(cursoOptional.get());



        }return null;



    }



    @Override
    public List<CursoDto> buscaTodos(){
        List<Curso>cursos=cursoRepository.findAllByEliminadoFalse();
        List<CursoDto>cursoDtos= cursos.stream().map(CursoMapper::toDTO).toList();
        return cursoDtos;
    }


    @Override
    public void eliminar (Long id){

        Optional<Curso> curso = cursoRepository.findById(id);
        if (curso.isPresent()) {
            Curso c =curso.get();
            c.setEliminado(true);
            cursoRepository.save(c);

        }
    }


    public CursoDto agregarAlumnoExistente (Long curso_Id, Long alumno_Id) {
        Optional<Curso> cursoOptional = cursoRepository.findByIdAndEliminadoFalse(curso_Id);
        if (cursoOptional.isEmpty()) {
            throw new RuntimeException("Categoría no encontrada");
        }
        Curso curso = cursoOptional.get();

        Optional<Alumno> alumnoOptional = alumnoRepository.findByIdAndEliminadoFalse(alumno_Id);
        if (alumnoOptional.isEmpty()) {
            throw new RuntimeException("alumno no encontrado");
        }
        Alumno alumno = alumnoOptional.get();
        curso.agregarAlumno(alumno);
        curso = cursoRepository.save(curso);
        return CursoMapper.toDTO(curso);
    }


}
