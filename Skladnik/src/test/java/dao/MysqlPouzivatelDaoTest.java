/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Factory.TestObjectFactory;
import ics.upjs.sk.paz1c.skladnik.entity.Pouzivatel;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class MysqlPouzivatelDaoTest {
    private MysqlPouzivatelDao test = new MysqlPouzivatelDao(TestObjectFactory.INSTANCE.getJdbcTemplate());
    private Pouzivatel testPouzivatel = new Pouzivatel();
    private Pouzivatel testPouzivatel2 = new Pouzivatel();
    public MysqlPouzivatelDaoTest() {
       
        testPouzivatel.setId_sklad(1);
        testPouzivatel.setMeno("pista");
        testPouzivatel.setHeslo("1111");
       testPouzivatel2.setId_sklad(1);
       testPouzivatel2.setMeno("Dano");
       testPouzivatel2.setHeslo("0000");
    }

    @Test
    public void testDajPouzivatela() {
         test.vymazKazdeho();
        String ocakaneheslo = "1111";
        test.pridajPouzivatela(testPouzivatel);
        Pouzivatel testpouz = test.dajPouzivatela("pista");
        testpouz.setHeslo(ocakaneheslo);
        String heslo = testpouz.getHeslo();
        
        Assert.assertEquals(heslo, ocakaneheslo);
    }

    @Test
    public void testNastavHeslo() {
        String noveHeslo = "2222";
        test.nastavHeslo("pista", noveHeslo);
        Pouzivatel testpouz = test.dajPouzivatela("pista");
        String noveOcakavaneHeslo = testpouz.getHeslo();
        Assert.assertEquals(noveHeslo, noveOcakavaneHeslo);
    }

    @Test
    public void testPridajPouzivatela() {
        test.vymazKazdeho();
        List<String> predPridanim = test.dajVsetkychMena();
        test.pridajPouzivatela(testPouzivatel2);
        List<String> popridani = test.dajVsetkychMena();
        Assert.assertEquals(popridani.size()-1,predPridanim.size());
    }

    @Test
    public void testDajVsetkychMena() {
         test.vymazKazdeho();
        test.pridajPouzivatela(testPouzivatel);
        List<String> vsetci = test.dajVsetkychMena();
        Assert.assertNotNull(vsetci);
    }
    
}
