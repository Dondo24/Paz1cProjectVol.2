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
import javax.sql.RowSet;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
        String sql = "insert into  Prijemka values(?,?,?,?,?)";       
       jdbcTemplate.update(sql,null,prijemka.getCena(),prijemka.getId_pouzivatel(),prijemka.getDatum(),prijemka.getTypPohybu());
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
        
        List<Prijemka> prijemky = jdbcTemplate.query(sql, new RowMapper<Prijemka>() {
            @Override
            public Prijemka mapRow(ResultSet rs, int i) throws SQLException {
               Prijemka p = new Prijemka();
               p.setId(rs.getLong("id"));
               p.setCena(rs.getDouble("cena"));
               p.setId_pouzivatel(rs.getLong("pouzivatel_id"));
               p.setDatum(rs.getString("datum"));
               p.setTypPohybu(rs.getLong("typ_pohybu"));
               return p;
            }
        });   
        return prijemky;
    }

    @Override
    public int getLastId() {
       String sql = "select max(id) from Prijemka";   
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }
    
    @Override
    public void upravCenu(double cena, long id){
        String sql = " update prijemka set cena = ? where id = ?";
       jdbcTemplate.update(sql, cena, id);
    
    }
    
    
    
}
