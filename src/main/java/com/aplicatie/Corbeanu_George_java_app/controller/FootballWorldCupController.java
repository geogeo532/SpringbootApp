package com.aplicatie.Corbeanu_George_java_app.controller;

import com.aplicatie.Corbeanu_George_java_app.service.*;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api")
public class FootballWorldCupController {

    private final ClasamentService clasamentService;
    private final EchipaService echipaService;
    private final JucatorService jucatorService;
    private final MeciService meciService;
    private final SponsorService sponsorService;
    private final SponsorEchipeService sponsorEchipeService;
    private final StadionService stadionService;
    private final StatisticaEchipeService statisticaEchipeService;
    private final StatisticaJucatoriService statisticaJucatoriService;

    // Constructor for dependency injection
    public FootballWorldCupController(ClasamentService clasamentService, EchipaService echipaService,
                                      JucatorService jucatorService, MeciService meciService,
                                      SponsorService sponsorService, SponsorEchipeService sponsorEchipeService,
                                      StadionService stadionService, StatisticaEchipeService statisticaEchipeService,
                                      StatisticaJucatoriService statisticaJucatoriService) {
        this.clasamentService = clasamentService;
        this.echipaService = echipaService;
        this.jucatorService = jucatorService;
        this.meciService = meciService;
        this.sponsorService = sponsorService;
        this.sponsorEchipeService = sponsorEchipeService;
        this.stadionService = stadionService;
        this.statisticaEchipeService = statisticaEchipeService;
        this.statisticaJucatoriService = statisticaJucatoriService;
    }

    @GetMapping("/{tableName}")
    public ResponseEntity<List<?>> getTableData(@PathVariable String tableName) {
        try {
            switch (tableName.toLowerCase()) {
                case "clasamente":
                    return ResponseEntity.ok(clasamentService.getClasaments());
                case "echipe":
                    return ResponseEntity.ok(echipaService.getEchipe());
                case "jucatori":
                    return ResponseEntity.ok(jucatorService.getJucatori());
                case "meciuri":
                    return ResponseEntity.ok(meciService.getMeciuri());
                case "sponsori":
                    return ResponseEntity.ok(sponsorService.getSponsori());
                case "sponsori_echipe":
                    return ResponseEntity.ok(sponsorEchipeService.get());
                case "stadioane":
                    return ResponseEntity.ok(stadionService.getStadioane());
                case "statistici_echipe":
                    return ResponseEntity.ok(statisticaEchipeService.get());
                case "statistici_jucatori":
                    return ResponseEntity.ok(statisticaJucatoriService.get());
                default:
                    return ResponseEntity.badRequest().body(List.of("Table not found!"));
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(List.of("Error processing request"));
        }
    }

}
