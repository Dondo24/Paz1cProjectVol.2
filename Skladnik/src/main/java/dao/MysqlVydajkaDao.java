/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ics.upjs.sk.paz1c.skladnik.entity.Prijemka;
import ics.upjs.sk.paz1c.skladnik.entity.Vydajka;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
       String sql = "insert into  Vydajka values(?,?,?,?,?)";
       jdbcTemplate.update(sql, null,vydajka.getId_pouzivatel(),vydajka.getCena(),vydajka.getDatum(),vydajka.getTyp_pohybu());
    }

    @Override
    public Vydajka dajVydajkaById(Long id) {
        String sql = "select * from Vydajka where id = ?";
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
        String sql = "select * from Vydajka";
        
        List<Vydajka> vydajky = jdbcTemplate.query(sql, new RowMapper<Vydajka>() {
            @Override
            public Vydajka mapRow(ResultSet rs, int i) throws SQLException {
              Vydajka v = new Vydajka();
               v.setId(rs.getLong("id"));
               v.setCena(rs.getDouble("cena"));
               v.setId_pouzivatel(rs.getLong("pouzivatel_id"));
               v.setDatum(rs.getString("datum"));
               v.setTyp_pohybu(rs.getLong("typ_pohybu"));
               return v;
            }
        });   
        return vydajky;
    }

    
    @Override
    public int getLastId() {
       String sql = "select max(id) from vydajka";   
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }
    
    @Override
    public void upravCenu(double cena, long id){
        String sql = " update vydajka set cena = ? where id = ?";
       jdbcTemplate.update(sql, cena, id);
    
    }

    
}
