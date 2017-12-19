/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import ics.upjs.sk.paz1c.skladnik.entity.PohybMaterialu;
import java.util.List;

/**
 *
 * @author Marcel
 */
public interface PohybMaterialuDao {
    
     
    void pridajPohybMaterialuPrijem(PohybMaterialu pohybMaterialu);
    void pridajPohybMaterialuVydaj(PohybMaterialu pohybMaterialu);
    public PohybMaterialu dajPohybMaterialuById (Long id);
    void odstranPohybMaterialu(PohybMaterialu pohybMaterialu);
    public List <PohybMaterialu> getAll();
    public List <PohybMaterialu> getAllPohybyByPrijemkaId(long id);
    public List <PohybMaterialu> getAllPohybyByVydajkaId(long id);
    public List<PohybMaterialu> getPohybyByMaterialId(long id);
    void zmazVsetko();
    public long getLastId();
   

    
}
