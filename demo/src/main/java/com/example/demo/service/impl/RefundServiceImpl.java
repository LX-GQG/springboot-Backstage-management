package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Good;
import com.example.demo.entity.Refund;
import com.example.demo.entity.Stock;
import com.example.demo.mapper.GoodMapper;
import com.example.demo.mapper.RefundMapper;
import com.example.demo.mapper.StockMapper;
import com.example.demo.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Author 顾倾歌
 * @Date 2021/10/11 14:35
 * @Version 1.0
 */
@Service
public class RefundServiceImpl extends ServiceImpl<RefundMapper, Refund> implements RefundService {

    @Autowired
    private RefundMapper refundMapper;

    @Resource
    private StockMapper stockMapper;

    @Resource
    private GoodMapper goodMapper;

    @Override
    public IPage<Refund> selectRefundPage(QueryDTO queryDTO) {
        Page<Refund> page = new Page<>(queryDTO.getPageNo(),queryDTO.getPageSize());
        return refundMapper.selectRefundPage(page,queryDTO.getKeyword());
    }

    @Override
    public void addRefund(Refund refund) {
        System.out.println(refund);
        Stock stock = stockMapper.selectById(refund.getId());
        System.out.println(stock);
        Good good = goodMapper.selectById(stock.getCommid());
        if (good.getInventory()>=refund.getRfnumber()) {
            good.setInventory(good.getInventory()-refund.getRfnumber());
            goodMapper.updateById(good);
            refund.setCommid(good.getcommid());
            refund.setReftime(new Date());
            refund.setRemark(refund.getRemark());
            refund.setRfmoney(stock.getSkmoney()*refund.getRfnumber());
            refund.setRfnumber(refund.getRfnumber());
            System.out.println(refund);
            baseMapper.insert(refund);
        }
    }
}
