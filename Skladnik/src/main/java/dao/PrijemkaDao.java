/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import ics.upjs.sk.paz1c.skladnik.entity.Prijemka;
import java.util.List;

/**
 *
 * @author Marcel
 */
public interface PrijemkaDao  {
    
    
    
    void pridajPrijemka(Prijemka Prijemka);
    public Prijemka dajPrijemkuById (Long id);
    void odstranPrijemku(Prijemka prijemka);
    public List <Prijemka> getAll();
     public List <Prijemka> getAllByUzivatelId(long id);
    public int getLastId();    
    void upravCenu(double cena, long id);
    public List<Prijemka> dajDnesneOPrijemky(long idPouzivatela);
    public List<Prijemka> dajPrijemkyNaMesiac(int mesiac, int rok,long idPouzivatela);
    public List<Prijemka> dajPrijemkyNaRok(int rok ,long idPouzivatela);
    public List<Prijemka> dajPrijemkuNaDatum(int rok , int mesiac , int den,long idPouzivatela);
    void ZmazVsetko();
}
