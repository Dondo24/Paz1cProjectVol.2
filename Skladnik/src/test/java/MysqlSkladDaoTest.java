
import Factory.ObjectFactory;
import dao.MysqlSkladDao;
import dao.SkladDao;
import ics.upjs.sk.paz1c.skladnik.entity.Sklad;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcel
 */
public class MysqlSkladDaoTest {
    
    @Test
    public void testPridajSklad(){
        SkladDao skladDao = ObjectFactory.INSTANCE.getSkladDao();
        Sklad sklad = new Sklad();
        sklad.setNazov("materialovy");
        sklad.setAdresa("komenskeho");
        skladDao.pridajSklad(sklad);
        assertNotNull(skladDao.dajSklad(sklad.getId()));
        assertEquals(sklad, skladDao.dajSklad(sklad.getId()));
    }
    
}
