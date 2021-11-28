package com.example.demo.vo;

/**
 * @Author 顾倾歌
 * @Date 2021/10/14 15:12
 * @Version 1.0
 */

import com.example.demo.entity.Customer;
import com.example.demo.entity.User;

import java.io.Serializable;

public class LogincustVO implements Serializable {
    private Integer id;
    private String token;
    private Customer cust;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }
}
