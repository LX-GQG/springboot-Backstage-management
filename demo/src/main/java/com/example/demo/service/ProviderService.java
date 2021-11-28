package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Provider;

import java.util.List;

/**
 * @Author 顾倾歌
 * @Date 2021/10/2 23:55
 * @Version 1.0
 */
public interface ProviderService extends IService<Provider> {
    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
    IPage<Provider> selectProviderPage(QueryDTO queryDTO);

    /**
     * 添加用户
     * @param provider
     * @return
     */
    Integer addProvider(Provider provider);

    /**
     * 更新
     * @param provider
     * @return
     */
    Integer updateProvider(Provider provider);

    /**
     * 删除
     * @param providerid
     * @return
     */
    Integer deleteProvider(Integer providerid);

    /**
     * 批量删除
     * @param providerids
     * @return
     */
    void batchDelete(List<Integer> providerids);

}
