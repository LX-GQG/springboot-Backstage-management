package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Rtsale;
import com.example.demo.entity.Sale;

import java.util.List;
import java.util.Map;

/**
 * @Author 顾倾歌
 * @Date 2021/10/11 22:09
 * @Version 1.0
 */
public interface SaleService extends IService<Sale> {
    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
    IPage<Sale> selectSalesPage(QueryDTO queryDTO);

    IPage<Sale> selectMonth(QueryDTO queryDTO);

    /**
     * 添加用户
     * @param sale
     * @return
     */
    Integer addSale(Sale sale);

    /**
     * 更新
     * @param sale
     * @return
     */
    Integer updateSale(Sale sale);

    /**
     * 删除
     * @param id
     * @return
     */
    Integer deleteSale(Integer id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    void batchDelete(List<Integer> ids);
}
