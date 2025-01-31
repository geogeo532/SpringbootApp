/** Clasa pentru crearea implementarii service-ului pentru tabela sponsori_echipe
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.service;

import com.aplicatie.Corbeanu_George_java_app.model.SponsorEchipe;
import com.aplicatie.Corbeanu_George_java_app.model.SponsorEchipeId;
import com.aplicatie.Corbeanu_George_java_app.repository.SponsorEchipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SponsorEchipeServiceImpl implements SponsorEchipeService {

    @Autowired
    private SponsorEchipeRepository sponsorEchipeRepository;

    @Transactional
    @Override
    public List<SponsorEchipe> get() {
        return sponsorEchipeRepository.get();
    }

    @Transactional
    @Override
    public SponsorEchipe get(SponsorEchipeId id) {
        return sponsorEchipeRepository.get(id);
    }

    @Transactional
    @Override
    public void save(SponsorEchipe sponsorEchipe) {
        sponsorEchipeRepository.save(sponsorEchipe);
    }

    @Transactional
    @Override
    public void update(SponsorEchipe sponsorEchipe) {
        sponsorEchipeRepository.update(sponsorEchipe);
    }

    @Transactional
    @Override
    public void delete(SponsorEchipeId id) {
        sponsorEchipeRepository.delete(id);
    }
}
