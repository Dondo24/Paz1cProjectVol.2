/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Factory.TestObjectFactory;
import ics.upjs.sk.paz1c.skladnik.entity.Sklad;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class MysqlSkladDaoTest {
    
    private MysqlSkladDao test = new MysqlSkladDao(TestObjectFactory.INSTANCE.getJdbcTemplate());
    private Sklad testSklad = new Sklad();
    
    public MysqlSkladDaoTest() {
        test.odstranVsetky();
        testSklad.setAdresa("Hlavna");
        testSklad.setNazov("Elektro");
      ///  testSklad.setId(1);
    }

    @Test
    public void testPridajSklad() {
        List<String> vsetky = test.dajVsetkySklady();
        int predpridanim = vsetky.size();
        test.pridajSklad(testSklad);
        List<String> vsetkyPoPridani = test.dajVsetkySklady();
        int popridani = vsetkyPoPridani.size();
        Assert.assertEquals(predpridanim+1, popridani);
        test.odstranSklad(testSklad);
        
    }

    @Test
    public void testDajSklad() {
        
    }

    @Test
    public void testOdstranSklad() {
         test.pridajSklad(testSklad);
         List<String> vsetky = test.dajVsetkySklady();
        int predOdstranenim = vsetky.size();
        String prvynaodstraneni = vsetky.get(0);
        Sklad odstran = test.dajIdSkladu(prvynaodstraneni);
        
        test.odstranSklad(odstran);
        List<String> vsetkyPoOdstraneni = test.dajVsetkySklady();
        int poodstraneni = vsetkyPoOdstraneni.size();
        Assert.assertEquals(predOdstranenim-1, poodstraneni);
        
    }

    @Test
    public void testDajIdSkladu() {
        test.pridajSklad(testSklad);
        long id = testSklad.getId();
        Assert.assertNotNull(id);
        test.odstranSklad(testSklad);
        
    }

    @Test
    public void testDajVsetkySklady() {
        test.pridajSklad(testSklad);
        List<String> vsetky = test.dajVsetkySklady();
        int pocet = vsetky.size();
        assertNotEquals(pocet, 0);
        test.odstranSklad(testSklad);
    }
    
}
