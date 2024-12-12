package com.aplicatie.Corbeanu_George_java_app.service;

import com.aplicatie.Corbeanu_George_java_app.DTO.ClasamentDTO;
import com.aplicatie.Corbeanu_George_java_app.model.Clasament;
import com.aplicatie.Corbeanu_George_java_app.model.ClasamentId;

import java.util.List;

public interface ClasamentService {
    public List<ClasamentDTO> getClasaments();
    Clasament getClasament(ClasamentId id);
    void save(Clasament clasament);
    void delete(ClasamentId id);
    void deleteByClasamentId(int idClasament);
    void deleteByEchipaId(int idEchipa);
    void deleteClasament(ClasamentId clasamentId);
    public void deleteClasamentById(int idClasament);
    void update(Clasament clasament);
    public List<ClasamentDTO> getClasamenteByMinPoints(int minPoints);
}
