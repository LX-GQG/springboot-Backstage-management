package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Good;

import java.util.List;

/**

 * Description:

 * date: 2021/9/18 14:42

 * @author: 顾倾歌

 * @since JDK 1.8

 */
public interface GoodMapper extends BaseMapper<Good> {
    IPage<Good> selectGoodPage(Page<Good> page, String keyword);

    List<Good> selectname(String keyword);

    List<Good> selectgood(String keyword);
}