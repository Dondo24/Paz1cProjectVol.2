/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ics.upjs.sk.paz1c.skladnik.entity.Material;
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
       jdbcTemplate.update("INSERT INTO Material (nazov,stav,cena,sklad_id) VALUES(?,?,?,?)",
               material.getNazov(),material.getStav(),material.getCena(),material.getId_sklad());
   }
   public Material dajMaterialById (Long id){
       String sql = "SELECT id , nazov FROM Material where id=?";
     
   }
   public void odstranMaterial(Material material){
       jdbcTemplate.update("DELETE FROM material where id = ?");
       material.getId();
   }

  
}
