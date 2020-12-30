/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lokesh.capp.test;

import com.lokesh.capp.config.SpringRootConfig;
import com.lokesh.capp.domain.User;
import com.lokesh.capp.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author hp
 */
public class TestUserServiceRegister {

    public static void main(String ar[]) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserService userService=ctx.getBean(UserService.class);
        User u = new User();
        u.setName("RANI");
        u.setPhone("9795698546");
        u.setEmail("RANI@gmail.com");
        u.setAddress("Begumaganj MP");
        u.setLoginName("rani");
        u.setPassword("rani123");
        u.setRole(UserService.ROLE_USER);//Admin
        u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);//Active

        userService.register(u);
        System.out.println("------User Registered Successfilly--------");

    }

}
