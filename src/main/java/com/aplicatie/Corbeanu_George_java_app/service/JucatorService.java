/** Clasa pentru crearea service-ului pentru tabela jucatori
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.service;

import com.aplicatie.Corbeanu_George_java_app.DTO.JucatorDTO;
import com.aplicatie.Corbeanu_George_java_app.model.Jucator;

import java.util.List;

public interface JucatorService {

    public List<JucatorDTO> getJucatori();

    Jucator get(int id);

    void save(Jucator jucator);

    void update(Jucator jucator);

    void delete(int id);

    public List<JucatorDTO> getJucatoriByMinGoals(int minGoals);

    public void saveDTO(JucatorDTO dto);

    public void updateDTO(JucatorDTO dto, int id);

    public void deleteDTO(int id);

    void updateDTOByName(JucatorDTO jucatorDTO, String nume_jucator);

    void deleteDTOByName(String nume_jucator);

    public List<JucatorDTO> getTopScorersByTeam();
}
