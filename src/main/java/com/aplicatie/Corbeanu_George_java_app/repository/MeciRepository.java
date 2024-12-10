package com.aplicatie.Corbeanu_George_java_app.repository;

import com.aplicatie.Corbeanu_George_java_app.model.Meci;
import java.util.List;

public interface MeciRepository {

    List<Meci> get();

    Meci get(int id);

    void save(Meci meci);

    void update(Meci meci);

    void delete(int id);
}
