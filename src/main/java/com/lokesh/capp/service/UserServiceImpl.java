/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lokesh.capp.service;

import com.lokesh.capp.dao.BaseDAO;
import com.lokesh.capp.dao.UserDAO;
import com.lokesh.capp.domain.User;
import com.lokesh.capp.exception.UserBlockedException;
import com.lokesh.capp.rm.UserRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class UserServiceImpl extends BaseDAO implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public void register(User u) {
        userDAO.save(u);
    }

    @Override
    public User login(String loginName, String password) throws UserBlockedException {
        String sql = "SELECT userId ,name,phone,email,address,loginName,loginStatus,role FROM user "
                + " WHERE loginName=:ln AND password=:pw";
        Map m = new HashMap();
        m.put("ln", loginName);
        m.put("pw", password);
        try {
            User u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());

            if (u.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)) {
                throw new UserBlockedException("OOPs! Your Account has been Blocked.Contact to Admin.");
            }
            return u;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }

    @Override
    public List<User> getUserList() {
       return userDAO.findByProperty("role", UserService.ROLE_USER);
    }

    @Override
    public void changeLoginStatus(Integer userId, Integer loginStatus) {
    String sql=" UPDATE user SET loginStatus=:lstatus WHERE userId=:uid ";
    Map m=new HashMap();
    m.put("uid",userId);
    m.put("lstatus",loginStatus);
    getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public boolean isLoginNameExist(String loginName) {
     String sql="SELECT count(loginName) FROM user WHERE loginName=?";
       Integer count= getJdbcTemplate().queryForObject(sql, new String[]{loginName}, Integer.class);
       if(count==1)
           return true;
       else
           return false;
    }

    @Override
    public User findById(Integer userId) {
       return userDAO.findById(userId);
    }

}
