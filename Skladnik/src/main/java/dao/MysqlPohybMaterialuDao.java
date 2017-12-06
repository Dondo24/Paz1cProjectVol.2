/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ics.upjs.sk.paz1c.skladnik.entity.PohybMaterialu;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

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
    public void pridajPohybMaterialu(PohybMaterialu pohybMaterialu) {
         String sql = "insert into PohybMaterialu values(?,?,?,?,?,?,?)";
       jdbcTemplate.update(sql,null,pohybMaterialu.getTypPohybu(),pohybMaterialu.getId_materialu(),pohybMaterialu.getPocet(),pohybMaterialu.getCena(),pohybMaterialu.getPrijemka_id(),null);
    }

    @Override
    public PohybMaterialu dajPohybMaterialuById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void odstranPrijemku(PohybMaterialu pohybMaterialu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PohybMaterialu> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
