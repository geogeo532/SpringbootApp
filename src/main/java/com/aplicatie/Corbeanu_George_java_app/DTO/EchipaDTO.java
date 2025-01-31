/** Clasa pentru modelul echipa, modificat special pentru afisarea pe pagina de frontend
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class EchipaDTO {
    @NotBlank(message = "Țara este obligatorie.")
    private String tara;
    @NotBlank(message = "Antrenorul este obligatoriu.")
    private String antrenor;
    @NotBlank(message = "Palmaresul este obligatoriu.")
    private String palmares;

    public EchipaDTO(String tara, String antrenor, String palmares) {
        this.tara = tara;
        this.antrenor = antrenor;
        this.palmares = palmares;
    }

    public EchipaDTO(String tara, String antrenor) {
        this.tara = tara;
        this.antrenor = antrenor;
    }

    public EchipaDTO() {

    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public void setAntrenor(String antrenor) {
        this.antrenor = antrenor;
    }

    public void setPalmares(String palmares) {
        this.palmares = palmares;
    }

    public String getTara() {
        return tara;
    }

    public String getAntrenor() {
        return antrenor;
    }

    public String getPalmares() {
        return palmares;
    }
}
