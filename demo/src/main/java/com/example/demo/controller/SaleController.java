package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Good;
import com.example.demo.entity.Sale;
import com.example.demo.result.DataGridViewResult;
import com.example.demo.result.Result;
import com.example.demo.service.CustomerService;
import com.example.demo.service.GoodService;
import com.example.demo.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author 顾倾歌
 * @Date 2021/10/11 23:39
 * @Version 1.0
 */
@RestController
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private GoodService goodService;

    @Autowired
    private CustomerService customerService;

    /**
     * @Description: 销售查询

     * @Date: 2021/10/11 23:40

     * @Author 顾倾歌

     * @since JDK 1.8

     */

    /**
     * 分页查询
     * @param queryDTO
     * @return
     */

    @PostMapping("api/sale/list")
    public Result saleList(@RequestBody QueryDTO queryDTO){
        Sale sale = new Sale();
        Good good = goodService.getById(sale.getCommid());
        if (null != good) {
            sale.setCommname(good.getCommname());
        }
        return new Result(200,"",saleService.selectSalesPage(queryDTO));
    }

    /**
     * 根据时间段查询销售情况
     */
    @PostMapping("api/sale/getmonth")
    public Result findMonth(@RequestBody QueryDTO queryDTO){
        return new Result(200,"",saleService.selectMonth(queryDTO));
    }

    /**
     * 添加
     * @param sale
     * @return
     */
    @PostMapping("api/sale/addsale")
    public Result addSale(@RequestBody Sale sale){
        sale.setSaletime(new Date());
        sale.setAllmoney(sale.getSalemount()*sale.getSalemoney());
        Good good = goodService.getById(sale.getCommid());
        Integer count = good.getInventory();
        if (count<sale.getSalemount()){
            System.out.println(count);
            return new Result(201,"库存不足,库存为："+ count,null);
        }
        good.setInventory(count-sale.getSalemount());
        System.out.println(good.getInventory());
        goodService.updateGood(good);
        return new Result(200,"",saleService.addSale(sale));
    }

    /**
     * 更新/修改
     * @param sale
     * @return
     */
    @PostMapping("api/sale/updatesale")
    public Result updateSale(@RequestBody Sale sale){
        return new Result(200,"",saleService.updateSale(sale));
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping("api/sale/deletesale")
    public Result deleteSale(Integer id){
        return new Result(200,"",saleService.deleteSale(id));
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("api/sale/delete/batch")
    public Result batchDeleteSale(@RequestBody List<Integer> ids){
        saleService.batchDelete(ids);
        return new Result(200,"","");
    }
}
