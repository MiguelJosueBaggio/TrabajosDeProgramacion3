package com.example.demo.controllers;

import com.example.demo.entities.dtos.dtos.*;

import com.example.demo.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(
        origins = "http://localhost:5173",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE},
        allowedHeaders = "*"
)
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    CursoService cursoService;

    @PostMapping("")
    public ResponseEntity<?> crear (@RequestBody CursoCreate c){
        try {
            CursoDto cursoCreado = cursoService.crear(c);
            if (cursoCreado == null) {
                return ResponseEntity.badRequest().body("El curso ya está registrado");
            }
            return ResponseEntity.ok(cursoCreado);

        }catch (Exception e){
            //prueba
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Ocurrio un error: " + e.getMessage());

        }
    }

    @PutMapping ("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody CursoEdit cursoEdit){
        try {
            return ResponseEntity.ok().body(cursoService.actualizar(id,cursoEdit));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ocurrio un error: " + e.getMessage());
        }

    }

    @DeleteMapping("/{id}")

    public ResponseEntity<?>borrar(@PathVariable Long id){
        try {
            cursoService.eliminar(id);
            return ResponseEntity.ok().body("Entidad eliminada");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ocurrio un error " +e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<?> buscaTodos(){
        try {
            return ResponseEntity.ok().body(cursoService.buscaTodos());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ocurrio un error " +e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaId(@PathVariable Long id){
        try{
            return ResponseEntity.ok(cursoService.buscaId(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ocurrio un error " +e.getMessage());
        }
    }






        @PutMapping("agregarAlumnoExistente/{Curso_Id}/{Alumno_id}")
        public ResponseEntity<?> agregarAlumnoExistente(@PathVariable Long curso_Id, @PathVariable Long alumno_Id){
            try{
                cursoService.agregarAlumnoExistente(curso_Id,alumno_Id);
                return ResponseEntity.ok("Estudiante agregado con exito");
            }catch (Exception e ){
                e.printStackTrace();
                return ResponseEntity.badRequest().body("Ocurrio un error del tipo " + e.getClass() + " \nMensaje: " + e.getMessage());

            }
        }




}



