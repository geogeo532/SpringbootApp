package com.aplicatie.Corbeanu_George_java_app.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class StadionDTO {

    private String nume_stadion;
    private String nume_oras;
    private int capacitate;

    public StadionDTO(String nume_stadion, String nume_oras, int capacitate) {
        this.nume_stadion = nume_stadion;
        this.nume_oras = nume_oras;
        this.capacitate = capacitate;
    }

    public void setNume_stadion(String nume_stadion) {
        this.nume_stadion = nume_stadion;
    }

    public void setNume_oras(String nume_oras) {
        this.nume_oras = nume_oras;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
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
}
