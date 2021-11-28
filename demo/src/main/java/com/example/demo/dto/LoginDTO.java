package com.example.demo.dto;

/**
 * @Author: 顾倾歌
 * @Date: 2021/7/16
 **/

public class LoginDTO {
    private String loginName;
    private String password;
    private String email;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
