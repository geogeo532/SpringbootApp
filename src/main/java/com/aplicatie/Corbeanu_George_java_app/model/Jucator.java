/** Clasa pentru crearea modelului jucator
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "jucatori", schema = "dbo")
public class Jucator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jucator")
    private int id_jucator;
    @Column
    private String nume_jucator;
    @Column
    private String  pozitie_jucata;
    @Column
    private int id_echipa;

    public void setId_jucator(int id_jucator) {
        this.id_jucator = id_jucator;
    }

    public void setNume_jucator(String nume_jucator) {
        this.nume_jucator = nume_jucator;
    }

    public void setPozitie_jucata(String pozitie_jucata) {
        this.pozitie_jucata = pozitie_jucata;
    }

    public String getNume_jucator() {
        return nume_jucator;
    }

    public String getPozitie_jucata() {
        return pozitie_jucata;
    }

    public void setId_echipa(int id_echipa) {
        this.id_echipa = id_echipa;
    }

    public int getId_jucator() {
        return id_jucator;
    }

    public int getId_echipa() {
        return id_echipa;
    }


}
