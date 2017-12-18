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
    private long id_materialu;
    private double pocet;
    private double cena;
    private long prijemka_id;
    private long vydajka_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getId_materialu() {
        return id_materialu;
    }

    public void setId_materialu(long id_materialu) {
        this.id_materialu = id_materialu;
    }

    public double getPocet() {
        return pocet;
    }

    public void setPocet(double pocet) {
        this.pocet = pocet;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public long getPrijemka_id() {
        return prijemka_id;
    }

    public void setPrijemka_id(long prijemka_id) {
        this.prijemka_id = prijemka_id;
    }

    public long getVydajka_id() {
        return vydajka_id;
    }

    public void setVydajka_id(long vydajka_id) {
        this.vydajka_id = vydajka_id;
    }
    

    
}
