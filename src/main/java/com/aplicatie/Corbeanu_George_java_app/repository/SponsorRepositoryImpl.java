/** Clasa pentru crearea implementării repository-ului pentru tabela sponsori
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.repository;

import com.aplicatie.Corbeanu_George_java_app.DTO.SponsorDTO;
import com.aplicatie.Corbeanu_George_java_app.model.Sponsor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SponsorRepositoryImpl implements SponsorRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<SponsorDTO> getSponsori() {
        String query = "SELECT s.nume_sponsor, e.tara AS echipa_tara, " +
                "s.industria, s.tara AS sponsor_tara, se.durata_sponsorizare, se.valoare_sponsorizare " +
                "FROM sponsori s " +
                "JOIN sponsori_echipe se ON s.id_sponsor = se.id_sponsor " +
                "JOIN echipe e ON se.id_echipa = e.id_echipa";

        // Executăm interogarea și obținem rezultatele
        List<Object[]> result = entityManager.createNativeQuery(query).getResultList();

        List<SponsorDTO> sponsori = new ArrayList<>();
        for (Object[] row : result) {
            String numeSponsor = (String) row[0];
            String echipaTara = (String) row[1];
            String industria = (String) row[2];
            String sponsorTara = (String) row[3];
            int durataSponsorizare = (Integer) row[4];
            int valoareSponsorizare = (Integer) row[5];

            // Creăm DTO-ul și îl adăugăm la listă
            SponsorDTO sponsorDTO = new SponsorDTO(numeSponsor, echipaTara, industria, sponsorTara, durataSponsorizare, valoareSponsorizare);
            sponsori.add(sponsorDTO);
        }

        return sponsori;
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
