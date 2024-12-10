package com.aplicatie.Corbeanu_George_java_app.repository;

import com.aplicatie.Corbeanu_George_java_app.model.Sponsor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SponsorRepositoryImpl implements SponsorRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Sponsor> get() {
        String sql = "SELECT * FROM sponsori";
        Query query = entityManager.createNativeQuery(sql, Sponsor.class);
        return query.getResultList();
    }

    @Override
    public Sponsor get(int id) {
        String sql = "SELECT * FROM sponsori WHERE id_sponsor = :id";
        Query query = entityManager.createNativeQuery(sql, Sponsor.class);
        query.setParameter("id", id);
        return (Sponsor) query.getSingleResult();
    }

    @Override
    public void save(Sponsor sponsor) {
        String sql = "INSERT INTO sponsori (nume_sponsor, industria, tara) VALUES (:nume_sponsor, :industria, :tara)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("nume_sponsor", sponsor.getNume_Sponsor());
        query.setParameter("industria", sponsor.getIndustria());
        query.setParameter("tara", sponsor.getTara());
        query.executeUpdate();
    }

    @Override
    public void update(Sponsor sponsor) {
        String sql = "UPDATE sponsori SET nume_sponsor = :nume_sponsor, industria = :industria, tara = :tara WHERE id_sponsor = :id";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("nume_sponsor", sponsor.getNume_Sponsor());
        query.setParameter("industria", sponsor.getIndustria());
        query.setParameter("tara", sponsor.getTara());
        query.setParameter("id", sponsor.getId_sponsor());
        query.executeUpdate();
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM sponsori WHERE id_sponsor = :id";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
