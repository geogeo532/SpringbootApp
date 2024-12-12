package com.aplicatie.Corbeanu_George_java_app.controller;

import com.aplicatie.Corbeanu_George_java_app.DTO.StadionDTO;
import com.aplicatie.Corbeanu_George_java_app.model.Stadion;
import com.aplicatie.Corbeanu_George_java_app.service.StadionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/api")
public class StadionController {

    @Autowired
    private StadionService stadionService;

    // Save a new stadion
    @PostMapping("/stadion")
    public Stadion save(@RequestBody Stadion stadionObj) {
        stadionService.save(stadionObj);
        return stadionObj;
    }

    // Get all stadioane
    @GetMapping("/stadion")
    public List<StadionDTO> getStadioane() {
        return stadionService.getStadioane();
    }

    // Get a stadion by ID
    @GetMapping("/stadion/{id}")
    public Stadion get(@PathVariable int id) {
        Stadion stadionObj = stadionService.get(id);
        if (stadionObj == null) {
            throw new RuntimeException("Stadion not found for the Id:" + id);
        }
        return stadionObj;
    }

    // Update an existing stadion
    @PutMapping("/stadion")
    public Stadion update(@RequestBody Stadion stadionObj) {
        stadionService.update(stadionObj);
        return stadionObj;
    }

    // Delete a stadion by ID
    @DeleteMapping("/stadion/{id}")
    public String delete(@PathVariable int id) {
        stadionService.delete(id);
        return "Stadion has been deleted with id:" + id;
    }
}
