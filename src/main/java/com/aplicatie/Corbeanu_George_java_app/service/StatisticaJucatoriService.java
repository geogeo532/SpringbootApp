/** Clasa pentru crearea service-ului pentru tabela statistici_jucatori
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.service;

import com.aplicatie.Corbeanu_George_java_app.model.StatisticaJucatori;
import com.aplicatie.Corbeanu_George_java_app.model.StatisticaJucatoriId;

import java.util.List;

public interface StatisticaJucatoriService {

    List<StatisticaJucatori> get();

    StatisticaJucatori get(StatisticaJucatoriId id);

    void save(StatisticaJucatori statisticaJucatori);

    void update(StatisticaJucatori statisticaJucatori);

    void delete(StatisticaJucatoriId id);
}
