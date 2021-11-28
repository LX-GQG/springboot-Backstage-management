package com.example.demo.service;

import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.LogincustDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.User;
import com.example.demo.result.Result;

/**
 * @Author 顾倾歌
 * @Date 2021/10/14 15:14
 * @Version 1.0
 */
public interface LogincustService {

    public Result logincsut(LogincustDTO logincustDTO);

    public Integer register(Customer cust);
}
