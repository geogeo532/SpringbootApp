package com.aplicatie.Corbeanu_George_java_app.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class MeciDTO {

    private String data_meci;
    private String echipa_gazda;
    private String echipa_oaspete;
    private int scor_gazde;
    private int scor_oaspeti;
    private String nume_stadion;

    public MeciDTO(String data_meci, String echipa_gazda, String echipa_oaspete, int scor_gazde, int scor_oaspeti, String nume_stadion) {
        this.data_meci = data_meci;
        this.echipa_gazda = echipa_gazda;
        this.echipa_oaspete = echipa_oaspete;
        this.scor_gazde = scor_gazde;
        this.scor_oaspeti = scor_oaspeti;
        this.nume_stadion = nume_stadion;
    }

    public String getData_meci() {
        return data_meci;
    }

    public String getEchipa_gazda() {
        return echipa_gazda;
    }

    public String getEchipa_oaspete() {
        return echipa_oaspete;
    }

    public int getScor_gazde() {
        return scor_gazde;
    }

    public int getScor_oaspeti() {
        return scor_oaspeti;
    }

    public String getNume_stadion() {
        return nume_stadion;
    }

    public void setData_meci(String data_meci) {
        this.data_meci = data_meci;
    }

    public void setEchipa_gazda(String echipa_gazda) {
        this.echipa_gazda = echipa_gazda;
    }

    public void setEchipa_oaspete(String echipa_oaspete) {
        this.echipa_oaspete = echipa_oaspete;
    }

    public void setScor_gazde(int scor_gazde) {
        this.scor_gazde = scor_gazde;
    }

    public void setScor_oaspeti(int scor_oaspeti) {
        this.scor_oaspeti = scor_oaspeti;
    }

    public void setNume_stadion(String nume_stadion) {
        this.nume_stadion = nume_stadion;
    }
}
