/** Clasa pentru modelul clasament, modificat special pentru afisarea pe pagina de frontend
 * @author Corbeanu George
 * @version 11 Ianuarie 2025
 */

package com.aplicatie.Corbeanu_George_java_app.DTO;

public class ClasamentDTO {
    private String tara;
    private int pozitie_finala;
    private int meciuri_jucate;
    private int victorii;
    private int infrangeri;
    private int puncte;
    private int golaveraj;
    private String grupa; // adăugăm grupa

    // Constructorul include acum și grupa
    public ClasamentDTO(String tara, int pozitieFinala, int meciuriJucate, int victorii, int infrangeri,
                        int puncte, int golaveraj, String grupa) {
        this.tara = tara;
        this.pozitie_finala = pozitieFinala;
        this.meciuri_jucate = meciuriJucate;
        this.victorii = victorii;
        this.infrangeri = infrangeri;
        this.puncte = puncte;
        this.golaveraj = golaveraj;
        this.grupa = grupa;
    }

    public ClasamentDTO(String tara, int meciuri_jucate, int puncte, int golaveraj) {
        this.tara = tara;
        this.meciuri_jucate = meciuri_jucate;
        this.puncte = puncte;
        this.golaveraj = golaveraj;
    }

    public String getTara() {
        return tara;
    }

    public int getPozitie_finala() {
        return pozitie_finala;
    }

    public int getMeciuri_jucate() {
        return meciuri_jucate;
    }

    public int getVictorii() {
        return victorii;
    }

    public int getInfrangeri() {
        return infrangeri;
    }

    public int getPuncte() {
        return puncte;
    }

    public int getGolaveraj() {
        return golaveraj;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public void setPozitie_finala(int pozitieFinala) {
        this.pozitie_finala = pozitieFinala;
    }

    public void setMeciuri_jucate(int meciuriJucate) {
        this.meciuri_jucate = meciuriJucate;
    }

    public void setVictorii(int victorii) {
        this.victorii = victorii;
    }

    public void setPuncte(int puncte) {
        this.puncte = puncte;
    }

    public void setInfrangeri(int infrangeri) {
        this.infrangeri = infrangeri;
    }

    public void setGolaveraj(int golaveraj) {
        this.golaveraj = golaveraj;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

}
