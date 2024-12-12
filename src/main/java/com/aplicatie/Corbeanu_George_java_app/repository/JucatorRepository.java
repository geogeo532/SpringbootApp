package com.aplicatie.Corbeanu_George_java_app.repository;

import com.aplicatie.Corbeanu_George_java_app.DTO.ClasamentDTO;
import com.aplicatie.Corbeanu_George_java_app.DTO.JucatorDTO;
import com.aplicatie.Corbeanu_George_java_app.model.Jucator;

import java.util.List;

public interface JucatorRepository {

    public List<JucatorDTO> getJucatori();

    Jucator get(int id);

    void save(Jucator jucator);

    void update(Jucator jucator);

    void delete(int id);

    public List<JucatorDTO> getJucatoriByMinGoals(int minGoals);
}
