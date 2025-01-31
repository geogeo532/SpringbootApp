/** Clasa pentru crearea implementarii service-ului pentru tabela statistici_echipe
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.service;

import com.aplicatie.Corbeanu_George_java_app.model.StatisticaEchipe;
import com.aplicatie.Corbeanu_George_java_app.model.StatisticaEchipeId;
import com.aplicatie.Corbeanu_George_java_app.repository.StatisticaEchipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticaEchipeServiceImpl implements StatisticaEchipeService {

    @Autowired
    private StatisticaEchipeRepository statisticaEchipeRepository;

    @Override
    public List<StatisticaEchipe> get() {
        return statisticaEchipeRepository.get();
    }

    @Override
    public StatisticaEchipe get(StatisticaEchipeId id) {
        return statisticaEchipeRepository.get(id);
    }

    @Override
    public void save(StatisticaEchipe statisticaEchipe) {
        statisticaEchipeRepository.save(statisticaEchipe);
    }

    @Override
    public void update(StatisticaEchipe statisticaEchipe) {
        statisticaEchipeRepository.update(statisticaEchipe);
    }

    @Override
    public void delete(StatisticaEchipeId id) {
        statisticaEchipeRepository.delete(id);
    }
}
