package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Rtsale;

/**
 * @Author 顾倾歌
 * @Date 2021/10/12 22:08
 * @Version 1.0
 */
public interface RtsaleService extends IService<Rtsale> {

    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
    IPage<Rtsale> selectRtsalePage(QueryDTO queryDTO);

    /**
     * 添加退货
     * @return
     */
    void addRtsale(Rtsale rtsale);
}
