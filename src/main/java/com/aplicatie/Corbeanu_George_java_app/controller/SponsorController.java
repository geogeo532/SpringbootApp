package com.aplicatie.Corbeanu_George_java_app.controller;

import com.aplicatie.Corbeanu_George_java_app.model.Sponsor;
import com.aplicatie.Corbeanu_George_java_app.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/api")
public class SponsorController {

    @Autowired
    private SponsorService sponsorService;

    // Save a new sponsor
    @PostMapping("/sponsor")
    public Sponsor save(@RequestBody Sponsor sponsorObj) {
        sponsorService.save(sponsorObj);
        return sponsorObj;
    }

    // Get all sponsors
    @GetMapping("/sponsor")
    public List<Sponsor> get() {
        return sponsorService.get();
    }

    // Get a sponsor by ID
    @GetMapping("/sponsor/{id}")
    public Sponsor get(@PathVariable int id) {
        Sponsor sponsorObj = sponsorService.get(id);
        if (sponsorObj == null) {
            throw new RuntimeException("Sponsor not found for the Id:" + id);
        }
        return sponsorObj;
    }

    // Update an existing sponsor
    @PutMapping("/sponsor")
    public Sponsor update(@RequestBody Sponsor sponsorObj) {
        sponsorService.update(sponsorObj);
        return sponsorObj;
    }

    // Delete a sponsor by ID
    @DeleteMapping("/sponsor/{id}")
    public String delete(@PathVariable int id) {
        sponsorService.delete(id);
        return "Sponsor has been deleted with id:" + id;
    }
}
