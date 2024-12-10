package com.aplicatie.Corbeanu_George_java_app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stadioane", schema = "dbo")
public class Stadion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stadion")
    private int id_stadion;
    @Column
    private String nume_stadion;
    @Column
    private String nume_oras;
    @Column
    private int capacitate;

    public int getId_stadion() {
        return id_stadion;
    }

    public String getNume_stadion() {
        return nume_stadion;
    }

    public String getNume_oras() {
        return nume_oras;
    }

    public int getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }

    public void setNume_oras(String nume_oras) {
        this.nume_oras = nume_oras;
    }

    public void setId_stadion(int id_stadion) {
        this.id_stadion = id_stadion;
    }

    public void setNume_stadion(String nume_stadion) {
        this.nume_stadion = nume_stadion;
    }


}
