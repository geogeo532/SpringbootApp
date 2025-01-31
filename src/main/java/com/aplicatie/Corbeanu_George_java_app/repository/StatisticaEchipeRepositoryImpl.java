/** Clasa pentru crearea implementării repository-ului pentru tabela statistica_echipe
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.repository;

import com.aplicatie.Corbeanu_George_java_app.model.StatisticaEchipe;
import com.aplicatie.Corbeanu_George_java_app.model.StatisticaEchipeId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatisticaEchipeRepositoryImpl implements StatisticaEchipeRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<StatisticaEchipe> get() {
        String sql = "SELECT * FROM statistici_echipe";
        Query query = entityManager.createNativeQuery(sql, StatisticaEchipe.class);
        return query.getResultList();
    }

    @Override
    public StatisticaEchipe get(StatisticaEchipeId id) {
        String sql = "SELECT * FROM statistici_echipe WHERE id_statistica_echipa = :id_statistica_echipa AND id_echipa = :id_echipa";
        Query query = entityManager.createNativeQuery(sql, StatisticaEchipe.class);
        query.setParameter("id_statistica_echipa", id.getId_statistica_echipa());
        query.setParameter("id_echipa", id.getId_echipa());
        return (StatisticaEchipe) query.getSingleResult();
    }

    @Override
    public void save(StatisticaEchipe statisticaEchipe) {
        String sql = "INSERT INTO statistici_echipe (id_statistica_echipa, id_echipa, meciuri_jucate, victorii, infrangeri, goluri_marcate, goluri_primite) VALUES (:id_statistica_echipa, :id_echipa, :meciuri_jucate, :victorii, :infrangeri, :goluri_marcate, :goluri_primite)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id_statistica_echipa", statisticaEchipe.getId_statistica_echipa());
        query.setParameter("id_echipa", statisticaEchipe.getId_echipa());
        query.setParameter("meciuri_jucate", statisticaEchipe.getMeciuri_jucate());
        query.setParameter("victorii", statisticaEchipe.getVictorii());
        query.setParameter("infrangeri", statisticaEchipe.getInfrangeri());
        query.setParameter("goluri_marcate", statisticaEchipe.getGoluri_marcate());
        query.setParameter("goluri_primite", statisticaEchipe.getGoluri_primite());
        query.executeUpdate();
    }

    @Override
    public void update(StatisticaEchipe statisticaEchipe) {
        String sql = "UPDATE statistici_echipe SET meciuri_jucate = :meciuri_jucate, victorii = :victorii, infrangeri = :infrangeri, goluri_marcate = :goluri_marcate, goluri_primite = :goluri_primite WHERE id_statistica_echipa = :id_statistica_echipa AND id_echipa = :id_echipa";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("meciuri_jucate", statisticaEchipe.getMeciuri_jucate());
        query.setParameter("victorii", statisticaEchipe.getVictorii());
        query.setParameter("infrangeri", statisticaEchipe.getInfrangeri());
        query.setParameter("goluri_marcate", statisticaEchipe.getGoluri_marcate());
        query.setParameter("goluri_primite", statisticaEchipe.getGoluri_primite());
        query.setParameter("id_statistica_echipa", statisticaEchipe.getId_statistica_echipa());
        query.setParameter("id_echipa", statisticaEchipe.getId_echipa());
        query.executeUpdate();
    }

    @Override
    public void delete(StatisticaEchipeId id) {
        String sql = "DELETE FROM statistici_echipe WHERE id_statistica_echipa = :id_statistica_echipa AND id_echipa = :id_echipa";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id_statistica_echipa", id.getId_statistica_echipa());
        query.setParameter("id_echipa", id.getId_echipa());
        query.executeUpdate();
    }
}
