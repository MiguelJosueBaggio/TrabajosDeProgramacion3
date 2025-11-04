package com.example.demo.controllers;

import com.example.demo.entities.dtos.dtos.AlumnoCreate;
import com.example.demo.entities.dtos.dtos.AlumnoDto;
import com.example.demo.entities.dtos.dtos.AlumnoEdit;
import com.example.demo.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(
        origins = "http://localhost:5173",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE},
        allowedHeaders = "*"
)
@RequestMapping("/producto")
public class AlumnoController {
    @Autowired
    AlumnoService alumnoService;

    @PostMapping("")
    public ResponseEntity<?> crear (@RequestBody AlumnoCreate a){
        try {
            AlumnoDto alumnoCreado = alumnoService.crear(a);
            if (alumnoCreado == null) {
                return ResponseEntity.badRequest().body("El alumno ya está registrado");
            }
            return ResponseEntity.ok(alumnoCreado);

        }catch (Exception e){
            //prueba
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Ocurrio un error: " + e.getMessage());

        }
    }

    @PutMapping ("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody AlumnoEdit alumnoEdit){
        try {
            return ResponseEntity.ok().body(alumnoService.actualizar(id,alumnoEdit));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ocurrio un error: " + e.getMessage());
        }

    }

    @DeleteMapping("/{id}")

    public ResponseEntity<?>borrar(@PathVariable Long id){
        try {
            alumnoService.eliminar(id);
            return ResponseEntity.ok().body("Entidad eliminada");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ocurrio un error " +e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<?> buscaTodos(){
        try {
            return ResponseEntity.ok().body(alumnoService.buscaTodos());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ocurrio un error " +e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaId(@PathVariable Long id){
        try{
            return ResponseEntity.ok(alumnoService.buscaId(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ocurrio un error " +e.getMessage());
        }
    }


    @PutMapping("agregarCursoExistente/{Alumno_Id}/{Curso_id}")
    public ResponseEntity<?> agregarCursoExistente(@PathVariable Long alumno_Id, @PathVariable Long curso_Id){
        try{
            alumnoService.agregarCursosExistente(alumno_Id,curso_Id);
            return ResponseEntity.ok("Curso agregado con exito");
        }catch (Exception e ){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Ocurrio un error del tipo " + e.getClass() + " \nMensaje: " + e.getMessage());

        }
    }



}


