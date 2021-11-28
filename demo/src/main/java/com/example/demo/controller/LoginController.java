package com.example.demo.controller;

import com.example.demo.dto.LoginDTO;
import com.example.demo.entity.User;
import com.example.demo.result.Result;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 顾倾歌
 * @Date: 2021/7/16
 * @Description: TODO
 **/

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping(value = "api/login")
    @CrossOrigin        //后端跨域
    public Result login(@RequestBody LoginDTO loginDTO){
        return loginService.login(loginDTO);
    }

    @PostMapping(value = "api/register")
    @CrossOrigin        //后端跨域
    public Result register(@RequestBody User user){
        return new Result(200,"",loginService.register(user));
    }
}
