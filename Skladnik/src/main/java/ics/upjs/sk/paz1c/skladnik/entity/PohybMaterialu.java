/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ics.upjs.sk.paz1c.skladnik.entity;

/**
 *
 * @author Marcel
 */
public class PohybMaterialu {
    
    
    private long id;
    private int typPohybu;
    private int id_materialu;
    private int pocet;
    private double cena;
    private int prijemka_id;
    private int vydajka_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTypPohybu() {
        return typPohybu;
    }

    public void setTypPohybu(int typPohybu) {
        this.typPohybu = typPohybu;
    }

    public int getId_materialu() {
        return id_materialu;
    }

    public void setId_materialu(int id_materialu) {
        this.id_materialu = id_materialu;
    }

    public int getPocet() {
        return pocet;
    }

    public void setPocet(int pocet) {
        this.pocet = pocet;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getPrijemka_id() {
        return prijemka_id;
    }

    public void setPrijemka_id(int prijemka_id) {
        this.prijemka_id = prijemka_id;
    }

    public int getVydajka_id() {
        return vydajka_id;
    }

    public void setVydajka_id(int vydajka_id) {
        this.vydajka_id = vydajka_id;
    }
    

    
}
