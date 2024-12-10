package com.aplicatie.Corbeanu_George_java_app.repository;

import com.aplicatie.Corbeanu_George_java_app.model.Sponsor;
import java.util.List;

public interface SponsorRepository {

    List<Sponsor> get();

    Sponsor get(int id);

    void save(Sponsor sponsor);

    void update(Sponsor sponsor);

    void delete(int id);
}
