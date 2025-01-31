/** Clasa pentru crearea modelului sponsori_echipe
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sponsori_echipe", schema = "dbo")
public class SponsorEchipe {
    @Id
    @Column(name = "id_sponsor")
    private int id_sponsor;
    @Id
    @Column(name = "id_echipa")
    private int id_echipa;
    @Column
    private String data_incepere_sponsorizare;
    @Column
    private int durata_sponsorizare;
    @Column
    private int valoare_sponsorizare;

    public int getId_sponsor() {
        return id_sponsor;
    }

    public int getId_echipa() {
        return id_echipa;
    }

    public String getData_incepere_sponsorizare() {
        return data_incepere_sponsorizare;
    }

    public int getDurata_sponsorizare() {
        return durata_sponsorizare;
    }

    public int getValoare_sponsorizare() {
        return valoare_sponsorizare;
    }

    public void setId_sponsor(int id_sponsor) {
        this.id_sponsor = id_sponsor;
    }

    public void setId_echipa(int id_echipa) {
        this.id_echipa = id_echipa;
    }

    public void setData_incepere_sponsorizare(String data_incepere_sponsorizare) {
        this.data_incepere_sponsorizare = data_incepere_sponsorizare;
    }

    public void setDurata_sponsorizare(int durata_sponsorizare) {
        this.durata_sponsorizare = durata_sponsorizare;
    }

    public void setValoare_sponsorizare(int valoare_sponsorizare) {
        this.valoare_sponsorizare = valoare_sponsorizare;
    }
}
