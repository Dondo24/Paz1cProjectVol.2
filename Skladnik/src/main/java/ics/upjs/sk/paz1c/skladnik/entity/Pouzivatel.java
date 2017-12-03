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
public class Pouzivatel {
 private long id;
 private String meno;
 private long id_sklad;
 private String heslo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public long getId_sklad() {
        return id_sklad;
    }

    public void setId_sklad(long id_sklad) {
        this.id_sklad = id_sklad;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

 
 
}
