package com.aplicatie.Corbeanu_George_java_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StatisticaEchipeId implements Serializable {

    @Column(name = "id_statistica_echipa")
    private int id_statistica_echipa;

    @Column(name = "id_echipa")
    private int id_echipa;

    public StatisticaEchipeId() {}

    public StatisticaEchipeId(int id_statistica_echipa, int id_echipa) {
        this.id_statistica_echipa = id_statistica_echipa;
        this.id_echipa = id_echipa;
    }

    public int getId_statistica_echipa() {
        return id_statistica_echipa;
    }

    public void setId_statistica_echipa(int id_statistica_echipa) {
        this.id_statistica_echipa = id_statistica_echipa;
    }

    public int getId_echipa() {
        return id_echipa;
    }

    public void setId_echipa(int id_echipa) {
        this.id_echipa = id_echipa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticaEchipeId that = (StatisticaEchipeId) o;
        return id_statistica_echipa == that.id_statistica_echipa && id_echipa == that.id_echipa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_statistica_echipa, id_echipa);
    }
}
