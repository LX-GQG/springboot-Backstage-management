package com.example.demo.service;

import com.example.demo.dto.LoginDTO;
import com.example.demo.entity.User;
import com.example.demo.result.Result;

/**
 * @Author: 顾倾歌
 * @Date: 2021/7/16
 **/

public interface LoginService {
    public Result login(LoginDTO loginDTO);

    public Integer register(User user);
}
