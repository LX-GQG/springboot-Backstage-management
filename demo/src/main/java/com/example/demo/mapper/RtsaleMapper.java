package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Refund;
import com.example.demo.entity.Rtsale;

/**
 * @Author 顾倾歌
 * @Date 2021/10/12 22:12
 * @Version 1.0
 */
public interface RtsaleMapper extends BaseMapper<Rtsale> {
    IPage<Rtsale> selectRtsalePage(Page<Rtsale> page, String keyword);
}
