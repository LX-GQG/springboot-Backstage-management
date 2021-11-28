package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Good;
import com.example.demo.entity.Provider;
import com.example.demo.entity.Stock;
import com.example.demo.result.DataGridViewResult;
import com.example.demo.result.Result;
import com.example.demo.result.TResult;
import com.example.demo.service.GoodService;
import com.example.demo.service.ProviderService;
import com.example.demo.service.StockService;
import com.example.demo.vo.Stockvo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @Author 顾倾歌
 * @Date 2021/10/7 13:31
 * @Version 1.0
 */
@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private GoodService goodService;

    /**
     * @Description: 进货查询

     * @Date: 2021/10/7 13:35

     * @Author 顾倾歌

     * @since JDK 1.8

     */

    /**
     * 分页查询
     * @param queryDTO
     * @return
     */

    @PostMapping("api/stock/list")
    public Result stockList(@RequestBody QueryDTO queryDTO){
        Stock stock = new Stock();
        Good good = goodService.getById(stock.getCommid());
        if (null != good) {
            stock.setCommname(good.getCommname());
        }
        return new Result(200,"",stockService.selectStockPage(queryDTO));
    }

    /**
     * 添加
     * @param stock
     * @return
     */
    @PostMapping("api/stock/addstock")
    public Result addStock(@RequestBody Stock stock){
        stock.setSkdate(new Date());
        stock.setTotalprice(stock.getSknumber()*stock.getSkmoney());
        Good good = goodService.getById(stock.getCommid());
        good.setInventory(stock.getSknumber()+good.getInventory());
        goodService.updateGood(good);
        return new Result(200,"",stockService.addStock(stock));
    }

    /**
     * 更新/修改
     * @param stock
     * @return
     */
    @PostMapping("api/stock/updatestock")
    public Result updateStock(@RequestBody Stock stock){
        return new Result(200,"",stockService.updateStock(stock));
    }

    /**
     * 删除
     * @param skid
     * @return
     */
    @PostMapping("api/stock/deletestock")
    public Result deleteStock(Integer skid){
        return new Result(200,"",stockService.deleteStock(skid));
    }

    /**
     * 批量删除
     * @param skids
     * @return
     */
    @PostMapping("api/stock/delete/batch")
    public Result batchDeleteStock(@RequestBody List<Integer> skids){
        stockService.batchDelete(skids);
        return new Result(200,"","");
    }
}
