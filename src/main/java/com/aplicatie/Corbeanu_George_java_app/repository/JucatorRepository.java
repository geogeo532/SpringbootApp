/** Clasa pentru crearea repository-ului pentru tabela jucători
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.repository;

import com.aplicatie.Corbeanu_George_java_app.DTO.ClasamentDTO;
import com.aplicatie.Corbeanu_George_java_app.DTO.JucatorDTO;
import com.aplicatie.Corbeanu_George_java_app.model.Jucator;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JucatorRepository {

    public List<JucatorDTO> getJucatori();

    Jucator get(int id);

    public List<JucatorDTO> getTopScorersByTeam();

    void save(Jucator jucator);

    void update(Jucator jucator);

    void delete(int id);

    public List<JucatorDTO> getJucatoriByMinGoals(int minGoals);

    public void saveDTO(JucatorDTO dto);

    public void updateDTO(JucatorDTO dto, int id);

    public void deleteDTO(int id);

    void updateDTOByName(JucatorDTO jucatorDTO, String nume_jucator);

    void deleteDTOByName(String nume_jucator);



}
