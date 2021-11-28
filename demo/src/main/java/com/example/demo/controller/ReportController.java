package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.*;
import com.example.demo.result.DataGridViewResult;
import com.example.demo.service.*;
import com.example.demo.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author 顾倾歌
 * @Date 2021/10/18 14:12
 * @Version 1.0
 */
@RestController
public class ReportController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private RtsaleService rtsaleService;

    @Resource
    private StockService stockService;

    @Resource
    private RefundService refundService;

    @Autowired
    private GoodService goodService;

    @Autowired
    private CustomerService customerService;

    @PostMapping("api/report/salereport")
    public DataGridViewResult statisticsSales(){
        QueryWrapper<Sale> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .select("commid","sum(salemount) total")
                .groupBy("commid")
                .orderByAsc("total")
                .last("limit 8");
        List<Sale> salesList = saleService.list(queryWrapper);
        Map<String, Object> map = new HashMap<>();
        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (Sale sale : salesList) {
            Good good = goodService.getById(sale.getCommid());
            if (null != good) {
                list1.add(good.getCommname());
                list2.add(sale.getTotal());
            }
        }
        map.put("data1",list1);
        map.put("data2",list2);
        return new DataGridViewResult(map);
    }

    /**
     * 盈利报表
     */

    @PostMapping("api/report/profit")
    public DataGridViewResult profitStatement(){
        Map<String, Object> map = new HashMap<>();
        //时间
        List<String> list1 = new ArrayList<>();
        //销售利润
        List<Integer> list2 = new ArrayList<>();
        //实际利润
        List<Integer> list3 = new ArrayList<>();
        //退货
        List<Integer> list4 = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            QueryWrapper<Sale> queryWrapper = new QueryWrapper<>();
            QueryWrapper<Rtsale> queryWrapper2 = new QueryWrapper<>();
            queryWrapper
                    .select("sum( salemoney ) AS moneys,DATE_FORMAT( saletime, '%Y-%m' ) AS counttime")
                    .between("saletime", DateUtils.stepMonth(i),DateUtils.getMonth(i))
                    .groupBy("counttime")
                    .orderByDesc("counttime");

            queryWrapper2
                    .select("sum( rtsmoney ) AS moneys,DATE_FORMAT( rtstime, '%Y-%m' ) AS counttime")
                    .between("rtstime",DateUtils.stepMonth(i),DateUtils.getMonth(i))
                    .groupBy("counttime")
                    .orderByDesc("counttime");

            Sale sales = saleService.getOne(queryWrapper);

            Rtsale rtsale = rtsaleService.getOne(queryWrapper2);

            if(null!= sales){
                list1.add(sales.getCounttime());
                list2.add(sales.getMoneys());
                if(rtsale!=null){
                    list3.add(sales.getMoneys()-rtsale.getMoneys());
                    list4.add(-rtsale.getMoneys());
                }else{
                    list3.add(sales.getMoneys());
                    list4.add(null);
                }
            }else {
                list1.add(new SimpleDateFormat("yyyy-MM").format(DateUtils.getMonth(i)));
                list2.add(null);
                if(rtsale!=null){
                    list3.add(-rtsale.getMoneys());
                    list4.add(-rtsale.getMoneys());
                }else{
                    list3.add(null);
                    list4.add(null);
                }
            }
        }

        map.put("data1",list1);
        map.put("data2",list2);
        map.put("data3",list3);
        map.put("data4",list4);
        return new DataGridViewResult(map);
    }



    @PostMapping("api/report/stock")
    public DataGridViewResult statisticsinGoods(){
        QueryWrapper<Stock> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .select("sum( sknumber ) as countnumbers,DATE_FORMAT( skdate, '%Y-%m' ) AS counttime")
                .between("skdate",DateUtils.stepMonth(5),new Date())
                .groupBy("counttime")
                .orderByAsc("counttime");
        List<Stock> stockList = stockService.list(queryWrapper);

        Map<String, Object> map = new HashMap<>();
        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (Stock stock : stockList) {
            list1.add(stock.getCounttime());
            list2.add(stock.getCountnumbers());
        }
        map.put("data1",list1);
        map.put("data2",list2);
        return new DataGridViewResult(map);
    }

    @PostMapping("api/report/refund")
    public DataGridViewResult statisticsoutGoods(){
        Map<String, Object> map = new HashMap<>();
        QueryWrapper<Refund> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1
                .select("sum( rfnumber ) as countnumbers,DATE_FORMAT( reftime, '%Y-%m' ) AS counttime")
                .between("reftime",DateUtils.stepMonth(5),new Date())
                .groupBy("counttime")
                .orderByAsc("counttime");
        List<Refund> refundList = refundService.list(queryWrapper1);

        List<String> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();

        for (Refund refund : refundList) {
            list3.add(refund.getCounttime());
            list4.add(refund.getCountnumbers());
        }
        map.put("data3",list3);
        map.put("data4",list4);
        return new DataGridViewResult(map);
    }
}
