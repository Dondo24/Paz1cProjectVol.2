/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Factory.TestObjectFactory;
import ics.upjs.sk.paz1c.skladnik.entity.PohybMaterialu;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class MysqlPohybMaterialuDaoTest {
    
    private MysqlPohybMaterialuDao test = new MysqlPohybMaterialuDao(TestObjectFactory.INSTANCE.getJdbcTemplate());
    private PohybMaterialu testpohybV = new PohybMaterialu();
    private PohybMaterialu testpohybP = new PohybMaterialu();
    public MysqlPohybMaterialuDaoTest() {
        testpohybP.setCena(1);
        testpohybP.setId_materialu(1);
        testpohybP.setPocet(1);
        testpohybP.setPrijemka_id(1);
        testpohybP.setVydajka_id(0);
        System.out.println("ahojjjjj");
        testpohybV.setCena(1);
        testpohybV.setId_materialu(1);
        testpohybV.setPocet(1);
       // testpohybV.setPrijemka_id(0);
        testpohybV.setVydajka_id(1);
       
        
    }

    @Test
    public void testPridajPohybMaterialuPrijem() {
        
        List<PohybMaterialu> vsetky = test.getAll();
        test.pridajPohybMaterialuPrijem(testpohybP);
        Assert.assertEquals(vsetky.size(), test.getAll().size()-1);
        
      
    }

    @Test
    public void testPridajPohybMaterialuVydaj() {
         List<PohybMaterialu> vsetky = test.getAll();
        test.pridajPohybMaterialuVydaj(testpohybV);
        Assert.assertEquals(vsetky.size(), test.getAll().size()-1);
        
    }
    

    @Test
    public void testGetAllPohybyByPrijemkaId() {
        test.zmazVsetko();
        test.pridajPohybMaterialuPrijem(testpohybP);
        List<PohybMaterialu> vsetky = test.getAll();
        PohybMaterialu prve = vsetky.get(0);
        long id = prve.getPrijemka_id();
        List<PohybMaterialu>  prijem = test.getAllPohybyByPrijemkaId(id);
        Assert.assertEquals(prijem.size(), 1);
    }

    @Test
    public void testGetAllPohybyByVydajkaId() {
        test.zmazVsetko();
        test.pridajPohybMaterialuVydaj(testpohybV);
        List<PohybMaterialu> vsetky = test.getAll();
        PohybMaterialu prve = vsetky.get(0);
        long id = prve.getVydajka_id();
        List<PohybMaterialu> vydaj = test.getAllPohybyByVydajkaId(id);
        Assert.assertEquals(vydaj.size(), 1);
    }

    @Test
    public void testGetPohybyByMaterialId() {
         test.zmazVsetko();
         test.pridajPohybMaterialuPrijem(testpohybP);
         List<PohybMaterialu> vsetky = test.getAll();
         PohybMaterialu prve = vsetky.get(0);
         long idmaterialu = prve.getId_materialu();
         List<PohybMaterialu> materialid = test.getPohybyByMaterialId(idmaterialu);
         Assert.assertEquals(materialid.size(), 1);
    }
    
}
