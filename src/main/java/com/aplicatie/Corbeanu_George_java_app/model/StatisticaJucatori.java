/** Clasa pentru crearea modelului pentru cheia primara compusa a tabelului statistica_jucatori
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */


package com.aplicatie.Corbeanu_George_java_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "statistici_jucatori", schema = "dbo")
public class StatisticaJucatori {

    @Id
    @Column(name = "id_statistica")
    private int id_statistica;
    @Id
    @Column(name = "id_jucator")
    private int id_jucator;
    @Column
    private int goluri = 0;
    @Column
    private int pase_decisive = 0;
    @Column
    private int cartonase_galbene = 0;
    @Column
    private int cartonase_rosii = 0;

    public StatisticaJucatori(int id_statistica, int id_jucator, int goluri, int pase_decisive, int cartonase_galbene, int cartonase_rosii) {
        this.id_statistica = id_statistica;
        this.id_jucator = id_jucator;
        this.goluri = goluri;
        this.pase_decisive = pase_decisive;
        this.cartonase_galbene = cartonase_galbene;
        this.cartonase_rosii = cartonase_rosii;
    }

    public void setId_statistica(int id_statistica) {
        this.id_statistica = id_statistica;
    }

    public void setId_jucator(int id_jucator) {
        this.id_jucator = id_jucator;
    }

    public void setGoluri(int goluri) {
        this.goluri = goluri;
    }

    public void setPase_decisive(int pase_decisive) {
        this.pase_decisive = pase_decisive;
    }

    public void setCartonase_galbene(int cartonase_galbene) {
        this.cartonase_galbene = cartonase_galbene;
    }

    public void setCartonase_rosii(int cartonase_rosii) {
        this.cartonase_rosii = cartonase_rosii;
    }

    public int getId_statistica() {
        return id_statistica;
    }

    public int getId_jucator() {
        return id_jucator;
    }

    public int getGoluri() {
        return goluri;
    }

    public int getPase_decisive() {
        return pase_decisive;
    }

    public int getCartonase_galbene() {
        return cartonase_galbene;
    }

    public int getCartonase_rosii() {
        return cartonase_rosii;
    }


}
