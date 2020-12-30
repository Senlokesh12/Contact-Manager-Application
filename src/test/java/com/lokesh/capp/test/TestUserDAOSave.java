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
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author hp
 */
public class TestUserDAOSave {

    public static void main(String ar[]) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAOImpl.class);
        User u = new User();
        u.setName("Deepak");
        u.setPhone("5874961253");
        u.setEmail("deepak@gmail.com");
        u.setAddress("bhopal MP");
        u.setLoginName("dk");
        u.setPassword("dk123");
        u.setRole(2);//Admin
        u.setLoginStatus(1);//Active

        userDAO.save(u);
        System.out.println("------Data Saved--------");

    }

}
