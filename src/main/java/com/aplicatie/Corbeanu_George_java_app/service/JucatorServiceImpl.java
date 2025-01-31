/** Clasa pentru crearea implementarii service-ului pentru tabela jucatori
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.service;

import com.aplicatie.Corbeanu_George_java_app.DTO.JucatorDTO;
import com.aplicatie.Corbeanu_George_java_app.model.Echipa;
import com.aplicatie.Corbeanu_George_java_app.model.Jucator;
import com.aplicatie.Corbeanu_George_java_app.repository.EchipaRepository;
import com.aplicatie.Corbeanu_George_java_app.repository.JucatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JucatorServiceImpl implements JucatorService {

    @Autowired
    private JucatorRepository jucatorRepository;

    @Transactional
    @Override
    public List<JucatorDTO> getJucatori() {
        return jucatorRepository.getJucatori();
    }

    @Transactional
    @Override
    public List<JucatorDTO> getJucatoriByMinGoals(int minGoals)
    {
        return jucatorRepository.getJucatoriByMinGoals(minGoals);
    }

    @Transactional
    @Override
    public Jucator get(int id) {
        return jucatorRepository.get(id);
    }


    @Transactional
    @Override
    public void save(Jucator jucator) {
        jucatorRepository.save(jucator);
    }

    @Transactional
    @Override
    public void update(Jucator jucator) {
        jucatorRepository.update(jucator);
    }

    @Transactional
    @Override
    public void delete(int id) {
        jucatorRepository.delete(id);
    }

    @Transactional
    @Override
    public void saveDTO(JucatorDTO jucatorDTO) {
        jucatorRepository.saveDTO(jucatorDTO);
    }

    @Transactional
    @Override
    public void updateDTO(JucatorDTO jucatorDTO, int id) {
        jucatorRepository.updateDTO(jucatorDTO, id);
    }

    @Transactional
    @Override
    public void deleteDTO(int id) {
        jucatorRepository.deleteDTO(id);
    }

    @Transactional
    @Override
    public void updateDTOByName(JucatorDTO jucatorDTO, String nume_jucator) {
        jucatorRepository.updateDTOByName(jucatorDTO, nume_jucator);
    }

    @Transactional
    @Override
    public void deleteDTOByName(String nume_jucator) {
        jucatorRepository.deleteDTOByName(nume_jucator);
    }

    @Transactional
    @Override
    public List<JucatorDTO> getTopScorersByTeam() {
        return jucatorRepository.getTopScorersByTeam();
    }
}
