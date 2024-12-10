package com.aplicatie.Corbeanu_George_java_app.repository;

import java.util.List;

import com.aplicatie.Corbeanu_George_java_app.model.Echipa;

public interface EchipaRepository {

    List<Echipa> get();

    Echipa get(int id);

    void save(Echipa echipa);

    void update(Echipa echipa);

    void delete(int id);
}
