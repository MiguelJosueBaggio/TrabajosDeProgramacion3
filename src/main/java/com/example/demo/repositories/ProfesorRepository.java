package com.example.demo.repositories;

import com.example.demo.entities.dtos.Alumno;
import com.example.demo.entities.dtos.Curso;
import com.example.demo.entities.dtos.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfesorRepository extends JpaRepository<Profesor,Long> {

    List<Profesor> findAllByEliminadoFalse();

    Optional<Profesor> findByIdAndEliminadoFalse(Long id);

}
