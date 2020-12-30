/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lokesh.capp.test;

import com.lokesh.capp.config.SpringRootConfig;
import com.lokesh.capp.dao.UserDAO;
import com.lokesh.capp.dao.UserDAOImpl;
import com.lokesh.capp.domain.User;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author hp
 */
public class TestUserDaoFindSingleRecord {

    public static void main(String ar[]) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAOImpl.class);
        System.out.println("---------------findByProperty Result -----------"); 
         List<User> users2=userDAO.findByProperty("role", 1);
        
        for(User u: users2)
        {
            System.out.println(u.getUserId()+"   "+u.getName());
        }
        
        System.out.println("--------find All Results-----------");
        List<User> users=userDAO.findAll();
        
        for(User u: users)
        {
            System.out.println(u.getUserId()+"   "+u.getName());
        }
        
        
        
        
        User u= userDAO.findById(6);
        System.out.println("------User Details :--------");
        System.out.println(u.getUserId());
        System.out.println(u.getName());
        System.out.println(u.getPhone());
        System.out.println(u.getEmail());
        System.out.println(u.getAddress());
        System.out.println(u.getLoginName());
        System.out.println(u.getRole());
        System.out.println(u.getLoginStatus());
        
        
       
       

    }

}
