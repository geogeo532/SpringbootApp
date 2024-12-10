package com.aplicatie.Corbeanu_George_java_app.repository;

import com.aplicatie.Corbeanu_George_java_app.model.Meci;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MeciRepositoryImpl implements MeciRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Meci> get() {
        String sql = "SELECT * FROM meciuri";
        Query query = entityManager.createNativeQuery(sql, Meci.class);
        return query.getResultList();
    }

    @Override
    public Meci get(int id) {
        String sql = "SELECT * FROM meciuri WHERE id_meci = :id";
        Query query = entityManager.createNativeQuery(sql, Meci.class);
        query.setParameter("id", id);
        return (Meci) query.getSingleResult();
    }

    @Override
    public void save(Meci meci) {
        String sql = "INSERT INTO meciuri (data_meci, echipa_gazda, echipa_oaspete, scor_gazde, scor_oaspeti, id_stadion) VALUES (:data_meci, :echipa_gazda, :echipa_oaspete, :scor_gazde, :scor_oaspeti, :id_stadion)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("data_meci", meci.getData_meci());
        query.setParameter("echipa_gazda", meci.getEchipa_gazda());
        query.setParameter("echipa_oaspete", meci.getEchipa_oaspete());
        query.setParameter("scor_gazde", meci.getScor_gazde());
        query.setParameter("scor_oaspeti", meci.getScor_oaspeti());
        query.setParameter("id_stadion", meci.getId_stadion());
        query.executeUpdate();
    }

    @Override
    public void update(Meci meci) {
        String sql = "UPDATE meciuri SET data_meci = :data_meci, echipa_gazda = :echipa_gazda, echipa_oaspete = :echipa_oaspete, scor_gazde = :scor_gazde, scor_oaspeti = :scor_oaspeti, id_stadion = :id_stadion WHERE id_meci = :id";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("data_meci", meci.getData_meci());
        query.setParameter("echipa_gazda", meci.getEchipa_gazda());
        query.setParameter("echipa_oaspete", meci.getEchipa_oaspete());
        query.setParameter("scor_gazde", meci.getScor_gazde());
        query.setParameter("scor_oaspeti", meci.getScor_oaspeti());
        query.setParameter("id_stadion", meci.getId_stadion());
        query.setParameter("id", meci.getId_meci());
        query.executeUpdate();
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM meciuri WHERE id_meci = :id";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
