/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lokesh.capp.test;

import com.lokesh.capp.config.SpringRootConfig;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author hp
 */
public class TestDataSource {
    
        public static void main(String ar[]){
            
            ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
            DataSource ds= ctx.getBean(DataSource.class);
            JdbcTemplate jt=new JdbcTemplate(ds);
            String sql="INSERT INTO user(name,phone ,email,address,loginName,password) values(?,?,?,?,?,?)";
            Object[] params=new Object[]{"LOKESH","7610487589","lokeshsen@gmail.com","bhopal","l","l123"};
            jt.update(sql, params);
            System.out.println("--------Query Excecuted-----------");
                    
            
        }
                
}
