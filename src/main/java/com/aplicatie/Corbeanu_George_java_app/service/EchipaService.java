package com.aplicatie.Corbeanu_George_java_app.service;

import java.util.List;

import com.aplicatie.Corbeanu_George_java_app.DTO.EchipaDTO;
import com.aplicatie.Corbeanu_George_java_app.model.Echipa;

public interface EchipaService {

    public List<EchipaDTO> getEchipe();

    Echipa get(int id);

    void save(Echipa echipa);

    void update(Echipa echipa);

    void delete(int id);
}
