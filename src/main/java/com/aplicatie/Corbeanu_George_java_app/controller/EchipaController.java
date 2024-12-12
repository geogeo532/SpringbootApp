package com.aplicatie.Corbeanu_George_java_app.controller;

import java.util.List;

import com.aplicatie.Corbeanu_George_java_app.DTO.EchipaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.aplicatie.Corbeanu_George_java_app.model.Echipa;
import com.aplicatie.Corbeanu_George_java_app.service.EchipaService;

@RestController
@RequestMapping("/admin/api")
public class EchipaController {

    @Autowired
    private EchipaService echipaService;

    // Save a new team
    @PostMapping("/echipa")
    public Echipa save(@RequestBody Echipa echipaObj) {
        echipaService.save(echipaObj);
        return echipaObj;
    }

    // Get all teams
    @GetMapping("/echipa")
    public List<EchipaDTO> get() {
        return echipaService.getEchipe();
    }

    // Get a team by ID
    @GetMapping("/echipa/{id}")
    public Echipa get(@PathVariable int id) {
        Echipa echipaObj = echipaService.get(id);
        if (echipaObj == null) {
            throw new RuntimeException("Team not found for the Id:" + id);
        }
        return echipaObj;
    }

    // Update an existing team
    @PutMapping("/echipa")
    public Echipa update(@RequestBody Echipa echipaObj) {
        echipaService.update(echipaObj);
        return echipaObj;
    }

    // Delete a team by ID
    @DeleteMapping("/echipa/{id}")
    public String delete(@PathVariable int id) {
        echipaService.delete(id);
        return "Team has been deleted with id:" + id;
    }
}
