package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.dto.LogincustDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.User;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.result.Result;
import com.example.demo.service.LogincustService;
import com.example.demo.vo.LoginVO;
import com.example.demo.vo.LogincustVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sun.dc.pr.PRError;

import java.util.UUID;

/**
 * @Author 顾倾歌
 * @Date 2021/10/14 15:19
 * @Version 1.0
 */
@Service
public class LogincustServiceImpl implements LogincustService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Result logincsut(LogincustDTO logincustDTO) {
        if (StringUtils.isEmpty(logincustDTO.getCustlogin())){
            return new Result(400,"账号不能为空","");
        }
        if (StringUtils.isEmpty(logincustDTO.getCustpass())){
            return new Result(400,"密码不能为空","");
        }
        //通过登录名查询用户
        QueryWrapper<Customer> wrapper = new QueryWrapper();
        wrapper.eq("custlogin",logincustDTO.getCustlogin());
        Customer customer = customerMapper.selectOne(wrapper);
        //对比密码
        if (customer!=null&&customer.getCustpass().equals(logincustDTO.getCustpass())){
            LogincustVO logincustVO=new LogincustVO();
            logincustVO.setId(customer.getCustid());
            //这里token直接用一个uuid
            //使用jwt的情况下，会生成一个jwt token,jwt token里会包含用户的信息
            logincustVO.setToken(UUID.randomUUID().toString());
            logincustVO.setCust(customer);
            return new Result(200,"登录成功",logincustVO);
        }
        return new Result(400,"登录失败","");
    }

    @Override
    public Integer register(Customer cust) {
        return customerMapper.insert(cust);
    }
}
