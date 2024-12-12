package com.aplicatie.Corbeanu_George_java_app.service;

import java.util.List;

import com.aplicatie.Corbeanu_George_java_app.DTO.EchipaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aplicatie.Corbeanu_George_java_app.repository.EchipaRepository;
import com.aplicatie.Corbeanu_George_java_app.model.Echipa;

@Service
public class EchipaServiceImpl implements EchipaService {

    @Autowired
    private EchipaRepository echipaRepository;

    @Transactional
    @Override
    public List<EchipaDTO> getEchipe() {
        return echipaRepository.getEchipe();
    }

    @Transactional
    @Override
    public Echipa get(int id) {
        return echipaRepository.get(id);
    }

    @Transactional
    @Override
    public void save(Echipa echipa) {
        echipaRepository.save(echipa);
    }

    @Transactional
    @Override
    public void update(Echipa echipa) {
        echipaRepository.update(echipa);
    }

    @Transactional
    @Override
    public void delete(int id) {
        echipaRepository.delete(id);
    }
}
