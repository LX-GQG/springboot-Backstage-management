package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Customer;
import org.springframework.stereotype.Repository;

/**

 * Description:

 * date: 2021/9/30 23:36

 * @author: 顾倾歌

 * @since JDK 1.8

 */
public interface CustomerMapper extends BaseMapper<Customer> {
    IPage<Customer> selectCustomerPage(Page<Customer> page, String keyword);
}
