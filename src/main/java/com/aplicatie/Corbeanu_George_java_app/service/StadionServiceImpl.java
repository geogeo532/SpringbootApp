/** Clasa pentru crearea implementarii service-ului pentru tabela stadioane
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.service;

import com.aplicatie.Corbeanu_George_java_app.DTO.StadionDTO;
import com.aplicatie.Corbeanu_George_java_app.model.Stadion;
import com.aplicatie.Corbeanu_George_java_app.repository.StadionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StadionServiceImpl implements StadionService {

    @Autowired
    private StadionRepository stadionRepository;

    @Transactional
    @Override
    public List<StadionDTO> getStadioane() {
        return stadionRepository.getStadioane();
    }

    @Transactional
    @Override
    public Stadion get(int id) {
        return stadionRepository.get(id);
    }

    @Transactional
    @Override
    public void save(Stadion stadion) {
        stadionRepository.save(stadion);
    }

    @Transactional
    @Override
    public void update(Stadion stadion) {
        stadionRepository.update(stadion);
    }

    @Transactional
    @Override
    public void delete(int id) {
        stadionRepository.delete(id);
    }
}
