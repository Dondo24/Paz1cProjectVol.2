/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ics.upjs.sk.paz1c.skladnik.entity.Material;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface MaterialDao {
    
    void pridajMaterial(Material Material);
    public Material dajMaterialById (long id);
    void odstranMaterial(Material material);
    public List <Material> getAll();
    List<String> dajNazovVsetkychMaterialov();
    void upravStavMaterial(long idMaterialu, double pocet, long typPohybu);
    void upravCenuMaterialu(long idMaterialu, double cena);

    
}
