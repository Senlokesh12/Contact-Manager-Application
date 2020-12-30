package com.lokesh.capp.command;


/**
 *
 * @author hp
 */
public class LoginCommand {
    
    private String loginName;
    private String password;

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }
    
}
