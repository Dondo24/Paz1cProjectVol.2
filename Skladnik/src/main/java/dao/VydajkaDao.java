/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ics.upjs.sk.paz1c.skladnik.entity.Prijemka;
import ics.upjs.sk.paz1c.skladnik.entity.Vydajka;
import java.util.List;

/**
 *
 * @author Marcel
 */
public interface VydajkaDao {
    
    
void pridajVydajku(Vydajka vydajka);
    public Vydajka dajVydajkaById (Long id);
    void odstranVydajku(Vydajka vydajka);
    public List <Vydajka> getAll();
      public List <Vydajka> getAllByPouzivatelId(long id);
    public int getLastId();
    void upravCenu(double cena, long id);
public List<Vydajka> dajDnesneVydajky();
    public List<Vydajka> dajVydajkyNaMesiac(int mesiac, int rok);
    public List<Vydajka> dajVydajkyNaRok(int rok );
    public List<Vydajka> dajVydajkuNaDatum(int rok , int mesiac , int den);
    void zmazVsetko();
    
}
