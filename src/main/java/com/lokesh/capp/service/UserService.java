/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lokesh.capp.service;

import com.lokesh.capp.domain.User;
import com.lokesh.capp.exception.UserBlockedException;
import java.util.List;

/**
 *
 * @author hp
 */
public interface UserService {
    public static final Integer LOGIN_STATUS_ACTIVE=1;
    public static final Integer LOGIN_STATUS_BLOCKED=2;
    
    public static final Integer ROLE_ADMIN=1;
    public static final Integer ROLE_USER=2;
    /**
     * This method handle user Registration.
     */
    public void register( User u);
    
    /**
     * this method handle login operation(authentication) using given Credentials
     * it returns user object if success  and null when failed.
     * when user account is blocked  an exception throws by this method.
     * @param loginName
     * @param password
     * @return 
     * @throws com.lokesh.capp.UserBlockedException when  user Account Blocked.
     */
    public User login(String loginName , String password )throws UserBlockedException;
    
    /**
     * this method returns the list of all registered users
     * @return 
     */
    public List<User> getUserList();
    
    /**
     * this method change the status for details passed as argument
     * @param userId
     * @param loginStatus
     * 
     */
    public void changeLoginStatus(Integer userId, Integer loginStatus);
    
    /**
     * this method will check weather a loginName is Exist Or Not 
     * And return boolean value
     * @param loginName
     * @return
     */
    public boolean isLoginNameExist(String loginName);
    
    
    public User findById(Integer userId);
    
}
