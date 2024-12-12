package com.aplicatie.Corbeanu_George_java_app.controller;

import com.aplicatie.Corbeanu_George_java_app.DTO.MeciDTO;
import com.aplicatie.Corbeanu_George_java_app.model.Meci;
import com.aplicatie.Corbeanu_George_java_app.service.MeciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/api")
public class MeciController {

    @Autowired
    private MeciService meciService;

    // Save a new match
    @PostMapping("/meci")
    public Meci save(@RequestBody Meci meciObj) {
        meciService.save(meciObj);
        return meciObj;
    }

    // Get all matches
    @GetMapping("/meci")
    public List<MeciDTO> getMeciuri() {
        return meciService.getMeciuri();
    }

    // Get a match by ID
    @GetMapping("/meci/{id}")
    public Meci get(@PathVariable int id) {
        Meci meciObj = meciService.get(id);
        if (meciObj == null) {
            throw new RuntimeException("Match not found for the Id:" + id);
        }
        return meciObj;
    }

    // Update an existing match
    @PutMapping("/meci")
    public Meci update(@RequestBody Meci meciObj) {
        meciService.update(meciObj);
        return meciObj;
    }

    // Delete a match by ID
    @DeleteMapping("/meci/{id}")
    public String delete(@PathVariable int id) {
        meciService.delete(id);
        return "Match has been deleted with id:" + id;
    }
}
