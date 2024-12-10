package com.aplicatie.Corbeanu_George_java_app.repository;

import com.aplicatie.Corbeanu_George_java_app.model.Clasament;
import com.aplicatie.Corbeanu_George_java_app.model.ClasamentId;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClasamentRepositoryImpl implements ClasamentRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Clasament> getClasaments() {
        String query = "SELECT * FROM clasamente";
        return entityManager.createNativeQuery(query, Clasament.class).getResultList();
    }

    @Override
    public Clasament getClasament(ClasamentId clasamentId) {
        String query = "SELECT * FROM clasamente WHERE id_clasament = :idClasament AND id_echipa = :idEchipa";
        return (Clasament) entityManager.createNativeQuery(query, Clasament.class)
                .setParameter("idClasament", clasamentId.getId_clasament())
                .setParameter("idEchipa", clasamentId.getId_echipa())
                .getSingleResult();
    }

    @Transactional
    @Override
    public void save(Clasament clasament) {
        String sql = "INSERT INTO dbo.clasamente (id_clasament, id_echipa, pozitie_finala, meciuri_jucate, victorii, infrangeri, puncte, golaveraj) " +
                "VALUES (:id_clasament, :id_echipa, :pozitie_finala, :meciuri_jucate, :victorii, :infrangeri, :puncte, :golaveraj)";
        entityManager.createNativeQuery(sql)
                .setParameter("id_clasament", clasament.getId_clasament())
                .setParameter("id_echipa", clasament.getId_echipa())
                .setParameter("pozitie_finala", clasament.getPozitie_finala())
                .setParameter("meciuri_jucate", clasament.getMeciuri_jucate())
                .setParameter("victorii", clasament.getVictorii())
                .setParameter("infrangeri", clasament.getInfrangeri())
                .setParameter("puncte", clasament.getPuncte())
                .setParameter("golaveraj", clasament.getGolaveraj())
                .executeUpdate();
    }


    @Transactional
    @Override
    public void update(Clasament clasament) {
        String sql = "UPDATE dbo.clasamente SET pozitie_finala = :pozitie_finala, meciuri_jucate = :meciuri_jucate, " +
                "victorii = :victorii, infrangeri = :infrangeri, puncte = :puncte, golaveraj = :golaveraj " +
                "WHERE id_clasament = :id_clasament AND id_echipa = :id_echipa";
        entityManager.createNativeQuery(sql)
                .setParameter("id_clasament", clasament.getId_clasament())
                .setParameter("id_echipa", clasament.getId_echipa())
                .setParameter("pozitie_finala", clasament.getPozitie_finala())
                .setParameter("meciuri_jucate", clasament.getMeciuri_jucate())
                .setParameter("victorii", clasament.getVictorii())
                .setParameter("infrangeri", clasament.getInfrangeri())
                .setParameter("puncte", clasament.getPuncte())
                .setParameter("golaveraj", clasament.getGolaveraj())
                .executeUpdate();
    }


    @Override
    public void delete(ClasamentId id) {
        String query = "DELETE FROM clasamente WHERE id_clasament = :idClasament AND id_echipa = :idEchipa";
        entityManager.createNativeQuery(query)
                .setParameter("idClasament", id.getId_clasament())
                .setParameter("idEchipa", id.getId_echipa())
                .executeUpdate();
    }

    @Override
    public Optional<Clasament> findById(ClasamentId clasamentId) {
        String query = "SELECT * FROM clasamente WHERE id_clasament = :idClasament AND id_echipa = :idEchipa";
        Clasament clasament = (Clasament) entityManager.createNativeQuery(query, Clasament.class)
                .setParameter("idClasament", clasamentId.getId_clasament())
                .setParameter("idEchipa", clasamentId.getId_echipa())
                .getSingleResult();
        return Optional.ofNullable(clasament);
    }

    @Override
    public boolean existsById(ClasamentId clasamentId) {
        String query = "SELECT COUNT(*) FROM clasamente WHERE id_clasament = :idClasament AND id_echipa = :idEchipa";
        Number count = (Number) entityManager.createNativeQuery(query)
                .setParameter("idClasament", clasamentId.getId_clasament())
                .setParameter("idEchipa", clasamentId.getId_echipa())
                .getSingleResult();
        return count.intValue() > 0;
    }

    @Override
    public List<Clasament> findByClasamentId(int idClasament) {
        String query = "SELECT * FROM clasamente WHERE id_clasament = :idClasament";
        return entityManager.createNativeQuery(query, Clasament.class)
                .setParameter("idClasament", idClasament)
                .getResultList();
    }

    @Override
    public List<Clasament> findByEchipaId(int idEchipa) {
        String query = "SELECT * FROM clasamente WHERE id_echipa = :idEchipa";
        return entityManager.createNativeQuery(query, Clasament.class)
                .setParameter("idEchipa", idEchipa)
                .getResultList();
    }

    @Transactional
    @Override
    public void deleteInBatch(Iterable<Clasament> clasamente) {
        for (Clasament clasament : clasamente) {
            delete(new ClasamentId(clasament.getId_clasament(), clasament.getId_echipa()));
        }
    }

    @Override
    public void deleteByClasamentId(int idClasament) {
        String query = "DELETE FROM clasamente WHERE id_clasament = :idClasament";
        entityManager.createNativeQuery(query)
                .setParameter("idClasament", idClasament)
                .executeUpdate();
    }

    @Override
    public void deleteByEchipaId(int idEchipa) {
        String query = "DELETE FROM clasamente WHERE id_echipa = :idEchipa";
        entityManager.createNativeQuery(query)
                .setParameter("idEchipa", idEchipa)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void deleteById(ClasamentId clasamentId) {
        delete(clasamentId);
    }

}
