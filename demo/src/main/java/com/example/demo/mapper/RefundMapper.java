package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Refund;

/**
 * @Author 顾倾歌
 * @Date 2021/10/11 14:38
 * @Version 1.0
 */
public interface RefundMapper extends BaseMapper<Refund> {
    IPage<Refund> selectRefundPage(Page<Refund> page, String keyword);
}
