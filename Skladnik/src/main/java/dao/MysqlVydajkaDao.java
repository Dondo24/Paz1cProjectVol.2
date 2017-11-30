/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ics.upjs.sk.paz1c.skladnik.entity.Vydajka;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Marcel
 */
public class MysqlVydajkaDao implements VydajkaDao{
    private JdbcTemplate jdbcTemplate;
    
    public MysqlVydajkaDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    

    @Override
    public void pridajVydajku(Vydajka vydajka) {
       String sql = "instert into  Vydajky values(?,?,?,?,?)";
       jdbcTemplate.update(sql, null, vydajka.getId(),vydajka.getPocet(),vydajka.getId_pouzivat(),vydajka.getId_material(),vydajka.getCena());
    }

    @Override
    public Vydajka dajVydajkaById(Long id) {
        String sql = "select * from Vydajky where id = ?";
        BeanPropertyRowMapper<Vydajka> mapper = BeanPropertyRowMapper.newInstance(Vydajka.class);
        return jdbcTemplate.queryForObject(sql, mapper, id);
                
    }

    @Override
    public void odstranVydajku(Vydajka vydajka) {
        String sql = "deleter from Vydajka where id = ?";
        jdbcTemplate.update(sql,vydajka.getId());
    }

    @Override
    public List<Vydajka> getAll() {
         String sql = "select * from Vydajky";
        BeanPropertyRowMapper<Vydajka> mapper = BeanPropertyRowMapper.newInstance(Vydajka.class);
        return jdbcTemplate.query(sql, mapper);
    }
    
}
