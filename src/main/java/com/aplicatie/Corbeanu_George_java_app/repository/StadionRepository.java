package com.aplicatie.Corbeanu_George_java_app.repository;

import com.aplicatie.Corbeanu_George_java_app.DTO.StadionDTO;
import com.aplicatie.Corbeanu_George_java_app.model.Stadion;
import java.util.List;

public interface StadionRepository {

    public List<StadionDTO> getStadioane();

    Stadion get(int id);

    void save(Stadion stadion);

    void update(Stadion stadion);

    void delete(int id);
}
