package com.aplicatie.Corbeanu_George_java_app.repository;

import com.aplicatie.Corbeanu_George_java_app.model.StatisticaJucatori;
import com.aplicatie.Corbeanu_George_java_app.model.StatisticaJucatoriId;

import java.util.List;

public interface StatisticaJucatoriRepository {

    List<StatisticaJucatori> get();

    StatisticaJucatori get(StatisticaJucatoriId id);

    void save(StatisticaJucatori statisticaJucatori);

    void update(StatisticaJucatori statisticaJucatori);

    void delete(StatisticaJucatoriId id);
}
