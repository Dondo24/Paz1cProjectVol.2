/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ics.upjs.sk.paz1c.skladnik.entity.Material;

/**
 *
 * @author Daniel
 */
public interface MaterialDao {
    
    void pridajMaterial(Material Material);
    public Material dajMaterialById (Long id);
    void odstranMaterial(Material material);
}
