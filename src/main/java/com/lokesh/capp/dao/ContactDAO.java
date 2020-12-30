
package com.lokesh.capp.dao;

import com.lokesh.capp.domain.Contact;

import java.util.List;

/**
 *
 * @author hp
 */

public interface ContactDAO  {
    
    
    public void save(Contact c);
    
    public void update(Contact c);
    
    public void delete(Integer contactId);
    
    public void delete(Contact c);
    
    public Contact findById(Integer contactId);
    
    public List<Contact> findAll();
    
    public List<Contact> findByProperty(String propName, Object propValue);
    
}
