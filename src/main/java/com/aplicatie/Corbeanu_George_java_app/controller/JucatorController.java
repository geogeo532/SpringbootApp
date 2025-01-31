/** Clasa pentru controllerul clasei jucator
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */

package com.aplicatie.Corbeanu_George_java_app.controller;

import com.aplicatie.Corbeanu_George_java_app.DTO.JucatorDTO;
import com.aplicatie.Corbeanu_George_java_app.model.Jucator;
import com.aplicatie.Corbeanu_George_java_app.service.JucatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/admin/api")
public class JucatorController {

    @Autowired
    private JucatorService jucatorService;

    // Save a new player
    @PostMapping("/jucator")
    public Jucator save(@RequestBody Jucator jucator) {
        jucatorService.save(jucator);
        return jucator;
    }

    // Get all players
    @GetMapping("/jucator")
    public List<JucatorDTO> get() {
        return jucatorService.getJucatori();
    }

    @GetMapping("/jucatori/minim")
    public List<JucatorDTO> getJucatori(@RequestParam int minGoals) {
        return jucatorService.getJucatoriByMinGoals(minGoals);
    }

    // Get a player by ID
    @GetMapping("/jucator/{id}")
    public Jucator get(@PathVariable int id) {
        Jucator jucator = jucatorService.get(id);
        if (jucator == null) {
            throw new RuntimeException("Player not found for the Id: " + id);
        }
        return jucator;
    }

    // Update an existing player
    @PutMapping("/jucator")
    public Jucator update(@RequestBody Jucator jucator) {
        jucatorService.update(jucator);
        return jucator;
    }

    // Delete a player by ID
    @DeleteMapping("/jucator/{id}")
    public String delete(@PathVariable int id) {
        jucatorService.delete(id);
        return "Player has been deleted with id: " + id;
    }

    @PostMapping("/jucatordto")
    public ResponseEntity<String> saveDTO(@RequestBody JucatorDTO jucatorDTO) {
        // Validare manuală pentru câmpurile obligatorii
        if (jucatorDTO.getNume_jucator() == null || jucatorDTO.getNume_jucator().trim().isEmpty() ||
                jucatorDTO.getTara() == null || jucatorDTO.getTara().trim().isEmpty() ||
                jucatorDTO.getPozitie_jucata() == null || jucatorDTO.getPozitie_jucata().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Toate câmpurile obligatorii (Nume Jucător, Țară, Poziție Jucată) trebuie completate!");
        }

        try {
            jucatorService.saveDTO(jucatorDTO);
            return ResponseEntity.ok("Jucătorul DTO a fost salvat cu succes!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Eroare la salvarea jucătorului DTO: " + e.getMessage());
        }
    }

    @PutMapping("/jucatordto/{nume_jucator}")
    public ResponseEntity<String> updateDTO(@RequestBody JucatorDTO jucatorDTO, @PathVariable("nume_jucator") String nume_jucator) {
        // Validare manuală pentru câmpurile obligatorii
        if (jucatorDTO.getNume_jucator() == null || jucatorDTO.getNume_jucator().trim().isEmpty() ||
                jucatorDTO.getTara() == null || jucatorDTO.getTara().trim().isEmpty() ||
                jucatorDTO.getPozitie_jucata() == null || jucatorDTO.getPozitie_jucata().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Toate câmpurile obligatorii (Nume Jucător, Țară, Poziție Jucată) trebuie completate!");
        }

        try {
            // Decodifică numele compus pentru a evita probleme cu spațiile sau caracterele speciale
            String decodedName = URLDecoder.decode(nume_jucator, StandardCharsets.UTF_8);

            // Folosește numele decodificat în logica de actualizare
            jucatorService.updateDTOByName(jucatorDTO, decodedName);

            return ResponseEntity.ok("Jucătorul DTO a fost actualizat cu succes!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Eroare la actualizarea jucătorului DTO: " + e.getMessage());
        }
    }


    // Delete a JucatorDTO by nume_jucator
    @DeleteMapping("/jucatordto/{nume_jucator}")
    public ResponseEntity<String> deleteDTO(@PathVariable String nume_jucator) {
        try {
            jucatorService.deleteDTOByName(nume_jucator);
            return ResponseEntity.ok("Jucătorul DTO a fost șters cu succes!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Eroare la ștergerea jucătorului DTO: " + e.getMessage());
        }
    }

    @GetMapping("/top-scorers")
    public List<JucatorDTO> getTopScorersByTeam() {
        return jucatorService.getTopScorersByTeam();
    }
}
