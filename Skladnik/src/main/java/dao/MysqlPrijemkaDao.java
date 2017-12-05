/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ics.upjs.sk.paz1c.skladnik.entity.Prijemka;
import ics.upjs.sk.paz1c.skladnik.entity.Vydajka;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Marcel
 */
public class MysqlPrijemkaDao implements PrijemkaDao {

    private final JdbcTemplate jdbcTemplate;
    
    public MysqlPrijemkaDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void pridajPrijemka(Prijemka prijemka) {
        String sql = "instert into  Prijemka values(?,?,?,?,?)";
       jdbcTemplate.update(sql, null, prijemka.getId(),prijemka.getPocet(),prijemka.getId_pouzivatel(),prijemka.getId_material(),prijemka.getCena());
    }

    @Override
    public Prijemka dajPrijemkuById(Long id) {
         String sql = "select * from Prijemka where id = ?";
        BeanPropertyRowMapper<Prijemka> mapper = BeanPropertyRowMapper.newInstance(Prijemka.class);
        return jdbcTemplate.queryForObject(sql, mapper, id);
    }

    @Override
    public void odstranPrijemku(Prijemka prijemka) {
        String sql = "deleter from Prijemka where id = ?";
        jdbcTemplate.update(sql,prijemka.getId());
    }

    @Override
    public List<Prijemka> getAll() {
          String sql = "select * from Prijemka";
        BeanPropertyRowMapper<Prijemka> mapper = BeanPropertyRowMapper.newInstance(Prijemka.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public int getLastId() {
       String sql = "select max(id) from Prijemka";   
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }
    
    
    
}
