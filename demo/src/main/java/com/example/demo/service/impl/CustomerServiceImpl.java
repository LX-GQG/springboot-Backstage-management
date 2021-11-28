package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Customer;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 顾倾歌

 * @Date 2021/9/30 23:29

 * @Version 1.0

 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 分页查询
     **/

    @Override
    public IPage<Customer> selectCustomerPage(QueryDTO queryDTO) {
        Page<Customer> page = new Page<>(queryDTO.getPageNo(),queryDTO.getPageSize());
        return customerMapper.selectCustomerPage(page,queryDTO.getKeyword());
    }

    @Override
    public Integer addCustomer(Customer customer) {
        return customerMapper.insert(customer);
    }

    @Override
    public Integer updateCustomer(Customer customer) {
        return customerMapper.updateById(customer);
    }

    @Override
    public Integer deleteCustomer(Integer custid) {
        return customerMapper.deleteById(custid);
    }

    @Override
    public void batchDelete(List<Integer> custids) {
        customerMapper.deleteBatchIds(custids);
    }
}
