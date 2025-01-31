/** Clasa pentru crearea service-ului pentru tabela meciuri
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.service;

import com.aplicatie.Corbeanu_George_java_app.DTO.MeciDTO;
import com.aplicatie.Corbeanu_George_java_app.model.Meci;
import java.util.List;

public interface MeciService {

    public List<MeciDTO> getMeciuri();

    Meci get(int id);

    void save(Meci meci);

    void update(Meci meci);

    void delete(int id);
}
