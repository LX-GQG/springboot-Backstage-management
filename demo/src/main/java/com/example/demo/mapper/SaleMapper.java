package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Sale;

import java.util.List;

/**
 * @Author 顾倾歌
 * @Date 2021/10/11 22:10
 * @Version 1.0
 */
public interface SaleMapper extends BaseMapper<Sale> {
    IPage<Sale> selectSalePage(Page<Sale> page, String keyword);

    IPage<Sale> selectSalemonth(Page<Sale> page, String keyword);
}
