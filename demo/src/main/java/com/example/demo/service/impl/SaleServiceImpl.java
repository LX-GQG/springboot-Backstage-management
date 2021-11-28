package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Rtsale;
import com.example.demo.entity.Sale;
import com.example.demo.mapper.RtsaleMapper;
import com.example.demo.mapper.SaleMapper;
import com.example.demo.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author 顾倾歌
 * @Date 2021/10/11 22:16
 * @Version 1.0
 */
@Service
public class SaleServiceImpl extends ServiceImpl<SaleMapper, Sale> implements SaleService {

    @Autowired
    private SaleMapper saleMapper;

    @Override
    public IPage<Sale> selectSalesPage(QueryDTO queryDTO) {
        Page<Sale> page = new Page<>(queryDTO.getPageNo(),queryDTO.getPageSize());
        return saleMapper.selectSalePage(page,queryDTO.getKeyword());
    }

    @Override
    public IPage<Sale> selectMonth(QueryDTO queryDTO) {
        Page<Sale> page = new Page<>(queryDTO.getPageNo(),queryDTO.getPageSize());
        return saleMapper.selectSalePage(page,queryDTO.getKeyword());
    }


    @Override
    public Integer addSale(Sale sale) {
        return saleMapper.insert(sale);
    }

    @Override
    public Integer updateSale(Sale sale) {
        return saleMapper.updateById(sale);
    }

    @Override
    public Integer deleteSale(Integer id) {
        return saleMapper.deleteById(id);
    }

    @Override
    public void batchDelete(List<Integer> ids) {
        saleMapper.deleteBatchIds(ids);
    }
}
