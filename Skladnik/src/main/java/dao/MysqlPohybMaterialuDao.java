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
         String sql = "insert into PohybMaterialu(id,id_materialu,pocet,cena,prijemka_id,vydajka_id) values(?,?,?,?,?,?)";
       jdbcTemplate.update(sql,null,pohybMaterialu.getId_materialu(),pohybMaterialu.getPocet(),pohybMaterialu.getCena(),pohybMaterialu.getPrijemka_id(),pohybMaterialu.getVydajka_id());
    }
     @Override
    public void pridajPohybMaterialuVydaj(PohybMaterialu pohybMaterialu) {
         String sql = "insert into PohybMaterialu(id,id_materialu,pocet,cena,prijemka_id,vydajka_id) values(?,?,?,?,?,?)";
       jdbcTemplate.update(sql,null,pohybMaterialu.getId_materialu(),pohybMaterialu.getPocet(),pohybMaterialu.getCena(),pohybMaterialu.getPrijemka_id(),pohybMaterialu.getVydajka_id());
    }

    @Override
    public PohybMaterialu dajPohybMaterialuById(Long id) {
       String sql = "select * from pohybmaterialu where id = ?";
        BeanPropertyRowMapper<PohybMaterialu> mapper = BeanPropertyRowMapper.newInstance(PohybMaterialu.class);
        return jdbcTemplate.queryForObject(sql, mapper, id);
    }

    @Override
    public void odstranPohybMaterialu(PohybMaterialu pohybMaterialu) {
       String sql = "delete from pohybmaterialu where id = ?";
        jdbcTemplate.update(sql,pohybMaterialu.getId());
    }

    @Override
    public List<PohybMaterialu> getAll() {
     String sql = "SELECT * FROM pohybmaterialu";
        List<PohybMaterialu> pohyb = jdbcTemplate.query(sql, new RowMapper<PohybMaterialu>() {
         @Override
         public PohybMaterialu mapRow(ResultSet rs, int i) throws SQLException {
           PohybMaterialu pm = new PohybMaterialu();
           pm.setId(rs.getLong("id"));
           pm.setCena(rs.getLong("cena"));
           pm.setId_materialu(rs.getLong("id_materialu"));
           pm.setPocet(rs.getDouble("pocet"));
           pm.setPrijemka_id(rs.getLong("prijemka_id"));
           pm.setVydajka_id(rs.getLong("vydajka_id"));
           return pm;
         }
     });
        return pohyb;
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
               p.setVydajka_id(rs.getLong("vydajka_id"));
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
               p.setVydajka_id(rs.getLong("prijemka_id"));
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
               p.setPrijemka_id(rs.getLong("prijemka_id"));
               p.setPocet(rs.getLong("pocet"));
               
               
               
               return p;
            }
        }, id);   
        return pohyby;
        
    }

    @Override
    public void zmazVsetko() {
       jdbcTemplate.update("truncate pohybmaterialu");
    }
    
    @Override
     public long getLastId() {
        if(getAll().size()==0){
        return 1;
        }
        System.out.println(getAll().toString());
       String sql = "select max(id) from pohybmaterialu";   
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    @Override
    public List<PohybMaterialu> getAllPohybyByMaterialIdPrijemky(long id) {
          String sql = "select * from pohybmaterialu where id_materialu = ? and not prijemka_id = 0";
        
        List<PohybMaterialu> pohyby = jdbcTemplate.query(sql, new RowMapper<PohybMaterialu>() {
            @Override
            public PohybMaterialu mapRow(ResultSet rs, int i) throws SQLException {
               PohybMaterialu p = new PohybMaterialu();
               p.setId(rs.getLong("id"));
               p.setCena(rs.getDouble("cena"));
               p.setId_materialu(rs.getLong("id_materialu"));
               p.setVydajka_id(rs.getLong("vydajka_id"));
               p.setPrijemka_id(rs.getLong("prijemka_id"));
               p.setPocet(rs.getLong("pocet"));
               
               
               
               return p;
            }
        }, id);   
        return pohyby;
    }

    @Override
    public List<PohybMaterialu> getAllPohybyByMaterialIdVydajky(long id) {
        String sql = "select * from pohybmaterialu where id_materialu = ? and not vydajka_id = 0";
        
        List<PohybMaterialu> pohyby = jdbcTemplate.query(sql, new RowMapper<PohybMaterialu>() {
            @Override
            public PohybMaterialu mapRow(ResultSet rs, int i) throws SQLException {
               PohybMaterialu p = new PohybMaterialu();
               p.setId(rs.getLong("id"));
               p.setCena(rs.getDouble("cena"));
               p.setId_materialu(rs.getLong("id_materialu"));
               p.setVydajka_id(rs.getLong("vydajka_id"));
               p.setPrijemka_id(rs.getLong("prijemka_id"));
               p.setPocet(rs.getLong("pocet"));
               
               
               
               return p;
            }
        }, id);   
        return pohyby;
    }

    @Override
    public void odstranPohybMaterialuByPrijemkaId(long id) {
       String sql = "delete from pohybmaterialu where prijemka_id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void odstranPohybMaterialuByVydajkaId(long id) {
        String sql = "delete from pohybmaterialu where vydajka_id = ?";
        jdbcTemplate.update(sql,id);
    }
    
}
