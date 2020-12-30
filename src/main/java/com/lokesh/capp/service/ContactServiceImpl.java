/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lokesh.capp.service;

import com.lokesh.capp.dao.BaseDAO;
import com.lokesh.capp.dao.ContactDAO;
import com.lokesh.capp.domain.Contact;
import com.lokesh.capp.rm.ContactRowMapper;
import com.lokesh.capp.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class ContactServiceImpl extends BaseDAO implements ContactService {

    @Autowired
    ContactDAO contactDAO;

    @Override
    public void save(Contact c) {
        contactDAO.save(c);
    }

    @Override
    public void update(Contact c) {
        contactDAO.update(c);
    }

    @Override
    public void delete(Integer contactId) {
        contactDAO.delete(contactId);

    }

    @Override
    public void delete(Integer[] contactIds) {
        String ids = StringUtil.toCommaSeparatedString(contactIds);
        String sql = " DELETE FROM contact WHERE contactId IN('"+ids+"')";
        System.out.println(sql);
        getJdbcTemplate().update(sql);  
    }

    @Override
    public List<Contact> findUserContact(Integer userId) {
        return contactDAO.findByProperty("userId", userId);

    }

    @Override
    public List<Contact> findUserContact(Integer userId, String txt) {
        String sql = "SELECT  contactId, userId, name, phone,email,address,remark FROM contact WHERE userId=? "
                      + " AND (name LIKE '%" + txt + "%' OR phone LIKE '%" + txt + "%' OR email LIKE '%" 
                      + txt + "%' OR address LIKE '%" + txt + "%' OR  remark LIKE '%" + txt + "%') ";
       List<Contact> c= getJdbcTemplate().query(sql, new ContactRowMapper(),userId);
        return c;

    }

    @Override
    public Contact findById(Integer contactId) {
      return contactDAO.findById(contactId);
    }

    

   

}
