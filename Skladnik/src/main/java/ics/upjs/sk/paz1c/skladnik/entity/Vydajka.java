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
    private long id_pouzivat; 
    private double cena ;
    private String datum;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

  

    public long getId_pouzivat() {
        return id_pouzivat;
    }

    public void setId_pouzivat(long id_pouzivat) {
        this.id_pouzivat = id_pouzivat;
    }
   

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }
    
    
   
    
}
