package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.*;
import com.example.demo.mapper.*;
import com.example.demo.service.RefundService;
import com.example.demo.service.RtsaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author 顾倾歌
 * @Date 2021/10/12 22:10
 * @Version 1.0
 */
@Service
public class RtsaleServiceImpl extends ServiceImpl<RtsaleMapper, Rtsale> implements RtsaleService {
    @Autowired
    private RtsaleMapper rtsaleMapper;

    @Resource
    private SaleMapper saleMapper;

    @Resource
    private GoodMapper goodMapper;

    @Override
    public IPage<Rtsale> selectRtsalePage(QueryDTO queryDTO) {
        Page<Rtsale> page = new Page<>(queryDTO.getPageNo(),queryDTO.getPageSize());
        return rtsaleMapper.selectRtsalePage(page,queryDTO.getKeyword());
    }

    @Override
    public void addRtsale(Rtsale rtsale) {
        System.out.println(rtsale);
        Sale sale = saleMapper.selectById(rtsale.getId());
        System.out.println(sale);
        Good good = goodMapper.selectById(sale.getCommid());
        if (good.getInventory()>=rtsale.getRtsnumber()) {
            good.setInventory(good.getInventory()+rtsale.getRtsnumber());
            goodMapper.updateById(good);
            rtsale.setCommid(good.getcommid());
            rtsale.setRtstime(new Date());
            rtsale.setRtsmark(rtsale.getRtsmark());
            rtsale.setRtsmoney(sale.getSalemoney()*rtsale.getRtsnumber());
            rtsale.setRtsnumber(rtsale.getRtsnumber());
            System.out.println(rtsale);
            baseMapper.insert(rtsale);
        }
    }
}
