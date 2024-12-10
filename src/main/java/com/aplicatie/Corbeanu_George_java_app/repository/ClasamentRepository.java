package com.aplicatie.Corbeanu_George_java_app.repository;

import com.aplicatie.Corbeanu_George_java_app.model.Clasament;
import com.aplicatie.Corbeanu_George_java_app.model.ClasamentId;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface ClasamentRepository  {
    List<Clasament> getClasaments();
    Clasament getClasament(ClasamentId clasamentId);
    void save(Clasament clasament);
    void update(Clasament clasament);
    void delete(ClasamentId id);
    boolean existsById(ClasamentId id);
    Optional<Clasament> findById(ClasamentId clasamentId);
    public List<Clasament> findByClasamentId(int idClasament);
    public List<Clasament> findByEchipaId(int idEchipa);
    void deleteInBatch(Iterable<Clasament> clasamente);
    void deleteByClasamentId(int idClasament);
    void deleteByEchipaId(int idEchipa);
    void deleteById(ClasamentId clasamentId);
}
