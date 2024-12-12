package com.aplicatie.Corbeanu_George_java_app.repository;

import com.aplicatie.Corbeanu_George_java_app.DTO.SponsorDTO;
import com.aplicatie.Corbeanu_George_java_app.model.Sponsor;
import java.util.List;

public interface SponsorRepository {

    public List<SponsorDTO> getSponsori();

    Sponsor get(int id);

    void save(Sponsor sponsor);

    void update(Sponsor sponsor);

    void delete(int id);
}
