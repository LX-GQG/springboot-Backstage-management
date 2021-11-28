package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Good;
import org.springframework.stereotype.Service;

import java.util.List;

/**

 * Description:  商品

 * date: 2021/9/30 23:26

 * @author: 顾倾歌

 * @since JDK 1.8

 */
@Service
public interface CustomerService extends IService<Customer> {

    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
    IPage<Customer> selectCustomerPage(QueryDTO queryDTO);

    /**
     * 添加客户
     * @param customer
     * @return
     */
    Integer addCustomer(Customer customer);

    /**
     * 更新
     * @param customer
     * @return
     */
    Integer updateCustomer(Customer customer);

    /**
     * 删除
     * @param custid
     * @return
     */
    Integer deleteCustomer(Integer custid);

    /**
     * 批量删除
     * @param custids
     * @return
     */
    void batchDelete(List<Integer> custids);
}