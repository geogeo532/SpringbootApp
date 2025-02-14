/** Clasa pentru crearea implementarii service-ului pentru tabela meciuri
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.service;

import com.aplicatie.Corbeanu_George_java_app.DTO.MeciDTO;
import com.aplicatie.Corbeanu_George_java_app.model.Meci;
import com.aplicatie.Corbeanu_George_java_app.repository.MeciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MeciServiceImpl implements MeciService {

    @Autowired
    private MeciRepository meciRepository;

    @Transactional
    @Override
    public List<MeciDTO> getMeciuri() {
        return meciRepository.getMeciuri();
    }

    @Transactional
    @Override
    public Meci get(int id) {
        return meciRepository.get(id);
    }

    @Transactional
    @Override
    public void save(Meci meci) {
        meciRepository.save(meci);
    }

    @Transactional
    @Override
    public void update(Meci meci) {
        meciRepository.update(meci);
    }

    @Transactional
    @Override
    public void delete(int id) {
        meciRepository.delete(id);
    }
}
