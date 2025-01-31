/** Clasa pentru crearea implementării repository-ului pentru tabela echipe
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.repository;

import java.util.ArrayList;
import java.util.List;


import com.aplicatie.Corbeanu_George_java_app.DTO.EchipaDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import jakarta.persistence.TypedQuery;
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

    @Override
    public Echipa findByTara(String tara) {
        String jpql = "SELECT e FROM Echipa e WHERE e.tara = :tara";
        TypedQuery<Echipa> query = entityManager.createQuery(jpql, Echipa.class);
        query.setParameter("tara", tara);

        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public void saveDTO(EchipaDTO echipaDTO) {
        String sql = "INSERT INTO echipe (tara, antrenor, palmares) VALUES (:tara, :antrenor, :palmares)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("tara", echipaDTO.getTara());
        query.setParameter("antrenor", echipaDTO.getAntrenor());
        query.setParameter("palmares", echipaDTO.getPalmares());
        query.executeUpdate();
    }

    @Override
    public void updateDTOByTara(EchipaDTO echipaDTO, String tara) {
        String sql = "UPDATE echipe SET antrenor = :antrenor, palmares = :palmares WHERE tara = :tara";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("antrenor", echipaDTO.getAntrenor());
        query.setParameter("palmares", echipaDTO.getPalmares());
        query.setParameter("tara", tara);
        int rowsUpdated = query.executeUpdate();
        if (rowsUpdated == 0) {
            throw new RuntimeException("Echipa cu țara '" + tara + "' nu a fost găsită pentru actualizare.");
        }
    }

    @Override
    public void deleteDTOByTara(String tara) {
        String sql = "DELETE FROM echipe WHERE tara = :tara";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("tara", tara);
        int rowsDeleted = query.executeUpdate();
        if (rowsDeleted == 0) {
            throw new RuntimeException("Echipa cu țara '" + tara + "' nu a fost găsită pentru ștergere.");
        }
    }


    @Override
    public List<EchipaDTO> getCoachesWithRedCards() {
        String sql = "SELECT DISTINCT e.tara, e.antrenor " +
                "FROM echipe e " +
                "WHERE e.id_echipa IN ( " +
                "    SELECT j.id_echipa " +
                "    FROM jucatori j " +
                "    JOIN statistici_jucatori sj ON j.id_jucator = sj.id_jucator " +
                "    WHERE sj.cartonase_rosii > 0 " +
                ")";

        List<Object[]> results = entityManager.createNativeQuery(sql).getResultList();
        List<EchipaDTO> coaches = new ArrayList<>();

        for (Object[] row : results) {
            String tara = (String) row[0];
            String antrenor = (String) row[1];
            coaches.add(new EchipaDTO(tara, antrenor, null)); // Excludem palmares.
        }

        return coaches;
    }


    @Override
    public List<EchipaDTO> getTeamsWithAboveAverageScorers() {
        String sql = "SELECT e.tara, SUM(sj.goluri) AS total_goluri " +
                "FROM echipe e " +
                "JOIN jucatori j ON e.id_echipa = j.id_echipa " +
                "JOIN statistici_jucatori sj ON j.id_jucator = sj.id_jucator " +
                "WHERE sj.goluri > ( " +
                "    SELECT AVG(sj2.goluri) " +
                "    FROM statistici_jucatori sj2 " +
                ") " +
                "GROUP BY e.tara";

        List<Object[]> results = entityManager.createNativeQuery(sql).getResultList();
        List<EchipaDTO> echipe = new ArrayList<>();

        for (Object[] row : results) {
            String tara = (String) row[0];
            int totalGoluri = ((Number) row[1]).intValue();
            echipe.add(new EchipaDTO(tara, null, null));
        }

        return echipe;
    }

    @Override
    public List<EchipaDTO> getTeamsWithAboveAverageScorers(int minPlayersAboveAverage) {
        String sql = "SELECT e.tara, COUNT(j.id_jucator) AS numar_jucatori " +
                "FROM echipe e " +
                "JOIN jucatori j ON e.id_echipa = j.id_echipa " +
                "JOIN statistici_jucatori sj ON j.id_jucator = sj.id_jucator " +
                "WHERE sj.goluri > ( " +
                "    SELECT AVG(sj2.goluri) " +
                "    FROM statistici_jucatori sj2 " +
                ") " +
                "GROUP BY e.tara " +
                "HAVING COUNT(j.id_jucator) >= :minPlayers";

        List<Object[]> results = entityManager.createNativeQuery(sql)
                .setParameter("minPlayers", minPlayersAboveAverage)
                .getResultList();

        List<EchipaDTO> echipe = new ArrayList<>();

        for (Object[] row : results) {
            String tara = (String) row[0];
            int numarJucatori = ((Number) row[1]).intValue();
            echipe.add(new EchipaDTO(tara, null, null)); // Excludem antrenor și palmares.
        }

        return echipe;
    }
}
