/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lokesh.capp.controller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author hp
 */
@Controller
public class TestController {
    
    @RequestMapping("/test/hello")
    public String hello()
    {
       return "hello"; 
    }
    
    @RequestMapping("/test/ajax_test")
    public String testJQuery()
    {
       return "test_jquery"; 
    }
    
     @RequestMapping("/test/get_time")
     @ResponseBody
    public String getServerTime()
    {
      Date d=new Date();
        System.out.println("==========get time======");
      return d.toString();
    }
}
