/** Clasa pentru crearea implementarii service-ului pentru tabela clasament
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.service;

import com.aplicatie.Corbeanu_George_java_app.DTO.ClasamentDTO;
import com.aplicatie.Corbeanu_George_java_app.model.Clasament;
import com.aplicatie.Corbeanu_George_java_app.model.ClasamentId;
import com.aplicatie.Corbeanu_George_java_app.repository.ClasamentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ClasamentServiceImpl implements ClasamentService {

    @Autowired
    private ClasamentRepository clasamentRepository;
    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<ClasamentDTO> getClasaments() {
        return clasamentRepository.getClasaments();
    }

    @Transactional
    @Override
    public List<ClasamentDTO> getClasamenteByMinPoints(int minPoints)
    {
        return clasamentRepository.getClasamenteByMinPoints(minPoints);
    }

    @Transactional
    @Override
    public Clasament getClasament(ClasamentId clasamentId) {
        return clasamentRepository.findById(clasamentId)
                .orElseThrow(() -> new EntityNotFoundException("Clasament not found!"));
    }


    @Transactional
    @Override
    public void save(Clasament clasament) {
        clasamentRepository.save(clasament);
    }

    @Transactional
    @Override
    public void update(Clasament clasament) {
        clasamentRepository.update(clasament);
    }

    @Transactional
    @Override
    public void delete(ClasamentId id) {
        Clasament clasament = entityManager.find(Clasament.class, id);
        if (clasament != null) {
            entityManager.remove(clasament);
        } else {
            throw new EntityNotFoundException("Clasament not found with id: " + id);
        }
    }


    @Override
    public void deleteByClasamentId(int idClasament) {
        // Find all Clasament entries with the given id_clasament
        List<Clasament> clasamente = clasamentRepository.findByClasamentId(idClasament);
        if (clasamente.isEmpty()) {
            throw new EntityNotFoundException("No clasamente found with id_clasament: " + idClasament);
        }
        // Delete all found clasamente entries in a batch
        clasamentRepository.deleteInBatch(clasamente);
    }

    @Override
    public void deleteByEchipaId(int idEchipa) {
        // Find all Clasament entries with the given id_echipa
        List<Clasament> clasamente = clasamentRepository.findByEchipaId(idEchipa);
        if (clasamente.isEmpty()) {
            throw new EntityNotFoundException("No clasamente found with id_echipa: " + idEchipa);
        }
        // Delete all found clasamente entries in a batch
        clasamentRepository.deleteInBatch(clasamente);
    }

    @Override
    @Transactional
    public void deleteClasament(ClasamentId clasamentId) {
        clasamentRepository.deleteById(clasamentId);  // Deleting by composite key
    }

    @Transactional
    @Override
    public void deleteClasamentById(int idClasament) {
        clasamentRepository.deleteByClasamentId(idClasament);
    }

}
