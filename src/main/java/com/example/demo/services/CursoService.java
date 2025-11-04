package com.example.demo.services;

import com.example.demo.entities.dtos.Curso;
import com.example.demo.entities.dtos.dtos.*;

import java.util.List;

public interface CursoService {

    public CursoDto crear(CursoCreate c);
    public CursoDto actualizar(Long id, CursoEdit c);
    public CursoDto buscaId(Long id);
    public List<CursoDto> buscaTodos();
    public void eliminar(Long id);
    public CursoDto agregarAlumnoExistente (Long curso_Id, Long alumno_Id);


}
