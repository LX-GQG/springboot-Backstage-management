package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Provider;

/**
 * @Author 顾倾歌
 * @Date 2021/10/2 23:58
 * @Version 1.0
 */
public interface ProviderMapper extends BaseMapper<Provider> {
    IPage<Provider> selectProviderPage(Page<Provider> page, String keyword);
}
