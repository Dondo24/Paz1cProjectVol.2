/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ics.upjs.sk.paz1c.skladnik.entity.Sklad;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface SkladDao {
    
    void pridajSklad(Sklad sklad);
    public Sklad dajSklad(Long id);
    void odstranSklad(Sklad sklad);
    public Sklad dajIdSkladu(String nazov);
    List<String> dajVsetkySklady();
    void odstranVsetky();
}
