package com.example.demo.controller;

import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Good;
import com.example.demo.entity.Refund;
import com.example.demo.entity.Stock;
import com.example.demo.result.Result;
import com.example.demo.service.GoodService;
import com.example.demo.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Author 顾倾歌
 * @Date 2021/10/11 15:02
 * @Version 1.0
 */
@RestController
public class RefundController {

    @Autowired
    private RefundService refundService;

    @Autowired
    private GoodService goodService;

    /**
     * @Description: 退货查询

     * @Date: 2021/10/11 15:04

     * @Author 顾倾歌

     * @since JDK 1.8

     */

    /**
     * 分页查询
     * @param queryDTO
     * @return
     */

    @PostMapping("api/refund/list")
    public Result refundList(@RequestBody QueryDTO queryDTO){
        Refund refund = new Refund();
        Good good = goodService.getById(refund.getCommid());
        if (null != good) {
            refund.setCommname(good.getCommname());
        }
        return new Result(200,"",refundService.selectRefundPage(queryDTO));
    }

    /**
     * 添加退货
     */
    @PostMapping("api/refund/addrefund")
    public Result addRefund(@RequestBody Refund refund){

        Good good = goodService.getById(refund.getCommid());
        Integer count = good.getInventory();
        System.out.println(count);
        if (count < refund.getRfnumber()){
            System.out.println(count);
            return new Result(201,"库存不足,库存为："+ count,null);
        } else {
            good.setInventory(count-refund.getRfnumber());
            refundService.addRefund(refund);
            goodService.updateGood(good);
            return new Result(200,"",refund);
        }

    }
}
