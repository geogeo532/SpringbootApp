package com.aplicatie.Corbeanu_George_java_app.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class SponsorDTO {

    private String nume_Sponsor;
    private String nume_echipa;
    private String industria;
    private String tara;
    private int durata_sponsorizare;
    private int valoare_sponsorizare;

    public SponsorDTO(String nume_Sponsor, String nume_echipa, String industria, String tara, int durata_sponsorizare, int valoare_sponsorizare) {
        this.nume_Sponsor = nume_Sponsor;
        this.nume_echipa = nume_echipa;
        this.industria = industria;
        this.tara = tara;
        this.durata_sponsorizare = durata_sponsorizare;
        this.valoare_sponsorizare = valoare_sponsorizare;
    }

    public String getNume_Sponsor() {
        return nume_Sponsor;
    }

    public String getNume_echipa() {
        return nume_echipa;
    }

    public String getIndustria() {
        return industria;
    }

    public String getTara() {
        return tara;
    }

    public int getDurata_sponsorizare() {
        return durata_sponsorizare;
    }

    public int getValoare_sponsorizare() {
        return valoare_sponsorizare;
    }

    public void setNume_Sponsor(String nume_Sponsor) {
        this.nume_Sponsor = nume_Sponsor;
    }

    public void setNume_echipa(String nume_echipa) {
        this.nume_echipa = nume_echipa;
    }

    public void setIndustria(String industria) {
        this.industria = industria;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public void setDurata_sponsorizare(int durata_sponsorizare) {
        this.durata_sponsorizare = durata_sponsorizare;
    }

    public void setValoare_sponsorizare(int valoare_sponsorizare) {
        this.valoare_sponsorizare = valoare_sponsorizare;
    }
}
