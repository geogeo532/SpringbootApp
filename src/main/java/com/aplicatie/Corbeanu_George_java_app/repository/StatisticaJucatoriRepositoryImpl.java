/** Clasa pentru crearea implementării repository-ului pentru tabela statistica_echipe
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.repository;

import com.aplicatie.Corbeanu_George_java_app.model.StatisticaJucatori;
import com.aplicatie.Corbeanu_George_java_app.model.StatisticaJucatoriId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatisticaJucatoriRepositoryImpl implements StatisticaJucatoriRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<StatisticaJucatori> get() {
        String sql = "SELECT * FROM statistici_jucatori";
        Query query = entityManager.createNativeQuery(sql, StatisticaJucatori.class);
        return query.getResultList();
    }

    @Override
    public StatisticaJucatori get(StatisticaJucatoriId id) {
        String sql = "SELECT * FROM statistici_jucatori WHERE id_statistica = :id_statistica AND id_jucator = :id_jucator";
        Query query = entityManager.createNativeQuery(sql, StatisticaJucatori.class);
        query.setParameter("id_statistica", id.getId_statistica());
        query.setParameter("id_jucator", id.getId_jucator());
        return (StatisticaJucatori) query.getSingleResult();
    }

    @Override
    public void save(StatisticaJucatori statisticaJucatori) {
        String sql = "INSERT INTO statistici_jucatori (id_statistica, id_jucator, goluri, pase_decisive, cartonase_galbene, cartonase_rosii) VALUES (:id_statistica, :id_jucator, :goluri, :pase_decisive, :cartonase_galbene, :cartonase_rosii)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id_statistica", statisticaJucatori.getId_statistica());
        query.setParameter("id_jucator", statisticaJucatori.getId_jucator());
        query.setParameter("goluri", statisticaJucatori.getGoluri());
        query.setParameter("pase_decisive", statisticaJucatori.getPase_decisive());
        query.setParameter("cartonase_galbene", statisticaJucatori.getCartonase_galbene());
        query.setParameter("cartonase_rosii", statisticaJucatori.getCartonase_rosii());
        query.executeUpdate();
    }

    @Override
    public void update(StatisticaJucatori statisticaJucatori) {
        String sql = "UPDATE statistici_jucatori SET goluri = :goluri, pase_decisive = :pase_decisive, cartonase_galbene = :cartonase_galbene, cartonase_rosii = :cartonase_rosii WHERE id_statistica = :id_statistica AND id_jucator = :id_jucator";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("goluri", statisticaJucatori.getGoluri());
        query.setParameter("pase_decisive", statisticaJucatori.getPase_decisive());
        query.setParameter("cartonase_galbene", statisticaJucatori.getCartonase_galbene());
        query.setParameter("cartonase_rosii", statisticaJucatori.getCartonase_rosii());
        query.setParameter("id_statistica", statisticaJucatori.getId_statistica());
        query.setParameter("id_jucator", statisticaJucatori.getId_jucator());
        query.executeUpdate();
    }

    @Override
    public void delete(StatisticaJucatoriId id) {
        String sql = "DELETE FROM statistici_jucatori WHERE id_statistica = :id_statistica AND id_jucator = :id_jucator";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id_statistica", id.getId_statistica());
        query.setParameter("id_jucator", id.getId_jucator());
        query.executeUpdate();
    }
}
