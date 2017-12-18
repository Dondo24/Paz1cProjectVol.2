/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Factory.TestObjectFactory;
import ics.upjs.sk.paz1c.skladnik.entity.Prijemka;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class MysqlPrijemkaDaoTest {

    private MysqlPrijemkaDao test = new MysqlPrijemkaDao(TestObjectFactory.INSTANCE.getJdbcTemplate());
    private Prijemka testPrijemka = new Prijemka();
    private Calendar cal = new GregorianCalendar();

    public MysqlPrijemkaDaoTest() {
        testPrijemka.setCena(1);
        testPrijemka.setId_pouzivatel(1);
        testPrijemka.setTypPohybu(1);
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        testPrijemka.setDatum(timeStamp);

    }

    @Test
    public void testPridajPrijemka() {
        test.ZmazVsetko();
        List<Prijemka> vsetky = test.getAll();
        int pocetPred = vsetky.size();
        test.pridajPrijemka(testPrijemka);
        Assert.assertEquals(pocetPred, test.getAll().size() - 1);

    }

    @Test
    public void testDajPrijemkuById() {
        test.ZmazVsetko();
        test.pridajPrijemka(testPrijemka);
        List<Prijemka> vsetky = test.getAll();
        Prijemka prva = vsetky.get(0);
        Prijemka dana = test.dajPrijemkuById(prva.getId());
        Assert.assertEquals(prva.getId(), dana.getId());

    }

    @Test
    public void testOdstranPrijemku() {
        test.ZmazVsetko();
        test.pridajPrijemka(testPrijemka);
        List<Prijemka> vsetky = test.getAll();
        Prijemka prva = vsetky.get(0);
        test.odstranPrijemku(prva);
        Assert.assertEquals(vsetky.size(), test.getAll().size() + 1);

    }

    @Test
    public void testGetAll() {
        test.ZmazVsetko();
        test.pridajPrijemka(testPrijemka);
        assertNotNull(test.getAll());

    }

    @Test
    public void testGetLastId() {
        test.ZmazVsetko();
        test.pridajPrijemka(testPrijemka);
        long id = test.getLastId();
        assertNotNull(id);

    }

    @Test
    public void testUpravCenu() {
        test.ZmazVsetko();
        test.pridajPrijemka(testPrijemka);
        double staracena = testPrijemka.getCena();
        test.upravCenu(2, testPrijemka.getId());
        assertNotEquals(staracena, 2);

    }

    @Test
    public void testDajDnesneOPrijemky() {
        test.ZmazVsetko();
        test.pridajPrijemka(testPrijemka);
        List<Prijemka> vsetky = test.dajDnesneOPrijemky();
        Assert.assertEquals(vsetky.size(), 1);

    }

    @Test
    public void testDajPrijemkyNaMesiac() {
        test.ZmazVsetko();
        int rok = cal.get(Calendar.YEAR);
        int mesiac = cal.get(Calendar.MONTH) + 1;
        test.pridajPrijemka(testPrijemka);
        List<Prijemka> vsetky = test.dajPrijemkyNaMesiac(mesiac, rok);
        Assert.assertEquals(vsetky.size(), 1);

    }

    @Test
    public void testDajPrijemkyNaRok() {
        test.ZmazVsetko();
        int rok = cal.get(Calendar.YEAR);
        test.pridajPrijemka(testPrijemka);
        List<Prijemka> vsetky = test.dajPrijemkyNaRok(rok);
        Assert.assertEquals(vsetky.size(), 1);

    }

    @Test
    public void testDajPrijemkuNaDatum() {
        test.ZmazVsetko();
        int rok = cal.get(Calendar.YEAR);
        int mesiac = cal.get(Calendar.MONTH) + 1;
        int den = cal.get(Calendar.DAY_OF_MONTH);

        test.pridajPrijemka(testPrijemka);
        List<Prijemka> vsetky = test.dajPrijemkuNaDatum(rok, mesiac, den);
        Assert.assertEquals(vsetky.size(), 1);

    }

    @Test
    public void testZmazVsetko() {
        test.pridajPrijemka(testPrijemka);
        test.ZmazVsetko();
        Assert.assertEquals(test.getAll().size(), 0);
    }

}
