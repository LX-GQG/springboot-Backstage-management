package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Sildeshow;
import com.example.demo.entity.Stock;

import java.util.List;

/**
 * @Author 顾倾歌
 * @Date 2021/11/3 15:23
 * @Version 1.0
 */
public interface SildeshowService extends IService<Sildeshow> {
    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
    IPage<Sildeshow> selectSildeshowPage(QueryDTO queryDTO);

    /**
     * 添加轮播图
     * @param sildeshow
     * @return
     */
    Integer addSildeshow(Sildeshow sildeshow);

    /**
     * 更新
     * @param sildeshow
     * @return
     */
    Integer updateSildeshow(Sildeshow sildeshow);

    /**
     * 删除
     * @param id
     * @return
     */
    Integer deleteSildeshow(Integer id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    void batchDelete(List<Integer> ids);
}
