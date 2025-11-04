package com.example.demo.services;

import com.example.demo.entities.dtos.dtos.AlumnoCreate;
import com.example.demo.entities.dtos.dtos.AlumnoDto;
import com.example.demo.entities.dtos.dtos.AlumnoEdit;
import com.example.demo.entities.dtos.dtos.ProfesorDto;

import java.util.List;

public interface AlumnoService {

    public AlumnoDto crear(AlumnoCreate a);
    public AlumnoDto actualizar(Long id, AlumnoEdit a);
    public AlumnoDto buscaId(Long id);
    public List<AlumnoDto> buscaTodos();
    public void eliminar(Long id);

    public AlumnoDto agregarCursosExistente (Long alumno_Id, Long curso_Id);
}
