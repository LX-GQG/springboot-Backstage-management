package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Refund;

import javax.servlet.http.HttpSession;


/**
 * @Author 顾倾歌
 * @Date 2021/10/11 14:25
 * @Version 1.0
 */
public interface RefundService extends IService<Refund> {
    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
    IPage<Refund> selectRefundPage(QueryDTO queryDTO);

    /**
     * 添加退货
     * @return
     */
    void addRefund(Refund refund);
}
