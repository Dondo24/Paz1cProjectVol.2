/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Factory.TestObjectFactory;
import ics.upjs.sk.paz1c.skladnik.entity.Vydajka;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class MysqlVydajkaDaoTest {
    private MysqlVydajkaDao test = new MysqlVydajkaDao(TestObjectFactory.INSTANCE.getJdbcTemplate());
    private Vydajka  testVydajka = new Vydajka();
  private Calendar cal = new GregorianCalendar();
    
    
    public MysqlVydajkaDaoTest() {
        testVydajka.setCena(1);
        testVydajka.setId_pouzivatel(1);
        testVydajka.setTyp_pohybu(2L);
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); 
        testVydajka.setDatum(timeStamp);
        
    }

    @Test
    public void testPridajVydajku() {
         test.zmazVsetko();
        List<Vydajka> vsetky = test.getAll();
        int pocetPred = vsetky.size();
        test.pridajVydajku(testVydajka);
        Assert.assertEquals(pocetPred,test.getAll().size()-1);
    }

    @Test
    public void testDajVydajkaById() {
        test.zmazVsetko();
            test.pridajVydajku(testVydajka);
            List<Vydajka> vsetky = test.getAll();
            Vydajka prva = vsetky.get(0);
            Vydajka dana = test.dajVydajkaById(prva.getId());
            Assert.assertEquals(prva.getId(), dana.getId());
    }

    @Test
    public void testOdstranVydajku() {
         test.zmazVsetko();
        test.pridajVydajku(testVydajka);
         List<Vydajka> vsetky = test.getAll();
         Vydajka prva = vsetky.get(0);
         test.odstranVydajku(prva);
         Assert.assertEquals(vsetky.size(), test.getAll().size()+1);
    }

    @Test
    public void testGetAll() {
          test.zmazVsetko();
        test.pridajVydajku(testVydajka);
        assertNotNull(test.getAll());
    }

    @Test
    public void testGetLastId() {
        test.zmazVsetko();
        test.pridajVydajku(testVydajka);
         long id =test.getLastId();
        assertNotNull(id);
        
    }

    @Test
    public void testUpravCenu() {
        test.zmazVsetko();
        test.pridajVydajku(testVydajka);
        double staracena = testVydajka.getCena();
        test.upravCenu(2, testVydajka.getId());
        assertNotEquals(staracena, 2);
    }

    @Test
    public void testDajDnesneVydajky() {
         test.zmazVsetko();
       test.pridajVydajku(testVydajka);
        List<Vydajka> vsetky = test.dajDnesneVydajky();
        Assert.assertEquals(vsetky.size(), 1);
    }

    @Test
    public void testDajVydajkyNaMesiac() {
        test.zmazVsetko();
        int rok = cal.get(Calendar.YEAR);
        int mesiac = cal.get(Calendar.MONTH)+1;
        test.pridajVydajku(testVydajka);
        List<Vydajka> vsetky = test.dajVydajkyNaMesiac(mesiac, rok);
        Assert.assertEquals(vsetky.size(), 1);
    }

    @Test
    public void testDajVydajkyNaRok() {
           test.zmazVsetko();
         int rok = cal.get(Calendar.YEAR);
         test.pridajVydajku(testVydajka);
        List<Vydajka> vsetky = test.dajVydajkyNaRok(rok);
        Assert.assertEquals(vsetky.size(), 1);
    }

    @Test
    public void testDajVydajkuNaDatum() {
        test.zmazVsetko();
         int rok = cal.get(Calendar.YEAR);
        int mesiac = cal.get(Calendar.MONTH)+1;
        int den = cal.get(Calendar.DAY_OF_MONTH);
        
        test.pridajVydajku(testVydajka);
        List<Vydajka> vsetky = test.dajVydajkuNaDatum(rok, mesiac, den);
        Assert.assertEquals(vsetky.size(), 1);
    }

    @Test
    public void testZmazVsetko() {
        test.pridajVydajku(testVydajka);
        test.zmazVsetko();
        Assert.assertEquals(test.getAll().size(),0);
    }
    
}
