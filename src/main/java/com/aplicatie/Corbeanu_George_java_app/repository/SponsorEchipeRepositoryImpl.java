package com.aplicatie.Corbeanu_George_java_app.repository;

import com.aplicatie.Corbeanu_George_java_app.model.SponsorEchipe;
import com.aplicatie.Corbeanu_George_java_app.model.SponsorEchipeId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SponsorEchipeRepositoryImpl implements SponsorEchipeRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<SponsorEchipe> get() {
        String sql = "SELECT * FROM sponsori_echipe";
        Query query = entityManager.createNativeQuery(sql, SponsorEchipe.class);
        return query.getResultList();
    }

    @Override
    public SponsorEchipe get(SponsorEchipeId id) {
        String sql = "SELECT * FROM sponsori_echipe WHERE id_sponsor = :id_sponsor AND id_echipa = :id_echipa";
        Query query = entityManager.createNativeQuery(sql, SponsorEchipe.class);
        query.setParameter("id_sponsor", id.getId_sponsor());
        query.setParameter("id_echipa", id.getId_echipa());
        return (SponsorEchipe) query.getSingleResult();
    }

    @Override
    public void save(SponsorEchipe sponsorEchipe) {
        String sql = "INSERT INTO sponsori_echipe (id_sponsor, id_echipa, data_incepere_sponsorizare, durata_sponsorizare, valoare_sponsorizare) " +
                "VALUES (:id_sponsor, :id_echipa, :data_incepere_sponsorizare, :durata_sponsorizare, :valoare_sponsorizare)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id_sponsor", sponsorEchipe.getId_sponsor());
        query.setParameter("id_echipa", sponsorEchipe.getId_echipa());
        query.setParameter("data_incepere_sponsorizare", sponsorEchipe.getData_incepere_sponsorizare());
        query.setParameter("durata_sponsorizare", sponsorEchipe.getDurata_sponsorizare());
        query.setParameter("valoare_sponsorizare", sponsorEchipe.getValoare_sponsorizare());
        query.executeUpdate();
    }

    @Override
    public void update(SponsorEchipe sponsorEchipe) {
        String sql = "UPDATE sponsori_echipe SET data_incepere_sponsorizare = :data_incepere_sponsorizare, " +
                "durata_sponsorizare = :durata_sponsorizare, valoare_sponsorizare = :valoare_sponsorizare " +
                "WHERE id_sponsor = :id_sponsor AND id_echipa = :id_echipa";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("data_incepere_sponsorizare", sponsorEchipe.getData_incepere_sponsorizare());
        query.setParameter("durata_sponsorizare", sponsorEchipe.getDurata_sponsorizare());
        query.setParameter("valoare_sponsorizare", sponsorEchipe.getValoare_sponsorizare());
        query.setParameter("id_sponsor", sponsorEchipe.getId_sponsor());
        query.setParameter("id_echipa", sponsorEchipe.getId_echipa());
        query.executeUpdate();
    }

    @Override
    public void delete(SponsorEchipeId id) {
        String sql = "DELETE FROM sponsori_echipe WHERE id_sponsor = :id_sponsor AND id_echipa = :id_echipa";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id_sponsor", id.getId_sponsor());
        query.setParameter("id_echipa", id.getId_echipa());
        query.executeUpdate();
    }
}
