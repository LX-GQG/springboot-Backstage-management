package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.User;

import java.util.List;

/**
 * @Author: 顾倾歌
 * @Date: 2021/7/16
 **/

public interface UserService {
    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
    IPage<User> selectUserPage(QueryDTO queryDTO);

    /**
     * 添加用户
     * @param user
     * @return
     */
    Integer addUser(User user);

    /**
     * 更新
     * @param user
     * @return
     */
    Integer updateUser(User user);

    /**
     * 删除
     * @param id
     * @return
     */
    Integer deleteUser(Integer id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    void batchDelete(List<Integer> ids);
}
