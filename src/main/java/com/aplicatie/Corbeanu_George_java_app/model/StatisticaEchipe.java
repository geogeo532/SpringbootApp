package com.aplicatie.Corbeanu_George_java_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class StatisticaEchipe {

    @Id
    @Column(name = "id_statistica_echipa")
    private int id_statistica_echipa;
    @Id
    @Column(name = "id_echipa")
    private int id_echipa;
    @Column
    private int meciuri_jucate = 0;
    @Column
    private int victorii = 0;
    @Column
    private int infrangeri = 0;
    @Column
    private int goluri_marcate = 0;
    @Column
    private int goluri_primite=0;

    public StatisticaEchipe(int id_statistica_echipa, int meciuri_jucate, int id_echipa, int victorii, int infrangeri, int goluri_marcate, int goluri_primite) {
        this.id_statistica_echipa = id_statistica_echipa;
        this.meciuri_jucate = meciuri_jucate;
        this.id_echipa = id_echipa;
        this.victorii = victorii;
        this.infrangeri = infrangeri;
        this.goluri_marcate = goluri_marcate;
        this.goluri_primite = goluri_primite;
    }

    public void setId_statistica_echipa(int id_statistica_echipa) {
        this.id_statistica_echipa = id_statistica_echipa;
    }

    public void setId_echipa(int id_echipa) {
        this.id_echipa = id_echipa;
    }

    public void setMeciuri_jucate(int meciuri_jucate) {
        this.meciuri_jucate = meciuri_jucate;
    }

    public void setVictorii(int victorii) {
        this.victorii = victorii;
    }

    public void setInfrangeri(int infrangeri) {
        this.infrangeri = infrangeri;
    }

    public void setGoluri_marcate(int goluri_marcate) {
        this.goluri_marcate = goluri_marcate;
    }

    public void setGoluri_primite(int goluri_primite) {
        this.goluri_primite = goluri_primite;
    }

    public int getId_statistica_echipa() {
        return id_statistica_echipa;
    }

    public int getId_echipa() {
        return id_echipa;
    }

    public int getMeciuri_jucate() {
        return meciuri_jucate;
    }

    public int getVictorii() {
        return victorii;
    }

    public int getInfrangeri() {
        return infrangeri;
    }

    public int getGoluri_marcate() {
        return goluri_marcate;
    }

    public int getGoluri_primite() {
        return goluri_primite;
    }
}
