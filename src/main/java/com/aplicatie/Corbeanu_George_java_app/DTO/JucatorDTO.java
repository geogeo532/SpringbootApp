package com.aplicatie.Corbeanu_George_java_app.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class JucatorDTO {

    private String nume_jucator;
    private String tara;
    private String  pozitie_jucata;
    private int goluri;
    private int pase_decisive;
    private int cartonase_galbene;
    private int cartonase_rosii;

    public JucatorDTO(String nume_jucator, String tara, String pozitie_jucata, int goluri, int pase_decisive, int cartonase_galbene, int cartonase_rosii) {
        this.nume_jucator = nume_jucator;
        this.tara = tara;
        this.pozitie_jucata = pozitie_jucata;
        this.goluri = goluri;
        this.pase_decisive = pase_decisive;
        this.cartonase_galbene = cartonase_galbene;
        this.cartonase_rosii = cartonase_rosii;
    }

    public JucatorDTO(String nume_jucator, String tara, String pozitie_jucata, int goluri) {
        this.nume_jucator = nume_jucator;
        this.tara = tara;
        this.pozitie_jucata = pozitie_jucata;
        this.goluri = goluri;

    }


    public String getNume_jucator() {
        return nume_jucator;
    }

    public String getTara() {
        return tara;
    }

    public String getPozitie_jucata() {
        return pozitie_jucata;
    }

    public void setNume_jucator(String nume_jucator) {
        this.nume_jucator = nume_jucator;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public void setPozitie_jucata(String pozitie_jucata) {
        this.pozitie_jucata = pozitie_jucata;
    }

    public int getGoluri() {
        return goluri;
    }

    public int getPase_decisive() {
        return pase_decisive;
    }

    public int getCartonase_galbene() {
        return cartonase_galbene;
    }

    public int getCartonase_rosii() {
        return cartonase_rosii;
    }

    public void setGoluri(int goluri) {
        this.goluri = goluri;
    }

    public void setPase_decisive(int pase_decisive) {
        this.pase_decisive = pase_decisive;
    }

    public void setCartonase_rosii(int cartonase_rosii) {
        this.cartonase_rosii = cartonase_rosii;
    }

    public void setCartonase_galbene(int cartonase_galbene) {
        this.cartonase_galbene = cartonase_galbene;
    }
}
