package com.aplicatie.Corbeanu_George_java_app.controller;

import com.aplicatie.Corbeanu_George_java_app.DTO.JucatorDTO;
import com.aplicatie.Corbeanu_George_java_app.model.Jucator;
import com.aplicatie.Corbeanu_George_java_app.service.JucatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/api")
public class JucatorController {

    @Autowired
    private JucatorService jucatorService;

    // Save a new player
    @PostMapping("/jucator")
    public Jucator save(@RequestBody Jucator jucator) {
        jucatorService.save(jucator);
        return jucator;
    }

    // Get all players
    @GetMapping("/jucator")
    public List<JucatorDTO> get() {
        return jucatorService.getJucatori();
    }

    @GetMapping("/jucatori/minim")
    public List<JucatorDTO> getJucatori(@RequestParam int minGoals) {
        return jucatorService.getJucatoriByMinGoals(minGoals);
    }

    // Get a player by ID
    @GetMapping("/jucator/{id}")
    public Jucator get(@PathVariable int id) {
        Jucator jucator = jucatorService.get(id);
        if (jucator == null) {
            throw new RuntimeException("Player not found for the Id: " + id);
        }
        return jucator;
    }

    // Update an existing player
    @PutMapping("/jucator")
    public Jucator update(@RequestBody Jucator jucator) {
        jucatorService.update(jucator);
        return jucator;
    }

    // Delete a player by ID
    @DeleteMapping("/jucator/{id}")
    public String delete(@PathVariable int id) {
        jucatorService.delete(id);
        return "Player has been deleted with id: " + id;
    }
}
