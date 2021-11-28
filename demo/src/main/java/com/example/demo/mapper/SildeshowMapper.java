package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Rtsale;
import com.example.demo.entity.Sildeshow;

/**
 * @Author 顾倾歌
 * @Date 2021/11/3 15:38
 * @Version 1.0
 */
public interface SildeshowMapper extends BaseMapper<Sildeshow> {
    IPage<Sildeshow> selectSildeshowPage(Page<Sildeshow> page, String keyword);
}
