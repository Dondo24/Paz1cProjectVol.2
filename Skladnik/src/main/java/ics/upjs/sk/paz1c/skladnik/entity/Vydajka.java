/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ics.upjs.sk.paz1c.skladnik.entity;

import ics.upjs.sk.paz1c.skladnik.entity.Pouzivatel;
import ics.upjs.sk.paz1c.skladnik.entity.Material;

/**
 *
 * @author Daniel
 */
public class Vydajka {
    
    private long id;
    private int pocet;
    private long id_pouzivat;
    private long id_material;
    private double cena ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPocet() {
        return pocet;
    }

    public void setPocet(int pocet) {
        this.pocet = pocet;
    }

    public long getId_pouzivat() {
        return id_pouzivat;
    }

    public void setId_pouzivat(long id_pouzivat) {
        this.id_pouzivat = id_pouzivat;
    }

    public long getId_material() {
        return id_material;
    }

    public void setId_material(long id_material) {
        this.id_material = id_material;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
   
    
}
