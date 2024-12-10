package com.aplicatie.Corbeanu_George_java_app.controller;

import com.aplicatie.Corbeanu_George_java_app.model.StatisticaJucatori;
import com.aplicatie.Corbeanu_George_java_app.model.StatisticaJucatoriId;
import com.aplicatie.Corbeanu_George_java_app.service.StatisticaJucatoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/api")
public class StatisticaJucatoriController {

    @Autowired
    private StatisticaJucatoriService statisticaJucatoriService;

    // Save a new player statistics
    @PostMapping("/statisticaJucatori")
    public StatisticaJucatori save(@RequestBody StatisticaJucatori statisticaJucatori) {
        statisticaJucatoriService.save(statisticaJucatori);
        return statisticaJucatori;
    }

    // Get all player statistics
    @GetMapping("/statisticaJucatori")
    public List<StatisticaJucatori> get() {
        return statisticaJucatoriService.get();
    }

    // Get player statistics by composite key
    @GetMapping("/statisticaJucatori/{id_statistica}/{id_jucator}")
    public StatisticaJucatori get(@PathVariable int id_statistica, @PathVariable int id_jucator) {
        StatisticaJucatoriId id = new StatisticaJucatoriId(id_statistica, id_jucator);
        StatisticaJucatori statisticaJucatori = statisticaJucatoriService.get(id);
        if (statisticaJucatori == null) {
            throw new RuntimeException("Player statistics not found for the Id: " + id);
        }
        return statisticaJucatori;
    }

    // Update player statistics
    @PutMapping("/statisticaJucatori")
    public StatisticaJucatori update(@RequestBody StatisticaJucatori statisticaJucatori) {
        statisticaJucatoriService.update(statisticaJucatori);
        return statisticaJucatori;
    }

    // Delete player statistics by composite key
    @DeleteMapping("/statisticaJucatori/{id_statistica}/{id_jucator}")
    public String delete(@PathVariable int id_statistica, @PathVariable int id_jucator) {
        StatisticaJucatoriId id = new StatisticaJucatoriId(id_statistica, id_jucator);
        statisticaJucatoriService.delete(id);
        return "Player statistics has been deleted with ID: " + id;
    }


}
