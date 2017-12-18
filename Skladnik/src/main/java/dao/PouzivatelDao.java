/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ics.upjs.sk.paz1c.skladnik.entity.Pouzivatel;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface PouzivatelDao {
    void pridajPouzivatela(Pouzivatel pouzivatel);
    Pouzivatel dajPouzivatela(String meno);
    void nastavHeslo(String meno,String heslo);
    List<String> dajVsetkychMena();
    void vymazKazdeho();
}
