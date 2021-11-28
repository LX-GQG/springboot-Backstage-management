package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Good;
import com.example.demo.entity.Provider;
import com.example.demo.mapper.GoodMapper;
import com.example.demo.mapper.ProviderMapper;
import com.example.demo.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 顾倾歌
 * @Date 2021/10/2 23:57
 * @Version 1.0
 */
@Service
public class ProviderServiceImpl extends ServiceImpl<ProviderMapper, Provider> implements ProviderService {

    @Autowired
    private ProviderMapper providerMapper;


    @Override
    public IPage<Provider> selectProviderPage(QueryDTO queryDTO) {
        Page<Provider> page = new Page<>(queryDTO.getPageNo(),queryDTO.getPageSize());
        return providerMapper.selectProviderPage(page,queryDTO.getKeyword());
    }

    @Override
    public Integer addProvider(Provider provider) {
        return providerMapper.insert(provider);
    }

    @Override
    public Integer updateProvider(Provider provider) {
        return providerMapper.updateById(provider);
    }

    @Override
    public Integer deleteProvider(Integer providerid) {
        return providerMapper.deleteById(providerid);
    }

    @Override
    public void batchDelete(List<Integer> providerids) {
        providerMapper.deleteBatchIds(providerids);
    }

}
