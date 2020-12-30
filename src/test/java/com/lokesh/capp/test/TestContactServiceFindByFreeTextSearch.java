/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lokesh.capp.test;

import com.lokesh.capp.config.SpringRootConfig;
import com.lokesh.capp.domain.Contact;
import com.lokesh.capp.service.ContactService;
import com.lokesh.capp.service.ContactServiceImpl;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author hp
 */
public class TestContactServiceFindByFreeTextSearch {

    public static void main(String ar[]) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        ContactService cs = ctx.getBean(ContactServiceImpl.class);
                
        List<Contact> res = cs.findUserContact(1);
        for (Contact c1 : res) {
            System.out.println(c1.getName());
        }

        List<Contact> c = cs.findUserContact(1, "Lokesh");

        for (Contact c1 : c) {
            System.out.println(c1.getName() + "\n  " + c1.getPhone() + " \n" + c1.getEmail());
        }

    }

}
