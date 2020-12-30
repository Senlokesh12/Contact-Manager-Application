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
public class TestUserDaoUpdate {

    public static void main(String ar[]) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAOImpl.class);
        User u = new User();
        u.setName("Deepak kurmi");
        u.setPhone("5874961253");
        u.setEmail("deepakurmi@gmail.com");
        u.setAddress("bhopal Madhya pradesh");
        u.setRole(2);//Admin
        u.setLoginStatus(2);//Active
        u.setUserId(6);
        userDAO.update(u);
        System.out.println("------DATA UPDATED-------");

    }

}
