package com.aplicatie.Corbeanu_George_java_app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "meciuri", schema = "dbo")
public class Meci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_meci")
    private int id_meci;
    @Column
    private String data_meci;
    @Column
    private int echipa_gazda;
    @Column
    private int echipa_oaspete;
    @Column
    private int scor_gazde;
    @Column
    private int scor_oaspeti;
    @Column
    private int id_stadion;


    public void setId_meci(int id_meci) {
        this.id_meci = id_meci;
    }

    public void setData_meci(String data_meci) {
        this.data_meci = data_meci;
    }

    public void setEchipa_gazda(int echipa_gazda) {
        this.echipa_gazda = echipa_gazda;
    }

    public void setEchipa_oaspete(int echipa_oaspete) {
        this.echipa_oaspete = echipa_oaspete;
    }

    public void setScor_gazde(int scor_gazde) {
        this.scor_gazde = scor_gazde;
    }

    public void setScor_oaspeti(int scor_oaspeti) {
        this.scor_oaspeti = scor_oaspeti;
    }

    public void setId_stadion(int id_stadion) {
        this.id_stadion = id_stadion;
    }

    public int getScor_oaspeti() {
        return scor_oaspeti;
    }

    public int getId_stadion() {
        return id_stadion;
    }

    public int getScor_gazde() {
        return scor_gazde;
    }

    public String getData_meci() {
        return data_meci;
    }

    public int getEchipa_gazda() {
        return echipa_gazda;
    }

    public int getEchipa_oaspete() {
        return echipa_oaspete;
    }

    public int getId_meci() {
        return id_meci;
    }



}
