/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lokesh.capp.test;

import com.lokesh.capp.config.SpringRootConfig;
import com.lokesh.capp.dao.ContactDAO;
import com.lokesh.capp.dao.ContactDAOImpl;
import com.lokesh.capp.domain.Contact;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author hp
 */
public class TestContactDAOSave {
    
    public static void main(String ar[]){
    
    
    ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
    
    ContactDAO contactDAO= ctx.getBean(ContactDAOImpl.class);
    
    Contact c=new Contact();
    c.setUserId(1);
    c.setName("Lokesh");
    c.setPhone("9685741023");
    c.setEmail("lokeshsen@gmail.com");
    c.setAddress("bhopal");
    c.setRemark("Student");
    contactDAO.save(c);
        System.out.println("------------CONTACT DATA SAVES SUCCESSFULLY----------------");
  
    }
    
}
