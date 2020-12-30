/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lokesh.capp.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;

/**
 *
 * @author hp
 */
@Configuration
@ComponentScan(basePackages = {"com.lokesh.capp.dao","com.lokesh.capp.service"})
public class SpringRootConfig {
    //TODO: services, DAO , DataSources , EmailSender or some other business layer bean
    @Bean
    public BasicDataSource getDataSource()
    {
        BasicDataSource ds=new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/capp_db");
        ds.setUsername("root");
        ds.setPassword("rootwdp");
        ds.setMaxTotal(2);
        ds.setInitialSize(1);
        ds.setDefaultAutoCommit(true);
        ds.setValidationQuery("SELECT 1");
        ds.setTestOnBorrow(true);
        
        return ds;
    }
    
    
    
}
