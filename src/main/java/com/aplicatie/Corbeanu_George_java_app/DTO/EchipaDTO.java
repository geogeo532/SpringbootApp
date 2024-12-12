package com.aplicatie.Corbeanu_George_java_app.DTO;

import jakarta.persistence.Column;

public class EchipaDTO {

    private String tara;
    private String antrenor;
    private String palmares;

    public EchipaDTO(String tara, String antrenor, String palmares) {
        this.tara = tara;
        this.antrenor = antrenor;
        this.palmares = palmares;
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
