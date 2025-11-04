package com.example.demo.services;

import com.example.demo.entities.dtos.dtos.*;

import java.util.List;

public interface ProfesorService {

    public ProfesorDto crear(ProfesorCreate p);
    public ProfesorDto actualizar(Long id, ProfesorEdit p);
    public ProfesorDto buscaId(Long id);
    public List<ProfesorDto> buscaTodos();
    public void eliminar(Long id);


    public ProfesorDto agregarCursosExistente (Long profesor_Id, Long curso_Id);
}
