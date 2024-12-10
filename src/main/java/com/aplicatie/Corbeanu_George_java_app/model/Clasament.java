package com.aplicatie.Corbeanu_George_java_app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clasamente", schema = "dbo")
@IdClass(ClasamentId.class)
public class Clasament {

    @Id
    @Column(name = "id_clasament")
    private int id_clasament;
    @Id
    @Column(name = "id_echipa")
    private int id_echipa;
    @Column
    private int pozitie_finala;
    @Column
    private int meciuri_jucate = 0;
    @Column
    private int victorii = 0;
    @Column
    private int infrangeri = 0;
    @Column
    private int puncte = 0;
    @Column
    private int golaveraj;



    public int getId_clasament() {
        return id_clasament;
    }

    public int getId_echipa() {
        return id_echipa;
    }

    public int getPozitie_finala() {
        return pozitie_finala;
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

    public int getPuncte() {
        return puncte;
    }

    public int getGolaveraj() {
        return golaveraj;
    }

    public void setId_clasament(int id_clasament) {
        this.id_clasament = id_clasament;
    }

    public void setId_echipa(int id_echipa) {
        this.id_echipa = id_echipa;
    }

    public void setPozitie_finala(int pozitie_finala) {
        this.pozitie_finala = pozitie_finala;
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

    public void setPuncte(int puncte) {
        this.puncte = puncte;
    }

    public void setGolaveraj(int golaveraj) {
        this.golaveraj = golaveraj;
    }
}
