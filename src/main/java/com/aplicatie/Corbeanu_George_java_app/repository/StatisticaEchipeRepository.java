package com.aplicatie.Corbeanu_George_java_app.repository;

import com.aplicatie.Corbeanu_George_java_app.model.StatisticaEchipe;
import com.aplicatie.Corbeanu_George_java_app.model.StatisticaEchipeId;

import java.util.List;

public interface StatisticaEchipeRepository {

    List<StatisticaEchipe> get();

    StatisticaEchipe get(StatisticaEchipeId id);

    void save(StatisticaEchipe statisticaEchipe);

    void update(StatisticaEchipe statisticaEchipe);

    void delete(StatisticaEchipeId id);
}
