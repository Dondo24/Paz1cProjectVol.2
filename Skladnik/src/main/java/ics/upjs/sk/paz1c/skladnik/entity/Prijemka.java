/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ics.upjs.sk.paz1c.skladnik.entity;

import ics.upjs.sk.paz1c.skladnik.entity.Pouzivatel;
import ics.upjs.sk.paz1c.skladnik.entity.Material;
import java.util.Date;

/**
 *
 * @author Daniel
 */
public class Prijemka {
    private long id; 
    private double cena;
    private long id_pouzivatel; 
    private String datum;
    private long typPohybu;

    public long getId() {
        return id;
    }

    public long getTypPohybu() {
        return typPohybu;
    }

    public void setTypPohybu(long typPohybu) {
        this.typPohybu = typPohybu;
    }

    public void setId(long id) {
        this.id = id;
    }


    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public long getId_pouzivatel() {
        return id_pouzivatel;
    }

    public void setId_pouzivatel(long id_pouzivatel) {
        this.id_pouzivatel = id_pouzivatel;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

 


    @Override
    public String toString() {
        return "Prijemka{" + "id=" + id + ", cena=" + cena + ", id_pouzivatel=" + id_pouzivatel + ", datum=" + datum + '}';
    }


    

  
}
