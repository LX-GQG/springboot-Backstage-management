package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Provider;
import com.example.demo.entity.Stock;

import java.util.List;

/**
 * @Author 顾倾歌
 * @Date 2021/10/7 0:30
 * @Version 1.0
 */
public interface StockService extends IService<Stock>{
    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
    IPage<Stock> selectStockPage(QueryDTO queryDTO);

    /**
     * 添加用户
     * @param stock
     * @return
     */
    Integer addStock(Stock stock);

    /**
     * 更新
     * @param stock
     * @return
     */
    Integer updateStock(Stock stock);

    /**
     * 删除
     * @param skid
     * @return
     */
    Integer deleteStock(Integer skid);

    /**
     * 批量删除
     * @param skids
     * @return
     */
    void batchDelete(List<Integer> skids);
}
