/** Clasa pentru crearea repository-ului pentru tabela echipe
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.repository;

import java.util.List;

import com.aplicatie.Corbeanu_George_java_app.DTO.EchipaDTO;
import com.aplicatie.Corbeanu_George_java_app.model.Echipa;

public interface EchipaRepository {

    public List<EchipaDTO> getEchipe();

    Echipa get(int id);

    void save(Echipa echipa);

    void update(Echipa echipa);

    void delete(int id);

    public Echipa findByTara(String tara);

    public void saveDTO(EchipaDTO echipaDTO);

    public void updateDTOByTara(EchipaDTO echipaDTO, String tara);

    public void deleteDTOByTara(String tara);

    public List<EchipaDTO> getCoachesWithRedCards();

    public List<EchipaDTO> getTeamsWithAboveAverageScorers();

    public List<EchipaDTO> getTeamsWithAboveAverageScorers(int minPlayersAboveAverage);
}
