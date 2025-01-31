/** Clasa pentru crearea implementarii service-ului pentru tabela sponsori
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.service;

import com.aplicatie.Corbeanu_George_java_app.DTO.SponsorDTO;
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
    public List<SponsorDTO> getSponsori() {
        return sponsorRepository.getSponsori();
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
