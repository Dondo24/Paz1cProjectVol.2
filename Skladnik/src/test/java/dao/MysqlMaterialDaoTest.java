/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Factory.TestObjectFactory;
import ics.upjs.sk.paz1c.skladnik.entity.Material;
import java.time.Clock;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class MysqlMaterialDaoTest {
    
            private MysqlMaterialDao test = new MysqlMaterialDao(TestObjectFactory.INSTANCE.getJdbcTemplate());
            private Material testMaterial = new Material();
           
    
    public MysqlMaterialDaoTest() {
      
      
        testMaterial.setCena(1);
        testMaterial.setId((long)1);
        testMaterial.setId_sklad(1);
        testMaterial.setNazov("Test");
        testMaterial.setStav(10);
    }

    @Test
    public void testPridajMaterial() {
        
         List<Material> vsetky = test.getAll();
         Material prvy = vsetky.get(0);
        long  prveID = prvy.getId();
        for (int i = 0; i < vsetky.size(); i++) {
            test.odstranMaterial(test.dajMaterialById(prveID+i));
        }
        List<Material> predPridanim = test.getAll();
        int pred = predPridanim.size();
        test.pridajMaterial(testMaterial);
        int po = test.getAll().size();
        System.out.println(pred);
        System.out.println(po);

        Assert.assertEquals(pred, po-1);
       
    }

    @Test
    public void testDajMaterialById() {
        List<Material> vsetky = test.getAll();
        Material akt = vsetky.get(0);
        long id = akt.getId();
        
        Material materialTest = test.dajMaterialById(id);
        Assert.assertEquals(testMaterial.getNazov(), akt.getNazov());
    }

    @Test
    public void testOdstranMaterial() {
       List<Material> vsetky = test.getAll();
       long id = vsetky.get(0).getId();
       test.odstranMaterial(test.dajMaterialById(id));
        assertEquals(vsetky.size(), test.getAll().size()+1);
    }

    @Test
    public void testGetAll() {
       Assert.assertEquals(test.getAll().size(), test.dajNazovVsetkychMaterialov().size());
    }

    @Test
    public void testDajNazovVsetkychMaterialov() {
         Assert.assertEquals(test.dajNazovVsetkychMaterialov().size(),test.getAll().size() );
    }

    @Test
    public void testUpravStavMaterial() {
    test.pridajMaterial(testMaterial);
     List<Material> vsetky = test.getAll();
       long id = vsetky.get(0).getId();
    long aktualnystav = test.dajMaterialById(id).getStav();
    long UpravaStavu = 9;
    test.upravStavMaterial(id, UpravaStavu, 1);
        assertEquals(test.dajMaterialById(id).getStav(), aktualnystav+UpravaStavu);
    }

    @Test
    public void testUpravCenuMaterialu() {
        List<Material> vsetky = test.getAll();
        long id = vsetky.get(0).getId();
        double CenaNaUpravu = 0.5;
        test.upravCenuMaterialu(id, CenaNaUpravu);
        Assert.assertEquals(CenaNaUpravu, test.dajMaterialById(id).getCena());
      
      
    }
    
}
