/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import com.mysql.cj.jdbc.MysqlDataSource;
import dao.MaterialDao;
import dao.MysqlMaterialDao;
import dao.MysqlPohybMaterialuDao;
import dao.MysqlPouzivatelDao;
import dao.MysqlPrijemkaDao;
import dao.MysqlSkladDao;
import dao.MysqlVydajkaDao;
import dao.PohybMaterialuDao;
import dao.PouzivatelDao;
import dao.PrijemkaDao;
import dao.SkladDao;
import dao.VydajkaDao;
import java.sql.Connection;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Daniel
 */
public enum ObjectFactory {
    INSTANCE;
    
    private JdbcTemplate jdbcTemplate;
    private JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost/skladnik?serverTimezone=UTC");
            dataSource.setUser("skladnik");
            dataSource.setPassword("sklad");           
            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        return jdbcTemplate;
    }
    
       
    
    public MaterialDao getMaterialDao(){
    return new MysqlMaterialDao(getJdbcTemplate());
    }
    
     public PouzivatelDao getPouzivatelDao(){
    return new MysqlPouzivatelDao(getJdbcTemplate());
    }
        public SkladDao getSkladDao(){
    return new MysqlSkladDao(getJdbcTemplate());
    }
   
      public PrijemkaDao getPrijemkadDao(){
    return new MysqlPrijemkaDao(getJdbcTemplate());
    }
        public VydajkaDao getVydajkaDao(){
    return new MysqlVydajkaDao(getJdbcTemplate());
    }
        
        public PohybMaterialuDao getPohybMaterialuDao(){
        return new MysqlPohybMaterialuDao(getJdbcTemplate());
        }
        
}
