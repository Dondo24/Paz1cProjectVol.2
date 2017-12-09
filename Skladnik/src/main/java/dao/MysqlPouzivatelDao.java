/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ics.upjs.sk.paz1c.skladnik.entity.Pouzivatel;
import java.sql.ResultSet;
import java.util.List;
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
    public Pouzivatel dajPouzivatela(String meno) {
        String sql = "SELECT * from pouzivatel where meno = ?";
         BeanPropertyRowMapper<Pouzivatel> mapper = BeanPropertyRowMapper.newInstance(Pouzivatel.class);
        return jdbcTemplate.queryForObject(sql, mapper, meno);
    }

    @Override
    public void nastavHeslo(String meno, String heslo) {
       jdbcTemplate.update("update pouzivatel set heslo = ? where meno =?",heslo , meno);
    }

    @Override
    public void pridajPouzivatela(Pouzivatel pouzivatel) {
     String sql = "INSERT INTO Pouzivatel (id,meno,Sklad_id,heslo) VALUES (?,?,?,?)";
      jdbcTemplate.update(sql,pouzivatel.getId(),pouzivatel.getMeno(), pouzivatel.getId_sklad(),pouzivatel.getHeslo());

    }

    @Override
    public List<String> dajVsetkychMena() {
        String sql = "SELECT meno from pouzivatel";      
         BeanPropertyRowMapper<Pouzivatel> mapper = BeanPropertyRowMapper.newInstance(Pouzivatel.class);
         List<String> menaPouzivatelov = (List<String>) jdbcTemplate.queryForList(sql,String.class);
        return menaPouzivatelov;


    }

   
    
    
}
