/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ics.upjs.sk.paz1c.skladnik.entity;



/**
 *
 * @author Daniel
 */
public class Material {
        
    private long id;
    private String nazov;
    private double stav;
    private double cena;
    private long id_sklad;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public double getStav() {
        return stav;
    }

    public void setStav(double stav) {
        this.stav = stav;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public long getId_sklad() {
        return id_sklad;
    }

    public void setId_sklad(long id_sklad) {
        this.id_sklad = id_sklad;
    }

    
}
