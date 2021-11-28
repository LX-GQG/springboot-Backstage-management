package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Good;

import java.util.List;

/**

 * Description:  商品

 * date: 2021/9/18 14:54

 * @author: 顾倾歌

 * @since JDK 1.8

 */
public interface GoodService extends IService<Good> {

    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
    IPage<Good> selectGoodPage(QueryDTO queryDTO);

    /**
     * 添加商品
     * @param good
     * @return
     */
    Integer addGood(Good good);

    /**
     * 更新
     * @param good
     * @return
     */
    Integer updateGood(Good good);

    /**
     * 删除
     * @param commid
     * @return
     */
    Integer deleteGood(Integer commid);

    /**
     * 批量删除
     * @param commids
     * @return
     */
    void batchDelete(List<Integer> commids);
}