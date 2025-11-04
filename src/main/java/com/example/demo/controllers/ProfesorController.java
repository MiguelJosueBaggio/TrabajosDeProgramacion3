package com.example.demo.controllers;

import com.example.demo.entities.dtos.Profesor;
import com.example.demo.entities.dtos.dtos.*;
import com.example.demo.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(
        origins = "http://localhost:5173",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE},
        allowedHeaders = "*"
)
@RequestMapping("/profesor")
public class ProfesorController {
    @Autowired
    ProfesorService profesorService;

    @PostMapping("")
    public ResponseEntity<?> crear (@RequestBody ProfesorCreate p){
        try {
            ProfesorDto profesorCreado = profesorService.crear(p);
            if (profesorCreado == null) {
                return ResponseEntity.badRequest().body("El profesor ya está registrado");
            }
            return ResponseEntity.ok(profesorCreado);

        }catch (Exception e){
            //prueba
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Ocurrio un error: " + e.getMessage());

        }
    }

    @PutMapping ("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody ProfesorEdit profesorEdit){
        try {
            return ResponseEntity.ok().body(profesorService.actualizar(id,profesorEdit));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ocurrio un error: " + e.getMessage());
        }

    }

    @DeleteMapping("/{id}")

    public ResponseEntity<?>borrar(@PathVariable Long id){
        try {
            profesorService.eliminar(id);
            return ResponseEntity.ok().body("Entidad eliminada");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ocurrio un error " +e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<?> buscaTodos(){
        try {
            return ResponseEntity.ok().body(profesorService.buscaTodos());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ocurrio un error " +e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaId(@PathVariable Long id){
        try{
            return ResponseEntity.ok(profesorService.buscaId(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ocurrio un error " +e.getMessage());
        }
    }


    @PutMapping("agregarCursoExistente/{Profesor_Id}/{Curso_id}")
    public ResponseEntity<?> agregarCursoExistente(@PathVariable Long profesor_Id, @PathVariable Long curso_Id){
        try{
            profesorService.agregarCursosExistente(profesor_Id,curso_Id);
            return ResponseEntity.ok("Curso agregado con exito");
        }catch (Exception e ){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Ocurrio un error del tipo " + e.getClass() + " \nMensaje: " + e.getMessage());

        }
    }


}



