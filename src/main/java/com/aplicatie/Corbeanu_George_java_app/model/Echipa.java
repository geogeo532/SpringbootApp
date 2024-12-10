package com.aplicatie.Corbeanu_George_java_app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "echipe", schema = "dbo")
public class Echipa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_echipa")
    private int id_echipa;
    @Column
    private String tara;
    @Column
    private String antrenor;

    public int getId_echipa() {
        return id_echipa;
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

    @Column
    private String palmares;

    public void setId_echipa(int id_echipa) {
        this.id_echipa = id_echipa;
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
}
