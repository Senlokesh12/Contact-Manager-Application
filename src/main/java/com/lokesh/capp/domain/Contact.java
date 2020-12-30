/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lokesh.capp.domain;

/**
 *
 * @author hp
 */
public class Contact {
    
    private Integer userId;
    private Integer contactId;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String remark;
    
    public Contact() {
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getContactId() {
        return contactId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getRemark() {
        return remark;
    }

   
    
}
