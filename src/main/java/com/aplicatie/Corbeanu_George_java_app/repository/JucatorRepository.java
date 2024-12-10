package com.aplicatie.Corbeanu_George_java_app.repository;

import com.aplicatie.Corbeanu_George_java_app.model.Jucator;

import java.util.List;

public interface JucatorRepository {

    List<Jucator> get();

    Jucator get(int id);

    void save(Jucator jucator);

    void update(Jucator jucator);

    void delete(int id);
}
