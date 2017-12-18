/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Factory.TestObjectFactory;
import org.junit.Test;
import static org.junit.Assert.*;


public class MysqlPrijemkaDaoTest {
    private MysqlPrijemkaDao test = new MysqlPrijemkaDao(TestObjectFactory.INSTANCE.getJdbcTemplate());
    
    public MysqlPrijemkaDaoTest() {
    }

    @Test
    public void testPridajPrijemka() {
    }

    @Test
    public void testDajPrijemkuById() {
    }

    @Test
    public void testOdstranPrijemku() {
    }

    @Test
    public void testGetAll() {
    }

    @Test
    public void testGetLastId() {
    }

    @Test
    public void testUpravCenu() {
    }

    @Test
    public void testDajDnesneOPrijemky() {
    }

    @Test
    public void testDajPrijemkyNaMesiac() {
    }

    @Test
    public void testDajPrijemkyNaRok() {
    }

    @Test
    public void testDajPrijemkuNaDatum() {
    }

    @Test
    public void testZmazVsetko() {
    }
    
}
