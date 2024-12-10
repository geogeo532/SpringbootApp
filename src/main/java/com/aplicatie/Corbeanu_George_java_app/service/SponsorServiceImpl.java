package com.aplicatie.Corbeanu_George_java_app.service;

import com.aplicatie.Corbeanu_George_java_app.model.Sponsor;
import com.aplicatie.Corbeanu_George_java_app.repository.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SponsorServiceImpl implements SponsorService {

    @Autowired
    private SponsorRepository sponsorRepository;

    @Transactional
    @Override
    public List<Sponsor> get() {
        return sponsorRepository.get();
    }

    @Transactional
    @Override
    public Sponsor get(int id) {
        return sponsorRepository.get(id);
    }

    @Transactional
    @Override
    public void save(Sponsor sponsor) {
        sponsorRepository.save(sponsor);
    }

    @Transactional
    @Override
    public void update(Sponsor sponsor) {
        sponsorRepository.update(sponsor);
    }

    @Transactional
    @Override
    public void delete(int id) {
        sponsorRepository.delete(id);
    }
}
