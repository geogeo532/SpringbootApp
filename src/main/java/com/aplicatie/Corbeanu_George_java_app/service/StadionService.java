package com.aplicatie.Corbeanu_George_java_app.service;

import com.aplicatie.Corbeanu_George_java_app.model.Stadion;
import java.util.List;

public interface StadionService {

    List<Stadion> get();

    Stadion get(int id);

    void save(Stadion stadion);

    void update(Stadion stadion);

    void delete(int id);
}
