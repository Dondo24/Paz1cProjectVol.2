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
    private PohybMaterialu testpohyb = new PohybMaterialu();
    
    public MysqlPohybMaterialuDaoTest() {
        
       
        
    }

    @Test
    public void testPridajPohybMaterialuPrijem() {
        PohybMaterialu test2 = new PohybMaterialu();
        test2.setPrijemka_id(2);
        
          System.out.println("Ahoj");
        test.pridajPohybMaterialuPrijem(test2);
        List<PohybMaterialu> vsetky = test.getAll();
         System.out.println("Ahoj");
        int pocitadlopred = 0;
        int pocitadlopo= 0;
        for (PohybMaterialu pohybMaterialu : vsetky) {
            if(pohybMaterialu.getPrijemka_id()!=0){
                pocitadlopred++;            
        } 
          
        }
          System.out.println(pocitadlopo);
        testpohyb.setPrijemka_id(1);
        test.pridajPohybMaterialuPrijem(testpohyb);
         for (PohybMaterialu pohybMaterialu : vsetky) {
            if(pohybMaterialu.getPrijemka_id()!=0){
                pocitadlopo++;            
        }     
        }
         Assert.assertEquals(pocitadlopo, pocitadlopred+1);
    }

    @Test
    public void testPridajPohybMaterialuVydaj() {
    }

    @Test
    public void testGetAllPohybyByPrijemkaId() {
    }

    @Test
    public void testGetAllPohybyByVydajkaId() {
    }

    @Test
    public void testGetPohybyByMaterialId() {
    }
    
}
