package com.aplicatie.Corbeanu_George_java_app.controller;

import com.aplicatie.Corbeanu_George_java_app.model.Clasament;
import com.aplicatie.Corbeanu_George_java_app.model.ClasamentId;
import com.aplicatie.Corbeanu_George_java_app.service.ClasamentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/api")
public class ClasamentController {
    @Autowired
    private ClasamentService clasamentService;

    @GetMapping("/clasament")
    public List<Clasament> get(){
        return clasamentService.getClasaments();
    }

    @PostMapping("/clasament")
    public Clasament save(@RequestBody Clasament clasamentObj){
        clasamentService.save(clasamentObj);
        return clasamentObj;
    }

    @GetMapping("/clasament/{id_clasament}/{id_echipa}")
    public ResponseEntity<Clasament> getClasament(
            @PathVariable("id_clasament") int idClasament,
            @PathVariable("id_echipa") int idEchipa) {
        ClasamentId clasamentId = new ClasamentId(idClasament, idEchipa);
        Clasament clasament = clasamentService.getClasament(clasamentId);
        return ResponseEntity.ok(clasament);
    }

    @DeleteMapping("/clasament/{id_clasament}/{id_echipa}")
    public ResponseEntity<Void> deleteClasament(
            @PathVariable("id_clasament") int idClasament,
            @PathVariable("id_echipa") int idEchipa) {
        ClasamentId clasamentId = new ClasamentId(idClasament, idEchipa);
        try {
            clasamentService.delete(clasamentId);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/clasament/{id_clasament}")
    public ResponseEntity<String> deleteClasament(@PathVariable int id_clasament) {
        try {
            clasamentService.deleteByClasamentId(id_clasament);
            return ResponseEntity.ok("Clasament deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting clasament");
        }
    }


    @DeleteMapping("/clasament/echipa/{id_echipa}")
    public ResponseEntity<Void> deleteByEchipaId(@PathVariable("id_echipa") int idEchipa) {
        try {
            clasamentService.deleteByEchipaId(idEchipa);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/clasament")
    public ResponseEntity<Clasament> update(@RequestBody Clasament clasamentObj) {
        ClasamentId clasamentId = new ClasamentId(clasamentObj.getId_clasament(), clasamentObj.getId_echipa());
        Clasament existingClasament = clasamentService.getClasament(clasamentId);

        if (existingClasament == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        clasamentService.update(clasamentObj);
        return ResponseEntity.ok(clasamentObj);
    }

}
