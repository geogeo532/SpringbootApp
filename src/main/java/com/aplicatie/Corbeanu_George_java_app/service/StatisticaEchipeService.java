/** Clasa pentru crearea service-ului pentru tabela statistici_echipe
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.service;

import com.aplicatie.Corbeanu_George_java_app.model.StatisticaEchipe;
import com.aplicatie.Corbeanu_George_java_app.model.StatisticaEchipeId;

import java.util.List;

public interface StatisticaEchipeService {

    List<StatisticaEchipe> get();

    StatisticaEchipe get(StatisticaEchipeId id);

    void save(StatisticaEchipe statisticaEchipe);

    void update(StatisticaEchipe statisticaEchipe);

    void delete(StatisticaEchipeId id);
}
