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
    private long id_pouzivatel; 
    private double cena ;
    private String datum;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

  

    public long getId_pouzivatel() {
        return id_pouzivatel;
    }

    public void setId_pouzivatel(long id_pouzivatel) {
        this.id_pouzivatel = id_pouzivatel;
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

    @Override
    public String toString() {
        return "Vydajka{" + "id=" + id + ", id_pouzivatel=" + id_pouzivatel + ", cena=" + cena + ", datum=" + datum + '}';
    }
    
    
   
    
}
