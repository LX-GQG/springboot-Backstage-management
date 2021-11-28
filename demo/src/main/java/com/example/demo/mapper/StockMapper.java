package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Stock;

/**
 * @Author 顾倾歌
 * @Date 2021/10/7 0:32
 * @Version 1.0
 */
public interface StockMapper extends BaseMapper<Stock> {

    IPage<Stock> selectStockPage(Page<Stock> page, String keyword);
}
