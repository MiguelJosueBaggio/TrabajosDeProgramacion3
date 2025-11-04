package com.example.demo.services;

import com.example.demo.entities.dtos.Alumno;
import com.example.demo.entities.dtos.Curso;
import com.example.demo.entities.dtos.Profesor;
import com.example.demo.entities.dtos.dtos.*;
import com.example.demo.repositories.AlumnoRepository;
import com.example.demo.repositories.CursoRepository;
import com.example.demo.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProfesorServiceImp implements ProfesorService {


    @Autowired
    private ProfesorRepository profesorRepository;
     private CursoRepository cursoRepository;
    @Override
    public ProfesorDto crear(ProfesorCreate p) {
        // Se transforma el DTO de creación en una entidad Persona lista para ser persistida.

        Profesor profesor = ProfesorMapper.toEntity(p);

        // Se guarda la entidad en la base de datos a través del repositorio.
        // save() retorna la entidad con el ID generado.
        profesor = profesorRepository.save(profesor);

        // Se convierte nuevamente la entidad persistida en un DTO de salida.
        // Esto asegura que solo se expongan los datos necesarios.
        ProfesorDto profesorDto = ProfesorMapper.toDTO(profesor);

        // Se retorna el DTO con la información final (incluye ID generado).
        return profesorDto;
    }

    @Override
    public ProfesorDto actualizar(Long id, ProfesorEdit p) {
        // Se busca en la base de datos la Persona por su ID.
        // El repositorio retorna un Optional, que puede contener la entidad o estar vacío.
        Optional<Profesor> profesorOptional = profesorRepository.findById(id);

        //SOLUCION OPTIMA AUN NO EXPLICADA
        //Persona person = personaRepository.findById(id).orElseThrow(()->new NullPointerException("No se encontró el ID del desarrollador");

        // Se valida si la Persona existe.
        if (profesorOptional.isPresent()) {
            // Si existe, se obtiene la entidad.
            Profesor profesor = profesorOptional.get();
            profesor.setDni(p.getDni());
            profesor.setEdad(p.getEdad());
            profesor.setEmail(p.getEmail());

            profesor = profesorRepository.save(profesor);

            return ProfesorMapper.toDTO(profesor);


        } return null;

    }

    @Override
    public ProfesorDto buscaId(Long id){
        Optional<Profesor> profesorOptional=profesorRepository.findById(id);
        if (profesorOptional.isPresent()) {
            if (!profesorOptional.get().isEliminado())
                return ProfesorMapper.toDTO(profesorOptional.get());



        }return null;



    }



    @Override
    public List<ProfesorDto> buscaTodos(){
        List<Profesor>profesors=profesorRepository.findAllByEliminadoFalse();
        List<ProfesorDto>profesorDtos= profesors.stream().map(ProfesorMapper::toDTO).toList();
        return profesorDtos;
    }


    @Override
    public void eliminar (Long id){

        Optional<Profesor> profesor = profesorRepository.findById(id);
        if (profesor.isPresent()) {
            Profesor p =profesor.get();
            p.setEliminado(true);
            profesorRepository.save(p);

        }
    }


    public ProfesorDto  agregarCursosExistente (Long profesor_Id, Long curso_Id) {
        Optional<Profesor> profesorOptional = profesorRepository.findByIdAndEliminadoFalse(profesor_Id);
        if (profesorOptional.isEmpty()) {
            throw new RuntimeException("prfesor no encontrada");
        }
        Profesor profesor = profesorOptional.get();

        Optional<Curso> cursoOptional = cursoRepository.findByIdAndEliminadoFalse(curso_Id);
        if (cursoOptional.isEmpty()) {
            throw new RuntimeException("curso no encontrado");
        }
        Curso curso = cursoOptional.get();
        profesor.agregarCursos(curso);
        profesor = profesorRepository.save(profesor);
        return ProfesorMapper.toDTO(profesor);
    }






}
