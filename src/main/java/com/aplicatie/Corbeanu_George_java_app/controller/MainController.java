/** Clasa pentru indexurile aplicatiei web
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.controller;

import com.aplicatie.Corbeanu_George_java_app.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private final ClasamentService clasamentService;
    private final EchipaService echipaService;
    private final JucatorService jucatorService;
    private final MeciService meciService;
    private final SponsorService sponsorService;
    private final SponsorEchipeService sponsorEchipeService;
    private final StadionService stadionService;
    private final StatisticaEchipeService statisticaEchipeService;
    private final StatisticaJucatoriService statisticaJucatoriService;

    // Constructor pentru injecția dependențelor
    public MainController(ClasamentService clasamentService, EchipaService echipaService,
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

    // Rutele pentru pagini HTML
    @GetMapping("/")
    public String index() {
        return "index"; // Returnează șablonul pentru pagina principală
    }

    @GetMapping("/admin")
    public String adminIndex() {
        return "admin/index_admin"; // Returnează șablonul pentru pagina de admin
    }

    // Rutele API pentru date
    @RestController
    @RequestMapping("/admin/api")
    public static class ApiController {

        private final ClasamentService clasamentService;
        private final EchipaService echipaService;
        private final JucatorService jucatorService;
        private final MeciService meciService;
        private final SponsorService sponsorService;
        private final SponsorEchipeService sponsorEchipeService;
        private final StadionService stadionService;
        private final StatisticaEchipeService statisticaEchipeService;
        private final StatisticaJucatoriService statisticaJucatoriService;

        // Constructor pentru injecția dependențelor
        public ApiController(ClasamentService clasamentService, EchipaService echipaService,
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
}
