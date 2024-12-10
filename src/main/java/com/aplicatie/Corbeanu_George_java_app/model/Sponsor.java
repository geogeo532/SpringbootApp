package com.aplicatie.Corbeanu_George_java_app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sponsori", schema = "dbo")
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sponsor")
    private int id_sponsor;
    @Column
    private String nume_Sponsor;
    @Column
    private String industria;
    @Column
    private String tara;

    public void setId_sponsor(int id_sponsor) {
        this.id_sponsor = id_sponsor;
    }

    public void setNume_Sponsor(String nume_Sponsor) {
        this.nume_Sponsor = nume_Sponsor;
    }

    public void setIndustria(String industria) {
        this.industria = industria;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public String getTara() {
        return tara;
    }

    public int getId_sponsor() {
        return id_sponsor;
    }

    public String getNume_Sponsor() {
        return nume_Sponsor;
    }

    public String getIndustria() {
        return industria;
    }


}
