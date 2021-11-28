package com.example.demo.controller;

import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.User;
import com.example.demo.result.Result;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 顾倾歌
 * @Date: 2021/7/16
 * @Description: 用户管理
 **/

@RestController
public class UserController {

    @Autowired
    private UserService service;

    /**
     * 分页查询
     * @param queryDTO
     * @return
     */

    @PostMapping("api/user/list")
    public Result userList(@RequestBody QueryDTO queryDTO){
        return new Result(200,"",service.selectUserPage(queryDTO));
    }

    /**
     * 添加
     * @param user
     * @return
     */
    @PostMapping("api/user/add")
    public Result addUser(@RequestBody User user){
        return new Result(200,"",service.addUser(user));
    }

    /**
     * 更新/修改
     * @param user
     * @return
     */
    @PostMapping("api/user/update")
    public Result updateUser(@RequestBody User user){
        return new Result(200,"",service.updateUser(user));
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping("api/user/delete")
    public Result deleteUser(Integer id){
        return new Result(200,"",service.deleteUser(id));
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("api/user/delete/batch")
    public Result batchDeleteUser(@RequestBody List<Integer> ids){
        service.batchDelete(ids);
        return new Result(200,"","");
    }
}
