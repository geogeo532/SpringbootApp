/** Clasa pentru crearea implementarii service-ului pentru tabela statistici_jucatori
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.service;

import com.aplicatie.Corbeanu_George_java_app.model.StatisticaJucatori;
import com.aplicatie.Corbeanu_George_java_app.model.StatisticaJucatoriId;
import com.aplicatie.Corbeanu_George_java_app.repository.StatisticaJucatoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticaJucatoriServiceImpl implements StatisticaJucatoriService {

    @Autowired
    private StatisticaJucatoriRepository statisticaJucatoriRepository;

    @Override
    public List<StatisticaJucatori> get() {
        return statisticaJucatoriRepository.get();
    }

    @Override
    public StatisticaJucatori get(StatisticaJucatoriId id) {
        return statisticaJucatoriRepository.get(id);
    }

    @Override
    public void save(StatisticaJucatori statisticaJucatori) {
        statisticaJucatoriRepository.save(statisticaJucatori);
    }

    @Override
    public void update(StatisticaJucatori statisticaJucatori) {
        statisticaJucatoriRepository.update(statisticaJucatori);
    }

    @Override
    public void delete(StatisticaJucatoriId id) {
        statisticaJucatoriRepository.delete(id);
    }
}
