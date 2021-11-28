package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Good;
import com.example.demo.result.DataGridViewResult;
import com.example.demo.result.Result;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**

 * Description: 客户

 * date: 2021/9/30 23:46

 * @author: 顾倾歌

 * @since JDK 1.8

 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 分页查询
     * @param queryDTO
     * @return
     */

    @PostMapping("api/cust/list")
    public Result customerList(@RequestBody QueryDTO queryDTO){
        return new Result(200,"",customerService.selectCustomerPage(queryDTO));
    }

    /**
     * 添加
     * @param customer
     * @return
     */
    @PostMapping("api/cust/add")
    public Result addCustomer(@RequestBody Customer customer){
        return new Result(200,"",customerService.addCustomer(customer));
    }

    /**
     * 更新/修改
     * @param customer
     * @return
     */
    @PostMapping("api/cust/update")
    public Result updateCustomer(@RequestBody Customer customer){
        System.out.println(customer);
        return new Result(200,"",customerService.updateCustomer(customer));
    }

    /**
     * 删除
     * @param custid
     * @return
     */
    @PostMapping("api/cust/delete")
    public Result deleteCustomer(Integer custid){
        return new Result(200,"",customerService.deleteCustomer(custid));
    }

    /**
     * 批量删除
     * @param custids
     * @return
     */
    @PostMapping("api/cust/delete/batch")
    public Result batchDeleteCustomer(@RequestBody List<Integer> custids){
        customerService.batchDelete(custids);
        return new Result(200,"","");
    }

    /**
     * 加载下拉框
     *
     * @return
     */
    @RequestMapping("api/cust/AllCust")
    public DataGridViewResult loadAllCust() {
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        List<Customer> list = customerService.list(queryWrapper);
        return new DataGridViewResult(list);

    }

    /**
     * 根据客户id加载客户名称
     * @param
     * @return
     */
    @PostMapping("api/cust/loadCustById")
    public DataGridViewResult loadCustById(Integer custid) {
        QueryWrapper<Customer> goodsQueryWrapper = new QueryWrapper<>();
        goodsQueryWrapper.eq(custid != 0, "custid", custid);
        Customer customer = customerService.getById(custid);
        return new DataGridViewResult(customer);

    }
}
