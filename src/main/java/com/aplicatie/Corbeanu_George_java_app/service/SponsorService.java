/** Clasa pentru crearea service-ului pentru tabela sponsori
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.service;

import com.aplicatie.Corbeanu_George_java_app.DTO.SponsorDTO;
import com.aplicatie.Corbeanu_George_java_app.model.Sponsor;
import java.util.List;

public interface SponsorService {

    public List<SponsorDTO> getSponsori();

    Sponsor get(int id);

    void save(Sponsor sponsor);

    void update(Sponsor sponsor);

    void delete(int id);
}
