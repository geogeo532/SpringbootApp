package com.aplicatie.Corbeanu_George_java_app.repository;

import com.aplicatie.Corbeanu_George_java_app.DTO.EchipaDTO;
import com.aplicatie.Corbeanu_George_java_app.DTO.StadionDTO;
import com.aplicatie.Corbeanu_George_java_app.model.Stadion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Index;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StadionRepositoryImpl implements StadionRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<StadionDTO> getStadioane() {
        String query= "SELECT s.nume_stadion,s.oras,s.capacitate FROM stadioane s";

        List<Object[]> result = entityManager.createNativeQuery(query).getResultList();

        List<StadionDTO> stadion = new ArrayList<>();
        for (Object[] row : result) {
            String nume_stadion = (String) row[0];
            String nume_oras = (String) row[1];
            int capacitate = (Integer) row[2];

            StadionDTO stadionDTO = new StadionDTO(nume_stadion, nume_oras, capacitate);
            stadion.add(stadionDTO);
        }

        return stadion;
    }

    @Override
    public Stadion get(int id) {
        String sql = "SELECT * FROM stadioane WHERE id_stadion = :id";
        Query query = entityManager.createNativeQuery(sql, Stadion.class);
        query.setParameter("id", id);
        return (Stadion) query.getSingleResult();
    }

    @Override
    public void save(Stadion stadion) {
        String sql = "INSERT INTO stadioane (nume_stadion, oras, capacitate) VALUES (:nume_stadion, :oras, :capacitate)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("nume_stadion", stadion.getNume_stadion());
        query.setParameter("oras", stadion.getOras());
        query.setParameter("capacitate", stadion.getCapacitate());
        query.executeUpdate();
    }

    @Override
    public void update(Stadion stadion) {
        String sql = "UPDATE stadioane SET nume_stadion = :nume_stadion, oras = :oras, capacitate = :capacitate WHERE id_stadion = :id";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("nume_stadion", stadion.getNume_stadion());
        query.setParameter("oras", stadion.getOras());
        query.setParameter("capacitate", stadion.getCapacitate());
        query.setParameter("id", stadion.getId_stadion());
        query.executeUpdate();
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM stadioane WHERE id_stadion = :id";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
