package com.example.demo.controller;

import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.LogincustDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.User;
import com.example.demo.result.Result;
import com.example.demo.service.LogincustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 顾倾歌
 * @Date 2021/10/14 15:24
 * @Version 1.0
 */
@RestController
public class LogincustController {

    @Autowired
    LogincustService logincustService;

    @PostMapping(value = "api/cust/login")
    @CrossOrigin        //后端跨域
    public Result custlogin(@RequestBody LogincustDTO logincustDTO){
        return logincustService.logincsut(logincustDTO);
    }

    @PostMapping(value = "api/cust/register")
    @CrossOrigin        //后端跨域
    public Result register(@RequestBody Customer cust){
        return new Result(200,"",logincustService.register(cust));
    }
}
