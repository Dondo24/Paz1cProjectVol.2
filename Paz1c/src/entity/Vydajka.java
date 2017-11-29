/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.Pouzivatel;
import entity.Material;

/**
 *
 * @author Daniel
 */
public class Vydajka {
    
    private long id;
    private int pocet;
    private Pouzivatel pouzivat;
    private Material material;

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

    public Pouzivatel getPouzivat() {
        return pouzivat;
    }

    public void setPouzivat(Pouzivatel pouzivat) {
        this.pouzivat = pouzivat;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
    
}
