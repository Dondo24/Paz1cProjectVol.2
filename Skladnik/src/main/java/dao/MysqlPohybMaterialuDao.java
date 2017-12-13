/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ics.upjs.sk.paz1c.skladnik.entity.Material;
import ics.upjs.sk.paz1c.skladnik.entity.PohybMaterialu;
import ics.upjs.sk.paz1c.skladnik.entity.Prijemka;
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
public class MysqlPohybMaterialuDao implements PohybMaterialuDao {
        private JdbcTemplate jdbcTemplate;
    
    public MysqlPohybMaterialuDao(JdbcTemplate jdbcTemplate){
       this.jdbcTemplate = jdbcTemplate;
   }

    @Override
    public void pridajPohybMaterialuPrijem(PohybMaterialu pohybMaterialu) {
         String sql = "insert into PohybMaterialu values(?,?,?,?,?,?)";
       jdbcTemplate.update(sql,null,pohybMaterialu.getId_materialu(),pohybMaterialu.getPocet(),pohybMaterialu.getCena(),pohybMaterialu.getPrijemka_id(),null);
    }
     @Override
    public void pridajPohybMaterialuVydaj(PohybMaterialu pohybMaterialu) {
         String sql = "insert into PohybMaterialu values(?,?,?,?,?,?)";
       jdbcTemplate.update(sql,null,pohybMaterialu.getId_materialu(),pohybMaterialu.getPocet(),pohybMaterialu.getCena(),null,pohybMaterialu.getVydajka_id());
    }

    @Override
    public PohybMaterialu dajPohybMaterialuById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void odstranPohybMaterialu(PohybMaterialu pohybMaterialu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PohybMaterialu> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PohybMaterialu> getAllPohybyByPrijemkaId(long id) {       
        
         String sql = "select * from pohybmaterialu where prijemka_id = ?";
        
        List<PohybMaterialu> pohyby = jdbcTemplate.query(sql, new RowMapper<PohybMaterialu>() {
            @Override
            public PohybMaterialu mapRow(ResultSet rs, int i) throws SQLException {
               PohybMaterialu p = new PohybMaterialu();
               p.setId(rs.getLong("id"));
               p.setCena(rs.getDouble("cena"));
               p.setId_materialu(rs.getLong("id_materialu"));
               p.setPrijemka_id(rs.getLong("prijemka_id"));
               p.setPocet(rs.getLong("pocet"));
               
               
               return p;
            }
        }, id);   
        return pohyby;
    }

    @Override
    public List<PohybMaterialu> getAllPohybyByVydajkaId(long id) {
        String sql = "select * from pohybmaterialu where vydajka_id = ?";
        
        List<PohybMaterialu> pohyby = jdbcTemplate.query(sql, new RowMapper<PohybMaterialu>() {
            @Override
            public PohybMaterialu mapRow(ResultSet rs, int i) throws SQLException {
               PohybMaterialu p = new PohybMaterialu();
               p.setId(rs.getLong("id"));
               p.setCena(rs.getDouble("cena"));
               p.setId_materialu(rs.getLong("id_materialu"));
               p.setVydajka_id(rs.getLong("vydajka_id"));
               p.setPocet(rs.getLong("pocet"));
               
               
               return p;
            }
        }, id);   
        return pohyby;
    }

    @Override
    public List<PohybMaterialu> getPohybyByMaterialId(long id) {
        
          String sql = "select * from pohybmaterialu where id_materialu = ?";
        
        List<PohybMaterialu> pohyby = jdbcTemplate.query(sql, new RowMapper<PohybMaterialu>() {
            @Override
            public PohybMaterialu mapRow(ResultSet rs, int i) throws SQLException {
               PohybMaterialu p = new PohybMaterialu();
               p.setId(rs.getLong("id"));
               p.setCena(rs.getDouble("cena"));
               p.setId_materialu(rs.getLong("id_materialu"));
               p.setVydajka_id(rs.getLong("vydajka_id"));
               p.setPocet(rs.getLong("pocet"));
               
               
               return p;
            }
        }, id);   
        return pohyby;
        
    }
    
}
