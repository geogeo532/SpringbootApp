package com.aplicatie.Corbeanu_George_java_app.controller;

import com.aplicatie.Corbeanu_George_java_app.model.StatisticaEchipe;
import com.aplicatie.Corbeanu_George_java_app.model.StatisticaEchipeId;
import com.aplicatie.Corbeanu_George_java_app.service.StatisticaEchipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/api")
public class StatisticaEchipeController {

    @Autowired
    private StatisticaEchipeService statisticaEchipeService;

    // Save a new team statistics
    @PostMapping("/statisticaEchipe")
    public StatisticaEchipe save(@RequestBody StatisticaEchipe statisticaEchipe) {
        statisticaEchipeService.save(statisticaEchipe);
        return statisticaEchipe;
    }

    // Get all team statistics
    @GetMapping("/statisticaEchipe")
    public List<StatisticaEchipe> get() {
        return statisticaEchipeService.get();
    }

    // Get team statistics by composite key
    @GetMapping("/statisticaEchipe/{id_statistica_echipa}/{id_echipa}")
    public StatisticaEchipe get(@PathVariable int id_statistica_echipa, @PathVariable int id_echipa) {
        StatisticaEchipeId id = new StatisticaEchipeId(id_statistica_echipa, id_echipa);
        StatisticaEchipe statisticaEchipe = statisticaEchipeService.get(id);
        if (statisticaEchipe == null) {
            throw new RuntimeException("Team statistics not found for the Id: " + id);
        }
        return statisticaEchipe;
    }

    // Update team statistics
    @PutMapping("/statisticaEchipe")
    public StatisticaEchipe update(@RequestBody StatisticaEchipe statisticaEchipe) {
        statisticaEchipeService.update(statisticaEchipe);
        return statisticaEchipe;
    }

    // Delete team statistics by composite key
    @DeleteMapping("/statisticaEchipe/{id_statistica_echipa}/{id_echipa}")
    public String delete(@PathVariable int id_statistica_echipa, @PathVariable int id_echipa) {
        StatisticaEchipeId id = new StatisticaEchipeId(id_statistica_echipa, id_echipa);
        statisticaEchipeService.delete(id);
        return "Team statistics has been deleted with ID: " + id;
    }
}
