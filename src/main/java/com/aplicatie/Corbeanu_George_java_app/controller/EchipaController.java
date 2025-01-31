/** Clasa pentru controllerul clasei echipa
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */



package com.aplicatie.Corbeanu_George_java_app.controller;

    import java.util.List;

    import com.aplicatie.Corbeanu_George_java_app.DTO.EchipaDTO;
    import jakarta.validation.Valid;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
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


        @PostMapping("/echipadto")
        public ResponseEntity<String> saveDTO(@Valid @RequestBody EchipaDTO echipaDTO) {
            // Validare manuală pentru câmpurile obligatorii
            if (echipaDTO.getTara() == null || echipaDTO.getTara().trim().isEmpty() ||
                    echipaDTO.getAntrenor() == null || echipaDTO.getAntrenor().trim().isEmpty() ||
                    echipaDTO.getPalmares() == null || echipaDTO.getPalmares().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Toate câmpurile obligatorii (Țară, Antrenor, Palmares) trebuie completate!");
            }

            try {
                echipaService.saveDTO(echipaDTO);
                return ResponseEntity.ok("Echipa a fost salvată cu succes!");
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body("Eroare la salvarea echipei: " + e.getMessage());
            }
        }

        @PutMapping("/echipadto/{tara}")
        public ResponseEntity<String> updateDTO(@Valid @RequestBody EchipaDTO echipaDTO, @PathVariable String tara) {
            // Validare manuală pentru câmpurile obligatorii
            if (echipaDTO.getTara() == null || echipaDTO.getTara().trim().isEmpty() ||
                    echipaDTO.getAntrenor() == null || echipaDTO.getAntrenor().trim().isEmpty() ||
                    echipaDTO.getPalmares() == null || echipaDTO.getPalmares().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Toate câmpurile obligatorii (Țară, Antrenor, Palmares) trebuie completate!");
            }

            try {
                echipaService.updateDTOByTara(echipaDTO, tara);
                return ResponseEntity.ok("Echipa a fost actualizată cu succes!");
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body("Eroare la actualizarea echipei: " + e.getMessage());
            }
        }


        // Delete a team by tara
        @DeleteMapping("/echipadto/{tara}")
        public ResponseEntity<String> deleteDTO(@PathVariable String tara) {
            try {
                echipaService.deleteDTOByTara(tara);
                return ResponseEntity.ok("Echipa a fost ștearsă cu succes!");
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body("Eroare la ștergerea echipei: " + e.getMessage());
            }
        }

        @GetMapping("/coaches-red-cards")
        public List<EchipaDTO> getCoachesWithRedCards() {
            return echipaService.getCoachesWithRedCards();
        }

        @GetMapping("/above-average-scorers")
        public List<EchipaDTO> getTeamsWithAboveAverageScorers() {
            return echipaService.getTeamsWithAboveAverageScorers();
        }

        @GetMapping("/above-average-scorers-param")
        public ResponseEntity<List<EchipaDTO>> getTeamsWithAboveAverageScorers(@RequestParam("minPlayers") int minPlayers) {
            List<EchipaDTO> echipe = echipaService.getTeamsWithAboveAverageScorers(minPlayers);
            if (echipe.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(echipe);
        }
    }
