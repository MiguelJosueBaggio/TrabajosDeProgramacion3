package com.example.demo.repositories;

import com.example.demo.entities.dtos.Alumno;
import com.example.demo.entities.dtos.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso,Long> {

    List<Curso> findAllByEliminadoFalse();

    Optional<Curso> findByIdAndEliminadoFalse(Long id);


}
