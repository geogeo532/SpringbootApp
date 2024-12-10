package com.aplicatie.Corbeanu_George_java_app.repository;

import com.aplicatie.Corbeanu_George_java_app.model.Stadion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StadionRepositoryImpl implements StadionRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Stadion> get() {
        String sql = "SELECT * FROM stadioane";
        Query query = entityManager.createNativeQuery(sql, Stadion.class);
        return query.getResultList();
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
        String sql = "INSERT INTO stadioane (nume_stadion, oras, capacitate) VALUES (:nume_stadion, :nume_oras, :capacitate)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("nume_stadion", stadion.getNume_stadion());
        query.setParameter("nume_oras", stadion.getNume_oras());
        query.setParameter("capacitate", stadion.getCapacitate());
        query.executeUpdate();
    }

    @Override
    public void update(Stadion stadion) {
        String sql = "UPDATE stadioane SET nume_stadion = :nume_stadion, oras = :nume_oras, capacitate = :capacitate WHERE id_stadion = :id";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("nume_stadion", stadion.getNume_stadion());
        query.setParameter("nume_oras", stadion.getNume_oras());
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
