/** Clasa pentru crearea implementării repository-ului pentru tabela jucatori
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.repository;

import com.aplicatie.Corbeanu_George_java_app.DTO.JucatorDTO;
import com.aplicatie.Corbeanu_George_java_app.model.Jucator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JucatorRepositoryImpl implements JucatorRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<JucatorDTO> getJucatori() {
        String query = "SELECT j.nume_jucator, e.tara, j.pozitie_jucata, sj.goluri, " +
                "sj.pase_decisive, sj.cartonase_galbene, sj.cartonase_rosii " +
                "FROM jucatori j " +
                "LEFT JOIN echipe e ON j.id_echipa = e.id_echipa " +
                "LEFT JOIN statistici_jucatori sj ON sj.id_jucator = j.id_jucator";

        List<Object[]> result = entityManager.createNativeQuery(query).getResultList();

        List<JucatorDTO> jucatori = new ArrayList<>();
        for (Object[] row : result) {
            String numeJucator = (String) row[0];
            String tara = (String) row[1];
            String pozitieJucata = (String) row[2];
            int goluri = row[3] != null ? ((Number) row[3]).intValue() : 0;
            int paseDecisive = row[4] != null ? ((Number) row[4]).intValue() : 0;
            int cartonaseGalbene = row[5] != null ? ((Number) row[5]).intValue() : 0;
            int cartonaseRosii = row[6] != null ? ((Number) row[6]).intValue() : 0;

            JucatorDTO jucatorDTO = new JucatorDTO(numeJucator, tara, pozitieJucata, goluri, paseDecisive, cartonaseGalbene, cartonaseRosii);
            jucatori.add(jucatorDTO);
        }

        return jucatori;
    }

    @Override
    public List<JucatorDTO> getJucatoriByMinGoals(int minGoals) {
        String query = "SELECT j.nume_jucator, e.tara, j.pozitie_jucata, sj.goluri " +
                "FROM jucatori j " +
                "JOIN echipe e ON j.id_echipa = e.id_echipa " +
                "JOIN statistici_jucatori sj ON sj.id_jucator = j.id_jucator " +
                "WHERE goluri >= :minGoals " +
                "ORDER BY goluri DESC";

        Query nativeQuery = entityManager.createNativeQuery(query);
        nativeQuery.setParameter("minGoals", minGoals);

        List<Object[]> result = nativeQuery.getResultList();

        List<JucatorDTO> jucatori = new ArrayList<>();
        for (Object[] row : result) {
            String numeJucator = (String) row[0];
            String tara = (String) row[1];
            String pozitieJucata = (String) row[2];
            int goluri = (int) row[3];

            JucatorDTO jucatorDTO = new JucatorDTO(numeJucator, tara, pozitieJucata, goluri);
            jucatori.add(jucatorDTO);
        }

        return jucatori;
    }

    @Override
    public List<JucatorDTO> getTopScorersByTeam() {
        String sql = "SELECT j.nume_jucator, e.tara, sj.goluri " +
                "FROM jucatori j " +
                "JOIN statistici_jucatori sj ON j.id_jucator = sj.id_jucator " +
                "JOIN echipe e ON j.id_echipa = e.id_echipa " +
                "WHERE sj.goluri = ( " +
                "    SELECT MAX(sj2.goluri) " +
                "    FROM statistici_jucatori sj2 " +
                "    JOIN jucatori j2 ON sj2.id_jucator = j2.id_jucator " +
                "    WHERE j2.id_echipa = j.id_echipa " +
                ") " +
                "ORDER BY e.tara";

        List<Object[]> results = entityManager.createNativeQuery(sql).getResultList();
        List<JucatorDTO> topScorers = new ArrayList<>();

        for (Object[] row : results) {
            String numeJucator = (String) row[0];
            String tara = (String) row[1];
            int goluri = ((Number) row[2]).intValue();
            topScorers.add(new JucatorDTO(numeJucator, tara, null, goluri, 0, 0, 0)); // Eliminăm câmpurile inutile.
        }

        return topScorers;
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
        String sql = "UPDATE jucatori SET nume_jucator = :nume_jucator, pozitie_jucata = :pozitie_jucata, id_echipa = :id_echipa WHERE id_jucator = :id";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("nume_jucator", jucator.getNume_jucator());
        query.setParameter("pozitie_jucata", jucator.getPozitie_jucata());
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




    @Override
    public void updateDTO(JucatorDTO dto, int id) {
        String sql = "UPDATE jucatori SET nume_jucator = :nume_jucator, pozitie_jucata = :pozitie_jucata WHERE id_jucator = :id";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("nume_jucator", dto.getNume_jucator());
        query.setParameter("pozitie_jucata", dto.getPozitie_jucata());
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void deleteDTO(int id) {
        String sql = "DELETE FROM jucatori WHERE id_jucator = :id";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void saveDTO(JucatorDTO jucatorDTO) {
        String getIdEchipaQuery = "SELECT id_echipa FROM echipe WHERE tara = :tara";
        Query queryGetIdEchipa = entityManager.createNativeQuery(getIdEchipaQuery);
        queryGetIdEchipa.setParameter("tara", jucatorDTO.getTara());

        List<Integer> idEchipaResults = queryGetIdEchipa.getResultList();
        if (idEchipaResults.isEmpty()) {
            throw new RuntimeException("Echipa pentru țara '" + jucatorDTO.getTara() + "' nu există!");
        }

        Integer idEchipa = idEchipaResults.get(0);

        String sqlInsert = "INSERT INTO jucatori (nume_jucator, pozitie_jucata, id_echipa) " +
                "VALUES (:nume_jucator, :pozitie_jucata, :id_echipa)";
        Query queryInsert = entityManager.createNativeQuery(sqlInsert);
        queryInsert.setParameter("nume_jucator", jucatorDTO.getNume_jucator());
        queryInsert.setParameter("pozitie_jucata", jucatorDTO.getPozitie_jucata());
        queryInsert.setParameter("id_echipa", idEchipa);
        queryInsert.executeUpdate();

        String getIdJucatorQuery = "SELECT id_jucator FROM jucatori WHERE nume_jucator = :nume_jucator";
        Query queryGetIdJucator = entityManager.createNativeQuery(getIdJucatorQuery);
        queryGetIdJucator.setParameter("nume_jucator", jucatorDTO.getNume_jucator());
        Integer idJucator = ((Number) queryGetIdJucator.getSingleResult()).intValue();

        String sqlStatisticiInsert = "INSERT INTO statistici_jucatori (id_statistica, id_jucator, goluri, pase_decisive, " +
                "cartonase_galbene, cartonase_rosii) " +
                "VALUES (:id_statistica, :id_jucator, :goluri, :pase_decisive, :cartonase_galbene, :cartonase_rosii)";
        Query queryStatisticiInsert = entityManager.createNativeQuery(sqlStatisticiInsert);
        queryStatisticiInsert.setParameter("id_statistica", 1);
        queryStatisticiInsert.setParameter("id_jucator", idJucator);
        queryStatisticiInsert.setParameter("goluri", jucatorDTO.getGoluri());
        queryStatisticiInsert.setParameter("pase_decisive", jucatorDTO.getPase_decisive());
        queryStatisticiInsert.setParameter("cartonase_galbene", jucatorDTO.getCartonase_galbene());
        queryStatisticiInsert.setParameter("cartonase_rosii", jucatorDTO.getCartonase_rosii());
        queryStatisticiInsert.executeUpdate();
    }



    @Override
    public void updateDTOByName(JucatorDTO jucatorDTO, String nume_jucator) {

        String getIdQuery = "SELECT id_jucator FROM jucatori WHERE nume_jucator = :nume_jucator";
        Query queryGetId = entityManager.createNativeQuery(getIdQuery);
        queryGetId.setParameter("nume_jucator", nume_jucator);

        List<Integer> idResults = queryGetId.getResultList();
        if (idResults.isEmpty()) {
            throw new RuntimeException("Jucătorul cu numele " + nume_jucator + " nu există!");
        }
        int idJucator = idResults.get(0);


        String updateStatistici1 = "UPDATE statistici_jucatori SET goluri = :goluri, pase_decisive = :pase_decisive, " +
                "cartonase_galbene = :cartonase_galbene, cartonase_rosii = :cartonase_rosii " +
                "WHERE id_statistica = 1 AND id_jucator = :id_jucator";
        Query queryUpdateStatistici1 = entityManager.createNativeQuery(updateStatistici1);
        queryUpdateStatistici1.setParameter("goluri", jucatorDTO.getGoluri());
        queryUpdateStatistici1.setParameter("pase_decisive", jucatorDTO.getPase_decisive());
        queryUpdateStatistici1.setParameter("cartonase_galbene", jucatorDTO.getCartonase_galbene());
        queryUpdateStatistici1.setParameter("cartonase_rosii", jucatorDTO.getCartonase_rosii());
        queryUpdateStatistici1.setParameter("id_jucator", idJucator);

        int rowsUpdatedStatistici1 = queryUpdateStatistici1.executeUpdate();
        if (rowsUpdatedStatistici1 == 0) {
            throw new RuntimeException("Înregistrarea cu id_statistica = 1 pentru id_jucator = " + idJucator + " nu există!");
        }


        String sqlJucatori = "UPDATE jucatori SET pozitie_jucata = :pozitie_jucata, id_echipa = " +
                "(SELECT id_echipa FROM echipe WHERE tara = :tara) " +
                "WHERE id_jucator = :id_jucator";
        Query queryJucatori = entityManager.createNativeQuery(sqlJucatori);
        queryJucatori.setParameter("pozitie_jucata", jucatorDTO.getPozitie_jucata());
        queryJucatori.setParameter("tara", jucatorDTO.getTara());
        queryJucatori.setParameter("id_jucator", idJucator);

        int rowsUpdatedJucatori = queryJucatori.executeUpdate();
        if (rowsUpdatedJucatori == 0) {
            throw new RuntimeException("Actualizarea în `jucatori` a eșuat pentru id_jucator = " + idJucator);
        }
    }



    @Override
    public void deleteDTOByName(String nume_jucator) {
        String sql = "DELETE FROM jucatori WHERE nume_jucator = :nume_jucator";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("nume_jucator", nume_jucator);
        query.executeUpdate();
    }

}
