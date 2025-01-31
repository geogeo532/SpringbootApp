/** Clasa pentru crearea modelului pentru cheia primara compusa a tabelului sponsori_echipe
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SponsorEchipeId implements Serializable {

    @Column(name = "id_sponsor")
    private int id_sponsor;

    @Column(name = "id_echipa")
    private int id_echipa;

    // Constructor implicit
    public SponsorEchipeId() {}

    // Constructor cu parametri
    public SponsorEchipeId(int id_sponsor, int id_echipa) {
        this.id_sponsor = id_sponsor;
        this.id_echipa = id_echipa;
    }

    // Getters and Setters
    public int getId_sponsor() {
        return id_sponsor;
    }

    public void setId_sponsor(int id_sponsor) {
        this.id_sponsor = id_sponsor;
    }

    public int getId_echipa() {
        return id_echipa;
    }

    public void setId_echipa(int id_echipa) {
        this.id_echipa = id_echipa;
    }

    // hashCode și equals sunt necesare pentru ca JPA să poată compara corect cheile compuse
    @Override
    public int hashCode() {
        return Objects.hash(id_sponsor, id_echipa);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SponsorEchipeId that = (SponsorEchipeId) obj;
        return id_sponsor == that.id_sponsor && id_echipa == that.id_echipa;
    }

}
