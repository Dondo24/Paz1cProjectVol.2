/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ics.upjs.sk.paz1c.skladnik.entity.Material;
import ics.upjs.sk.paz1c.skladnik.entity.Pouzivatel;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Daniel
 */
public class MysqlMaterialDao implements MaterialDao{
    private JdbcTemplate jdbcTemplate;
    
   public MysqlMaterialDao(JdbcTemplate jdbcTemplate){
       this.jdbcTemplate = jdbcTemplate;
   }
   
   public void pridajMaterial(Material material){
       jdbcTemplate.update("INSERT INTO Material (id,nazov,stav,cena,sklad_id) VALUES(?,?,?,?,?)",
               null,material.getNazov(),material.getStav(),material.getCena(),material.getId_sklad());
   }
   public Material dajMaterialById (long id){
       String sql = "SELECT * FROM Material where id=?";
        BeanPropertyRowMapper<Material> mapper = BeanPropertyRowMapper.newInstance(Material.class);
        return jdbcTemplate.queryForObject(sql, mapper, id);
       
     
   }
   public void odstranMaterial(Material material){
       jdbcTemplate.update("DELETE FROM material where id = ?");
       material.getId();
   }

    @Override
    public List<Material> getAll() {
        String sql = "SELECT * FROM MAterial";
        BeanPropertyRowMapper<Material> mapper = BeanPropertyRowMapper.newInstance(Material.class);
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<String> dajNazovVsetkychMaterialov() {
      String sql = "Select nazov from material ";
      BeanPropertyRowMapper<Material> mapper = BeanPropertyRowMapper.newInstance(Material.class);
         List<String> nazvyMaterialov = (List<String>) jdbcTemplate.queryForList(sql,String.class);
        return nazvyMaterialov;
    }

    @Override
    public void upravStavMaterial(long idMaterialu, long pocet,long typPohybu) {
        long upravaMaterialu = 0;
       
        
        if(typPohybu == 1){
        upravaMaterialu = dajMaterialById(idMaterialu).getStav() + pocet;
          
        }
         if(typPohybu == 2){
        upravaMaterialu = dajMaterialById(idMaterialu).getStav() - pocet;
        }
        String sql = "update material set stav = ? where id = ?";
        jdbcTemplate.update(sql,upravaMaterialu,idMaterialu);
    }

    @Override
    public void upravCenuMaterialu(long idMaterialu, double cena) {
       String sql = "update material set cena = ? where id = ?";
        jdbcTemplate.update(sql,cena,idMaterialu);
    }
   

  
}
