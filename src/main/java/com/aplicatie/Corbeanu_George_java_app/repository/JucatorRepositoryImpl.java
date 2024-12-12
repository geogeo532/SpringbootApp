package com.aplicatie.Corbeanu_George_java_app.repository;

import com.aplicatie.Corbeanu_George_java_app.DTO.ClasamentDTO;
import com.aplicatie.Corbeanu_George_java_app.DTO.JucatorDTO;
import com.aplicatie.Corbeanu_George_java_app.model.Jucator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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
        String query = "SELECT j.nume_jucator, e.tara, j.pozitie_jucata, sj.goluri, sj.pase_decisive, sj.cartonase_galbene, sj.cartonase_rosii " +
                "FROM jucatori j " +
                "JOIN echipe e ON j.id_echipa = e.id_echipa " +
                "JOIN statistici_jucatori sj ON sj.id_jucator = j.id_jucator";

        // Executăm interogarea și obținem rezultatele
        List<Object[]> result = entityManager.createNativeQuery(query).getResultList();

        List<JucatorDTO> jucatori = new ArrayList<>();
        for (Object[] row : result) {
            String numeJucator = (String) row[0];
            String tara = (String) row[1];
            String pozitieJucata = (String) row[2];
            int goluri = (int) row[3];
            int paseDecisive = (int) row[4];
            int cartonaseGalbene = (int) row[5];
            int cartonaseRosii = (int) row[6];

            // Creăm DTO-ul cu toate câmpurile și îl adăugăm la listă
            JucatorDTO jucatorDTO = new JucatorDTO(numeJucator, tara, pozitieJucata, goluri, paseDecisive, cartonaseGalbene, cartonaseRosii);
            jucatori.add(jucatorDTO);
        }

        return jucatori;
    }

    public List<JucatorDTO> getJucatoriByMinGoals(int minGoals)
    {String query = "SELECT j.nume_jucator, e.tara, j.pozitie_jucata, sj.goluri " +
            "FROM jucatori j " +
            "JOIN echipe e ON j.id_echipa = e.id_echipa " +
            "JOIN statistici_jucatori sj ON sj.id_jucator = j.id_jucator "+
            "WHERE goluri >= :minPoints " +
            "ORDER BY goluri DESC";


        Query nativeQuery = entityManager.createNativeQuery(query);
        nativeQuery.setParameter("minPoints", minGoals);


        // Executăm interogarea și obținem rezultatele
        List<Object[]> result = nativeQuery.getResultList();

        List<JucatorDTO> jucatori = new ArrayList<>();
        for (Object[] row : result) {
            String numeJucator = (String) row[0];
            String tara = (String) row[1];
            String pozitieJucata = (String) row[2];
            int goluri = (int) row[3];

            // Creăm DTO-ul cu toate câmpurile și îl adăugăm la listă
            JucatorDTO jucatorDTO = new JucatorDTO(numeJucator, tara, pozitieJucata, goluri);
            jucatori.add(jucatorDTO);
        }

        return jucatori;

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
