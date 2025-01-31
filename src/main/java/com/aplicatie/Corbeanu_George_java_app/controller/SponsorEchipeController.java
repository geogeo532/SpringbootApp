/** Clasa pentru controlerul clasei SponsorEchipe
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */




package com.aplicatie.Corbeanu_George_java_app.controller;

import com.aplicatie.Corbeanu_George_java_app.model.SponsorEchipe;
import com.aplicatie.Corbeanu_George_java_app.model.SponsorEchipeId;
import com.aplicatie.Corbeanu_George_java_app.service.SponsorEchipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/api")
public class SponsorEchipeController {

    @Autowired
    private SponsorEchipeService sponsorEchipeService;

    // Save a new sponsor for a team
    @PostMapping("/sponsorEchipe")
    public SponsorEchipe save(@RequestBody SponsorEchipe sponsorEchipeObj) {
        sponsorEchipeService.save(sponsorEchipeObj);
        return sponsorEchipeObj;
    }

    // Get all sponsors for teams
    @GetMapping("/sponsorEchipe")
    public List<SponsorEchipe> get() {
        return sponsorEchipeService.get();
    }

    // Get a sponsor for a team by composite key
    @GetMapping("/sponsorEchipe/{id_sponsor}/{id_echipa}")
    public SponsorEchipe get(@PathVariable int id_sponsor, @PathVariable int id_echipa) {
        // Creating the composite key using the path variables
        SponsorEchipeId sponsorEchipeId = new SponsorEchipeId(id_sponsor, id_echipa);
        return sponsorEchipeService.get(sponsorEchipeId);
    }

    // Update sponsor information for a team
    @PutMapping("/sponsorEchipe")
    public SponsorEchipe update(@RequestBody SponsorEchipe sponsorEchipeObj) {
        sponsorEchipeService.update(sponsorEchipeObj);
        return sponsorEchipeObj;
    }

    // Delete sponsor for a team by composite key
    @DeleteMapping("/sponsorEchipe/{id_sponsor}/{id_echipa}")
    public String delete(@PathVariable int id_sponsor, @PathVariable int id_echipa) {
        SponsorEchipeId sponsorEchipeId = new SponsorEchipeId(id_sponsor, id_echipa);
        sponsorEchipeService.delete(sponsorEchipeId);
        return "Sponsor for team has been deleted with id_sponsor: " + id_sponsor + " and id_echipa: " + id_echipa;
    }
}
