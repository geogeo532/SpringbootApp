package com.aplicatie.Corbeanu_George_java_app.repository;

import com.aplicatie.Corbeanu_George_java_app.model.Jucator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JucatorRepositoryImpl implements JucatorRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Jucator> get() {
        String sql = "SELECT * FROM jucatori";
        Query query = entityManager.createNativeQuery(sql, Jucator.class);
        return query.getResultList();
    }

    @Override
    public Jucator get(int id) {
        String sql = "SELECT * FROM jucatori WHERE id_jucator = :id";
        Query query = entityManager.createNativeQuery(sql, Jucator.class);
        query.setParameter("id", id);
        return (Jucator) query.getSingleResult();
    }

    @Override
    public void save(Jucator jucator) {
        String sql = "INSERT INTO jucatori (nume_jucator, pozitie_jucata, id_echipa) VALUES (:nume_jucator, :pozitie_jucata, :id_echipa)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("nume_jucator", jucator.getNume_jucator());
        query.setParameter("pozitie_jucata", jucator.getPozitie_jucata());
        query.setParameter("id_echipa", jucator.getId_echipa());
        query.executeUpdate();
    }

    @Override
    public void update(Jucator jucator) {
        String sql = "UPDATE jucatori SET nume_jucator = :nume_jucator, pozitie_jucata = :pozitie_jucator, id_echipa = :id_echipa WHERE id_jucator = :id";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("nume_jucator", jucator.getNume_jucator());
        query.setParameter("pozitie_jucator", jucator.getPozitie_jucata());
        query.setParameter("id_echipa", jucator.getId_echipa());
        query.setParameter("id", jucator.getId_jucator());
        query.executeUpdate();
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM jucatori WHERE id_jucator = :id";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
