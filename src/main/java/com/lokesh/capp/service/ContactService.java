/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lokesh.capp.service;

import com.lokesh.capp.domain.Contact;
import java.util.List;

/**
 *
 * @author hp
 */
public interface ContactService {
    
    public void save(Contact c);
    public void update(Contact c);
    public void delete(Integer contactId);
    public void delete(Integer[] contactIds);
    public Contact findById(Integer contactId);
  
    
    /**
     * this method will return all contact list (who is currently logged in)
     * @param userId
     * 
     * @return 
     */
    public List<Contact> findUserContact(Integer userId);
    
    /**
     * this method will search all user contact by (userId) and given free text criteria
     * 
     * @param userId (for currently logged user only)
     * @param txt (this may be contain other searching free text criteria like by name , by phone , by email,by address as well as remark also.)
     * @return 
     */
    public List<Contact> findUserContact(Integer userId,String txt );
    
    
    
    
    
}
