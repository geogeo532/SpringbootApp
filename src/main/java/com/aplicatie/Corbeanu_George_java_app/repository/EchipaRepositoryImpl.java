package com.aplicatie.Corbeanu_George_java_app.repository;

import java.util.ArrayList;
import java.util.List;


import com.aplicatie.Corbeanu_George_java_app.DTO.EchipaDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aplicatie.Corbeanu_George_java_app.model.Echipa;

@Repository
public class EchipaRepositoryImpl implements EchipaRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<EchipaDTO> getEchipe() {
        String query = "SELECT e.tara, e.antrenor, e.palmares FROM echipe e";

        // Executăm interogarea și obținem rezultatele
        List<Object[]> result = entityManager.createNativeQuery(query).getResultList();

        List<EchipaDTO> echipe = new ArrayList<>();
        for (Object[] row : result) {
            String tara = (String) row[0];
            String antrenor = (String) row[1];
            String palmares = (String) row[2];

            EchipaDTO echipaDTO = new EchipaDTO(tara, antrenor, palmares);
            echipe.add(echipaDTO);
        }

        return echipe;
    }


    @Override
    public Echipa get(int id) {
        String sql = "SELECT * FROM echipe WHERE id_echipa = :id";
        Query query = entityManager.createNativeQuery(sql, Echipa.class);
        query.setParameter("id", id);
        return (Echipa) query.getSingleResult();
    }

    @Override
    public void save(Echipa echipa) {
        String sql = "INSERT INTO echipe (tara, antrenor, palmares) VALUES (:tara, :antrenor, :palmares)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("tara", echipa.getTara());
        query.setParameter("antrenor", echipa.getAntrenor());
        query.setParameter("palmares", echipa.getPalmares());
        query.executeUpdate();
    }

    @Override
    public void update(Echipa echipa) {
        String sql = "UPDATE echipe SET tara = :tara, antrenor = :antrenor, palmares = :palmares WHERE id_echipa = :id";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("tara", echipa.getTara());
        query.setParameter("antrenor", echipa.getAntrenor());
        query.setParameter("palmares", echipa.getPalmares());
        query.setParameter("id", echipa.getId_echipa());
        query.executeUpdate();
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM echipe WHERE id_echipa = :id";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
