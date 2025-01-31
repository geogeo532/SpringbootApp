/** Clasa pentru crearea modelului pentru cheia primara compusa a tabelului clasament
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */
package com.aplicatie.Corbeanu_George_java_app.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClasamentId implements Serializable {
    private int id_clasament;
    private int id_echipa;

    // Constructori, getter, setter
    public ClasamentId() {}

    public ClasamentId(int id_clasament, int id_echipa) {
        this.id_clasament = id_clasament;
        this.id_echipa = id_echipa;
    }

    public int getId_clasament() {
        return id_clasament;
    }

    public void setId_clasament(int id_clasament) {
        this.id_clasament = id_clasament;
    }

    public int getId_echipa() {
        return id_echipa;
    }

    public void setId_echipa(int id_echipa) {
        this.id_echipa = id_echipa;
    }

    // Implementați equals și hashCode pentru a compara corect instanțele
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClasamentId that = (ClasamentId) o;
        return id_clasament == that.id_clasament && id_echipa == that.id_echipa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_clasament, id_echipa);
    }
}
