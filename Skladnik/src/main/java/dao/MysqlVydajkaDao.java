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
        String sql = "delete from Vydajka where id = ?";
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
        if(getAll().size()==0){
        return 0;
        }
       String sql = "select max(id) from vydajka";   
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }
    
    @Override
    public void upravCenu(double cena, long id){
        String sql = " update vydajka set cena = ? where id = ?";
       jdbcTemplate.update(sql, cena, id);
    
    }

    @Override
    public List<Vydajka> dajDnesneVydajky() {
         String sql = "Select id ,cena , datum from Vydajka WHERE DATE(datum) = DATE(NOW()) ORDER BY id DESC";
       
       return (jdbcTemplate.query(sql,new VydajkaRowMapper()));
    }

    @Override
    public List<Vydajka> dajVydajkyNaMesiac(int mesiac, int rok) {
        String sql = "Select id,cena ,datum from Vydajka where month(datum) = " + mesiac + " and year(datum)= " + rok + " order by id desc";
       
       return (jdbcTemplate.query(sql, new VydajkaRowMapper()));
    }

    @Override
    public List<Vydajka> dajVydajkyNaRok(int rok) {
       String sql = "Select id,cena ,datum from Vydajka where year(datum)= " + rok + " order by id desc";
       
       return (jdbcTemplate.query(sql, new VydajkaRowMapper()));
    }

    @Override
    public List<Vydajka> dajVydajkuNaDatum(int rok, int mesiac, int den) {
         String sql = "Select id,cena ,datum from Vydajka where year(datum)= " + rok + " and month(datum) = " + mesiac +" and day(datum)= "+ den +" order by id desc";
       return (jdbcTemplate.query(sql, new VydajkaRowMapper()));
    }

    @Override
    public void zmazVsetko() {
        jdbcTemplate.update("truncate vydajka");
    }

    @Override
    public List<Vydajka> getAllByPouzivatelId(long id) {
       String sql = "select * from Vydajka where pouzivatel_id = ?";
        
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
        }, id);   
        return vydajky;
    }
private class VydajkaRowMapper implements RowMapper<Vydajka> {

        @Override
        public Vydajka mapRow(ResultSet rs, int i) throws SQLException {
            Vydajka vydajka = new Vydajka();
            vydajka.setId(rs.getLong("id"));
            vydajka.setCena(rs.getDouble("cena"));
            vydajka.setDatum(rs.getString("datum"));
            
            return vydajka;
        }

    }
    
}
