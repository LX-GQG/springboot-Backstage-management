package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Good;
import com.example.demo.entity.Provider;
import com.example.demo.entity.Stock;
import com.example.demo.mapper.GoodMapper;
import com.example.demo.mapper.ProviderMapper;
import com.example.demo.mapper.StockMapper;
import com.example.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @Author 顾倾歌
 * @Date 2021/10/7 0:31
 * @Version 1.0
 */
@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements StockService {

    @Autowired
    private GoodMapper goodMapper;

    @Autowired
    private StockMapper stockMapper;


    @Override
    public IPage<Stock> selectStockPage(QueryDTO queryDTO) {
        Page<Stock> page = new Page<>(queryDTO.getPageNo(),queryDTO.getPageSize());
        return stockMapper.selectStockPage(page,queryDTO.getKeyword());
    }

    @Override
    public Integer addStock(Stock stock) {
        return stockMapper.insert(stock);
    }

    @Override
    public Integer updateStock(Stock stock) {
        return stockMapper.updateById(stock);
    }

    @Override
    public Integer deleteStock(Integer skid) {
        return stockMapper.deleteById(skid);
    }

    @Override
    public void batchDelete(List<Integer> skids) {
        stockMapper.deleteBatchIds(skids);
    }
}
