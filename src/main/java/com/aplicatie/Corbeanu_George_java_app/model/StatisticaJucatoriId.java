package com.aplicatie.Corbeanu_George_java_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StatisticaJucatoriId implements Serializable {

    @Column(name = "id_statistica")
    private int id_statistica;

    @Column(name = "id_jucator")
    private int id_jucator;

    public StatisticaJucatoriId() {}

    public StatisticaJucatoriId(int id_statistica, int id_jucator) {
        this.id_statistica = id_statistica;
        this.id_jucator = id_jucator;
    }

    public int getId_statistica() {
        return id_statistica;
    }

    public void setId_statistica(int id_statistica) {
        this.id_statistica = id_statistica;
    }

    public int getId_jucator() {
        return id_jucator;
    }

    public void setId_jucator(int id_jucator) {
        this.id_jucator = id_jucator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticaJucatoriId that = (StatisticaJucatoriId) o;
        return id_statistica == that.id_statistica && id_jucator == that.id_jucator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_statistica, id_jucator);
    }
}
