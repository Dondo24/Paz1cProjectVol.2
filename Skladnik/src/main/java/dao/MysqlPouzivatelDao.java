/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ics.upjs.sk.paz1c.skladnik.entity.Pouzivatel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Daniel
 */
public class MysqlPouzivatelDao implements PouzivatelDao{

    private JdbcTemplate jdbcTemplate;
    
    public MysqlPouzivatelDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Pouzivatel dajHeslo(String meno) {
        String sql = "SELECT Heslo from pouzivatel where   Meno = ?";
         BeanPropertyRowMapper<Pouzivatel> mapper = BeanPropertyRowMapper.newInstance(Pouzivatel.class);
        return jdbcTemplate.queryForObject(sql, mapper, meno);
    }

    @Override
    public void nastavHeslo(String meno, String heslo) {
       jdbcTemplate.update("update pouzivatel set heslo = ? where id =?",heslo , meno);
    }

    @Override
    public void pridajPouzivatela(Pouzivatel pouzivatel) {
     String sql = "INSERT INTO Pouzivatel VALUES (?,?,?,?)";
      jdbcTemplate.update(sql, null, pouzivatel.getId(), pouzivatel.getId_sklad(),pouzivatel.getMeno(),pouzivatel.getHeslo());
    }

   
    
    
}
