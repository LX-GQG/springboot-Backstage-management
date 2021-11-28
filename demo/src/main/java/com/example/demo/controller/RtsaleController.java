package com.example.demo.controller;

import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Good;

import com.example.demo.entity.Rtsale;
import com.example.demo.entity.Sale;
import com.example.demo.result.Result;
import com.example.demo.service.GoodService;

import com.example.demo.service.RtsaleService;
import com.example.demo.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 顾倾歌
 * @Date 2021/10/12 22:25
 * @Version 1.0
 */
@RestController
public class RtsaleController {

    @Autowired
    private RtsaleService rtsaleService;

    @Autowired
    private SaleService saleService;

    @Autowired
    private GoodService goodService;

    /**
     * @Description: 销售退货查询

     * @Date: 2021/10/12 22:26

     * @Author 顾倾歌

     * @since JDK 1.8

     */

    /**
     * 分页查询
     * @param queryDTO
     * @return
     */

    @PostMapping("api/rtsale/list")
    public Result rtsaleList(@RequestBody QueryDTO queryDTO){
        Rtsale rtsale = new Rtsale();
        Good good = goodService.getById(rtsale.getCommid());
        if (null != good) {
            rtsale.setCommname(good.getCommname());
        }
        return new Result(200,"",rtsaleService.selectRtsalePage(queryDTO));
    }

    /**
     * 添加销售退货
     */
    @PostMapping("api/rtsale/addrtsale")
    public Result addRtsale(@RequestBody Rtsale rtsale){
        Sale sale = new Sale();
        Good good = goodService.getById(rtsale.getCommid());
        Integer count = good.getInventory();
        if (count<rtsale.getRtsnumber()){
            System.out.println(count);
            return new Result(201,"库存不足,库存为："+ count,null);
        } else {
            rtsaleService.addRtsale(rtsale);
            good.setInventory(count+rtsale.getRtsnumber());
            goodService.updateGood(good);
            return new Result(200,"",rtsale);
        }

    }
}
