package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Good;
import com.example.demo.entity.Sildeshow;
import com.example.demo.mapper.SildeshowMapper;
import com.example.demo.service.SildeshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 顾倾歌
 * @Date 2021/11/3 15:36
 * @Version 1.0
 */
@Service
public class SildeshowServiceImpl extends ServiceImpl<SildeshowMapper, Sildeshow> implements SildeshowService {

    @Autowired
    private SildeshowMapper sildeshowMapper;

    /**
     * 分页查询
     **/
    @Override
    public IPage<Sildeshow> selectSildeshowPage(QueryDTO queryDTO) {
        Page<Sildeshow> page = new Page<>(queryDTO.getPageNo(),queryDTO.getPageSize());
        return sildeshowMapper.selectSildeshowPage(page,queryDTO.getKeyword());
    }

    @Override
    public Integer addSildeshow(Sildeshow sildeshow) {
        return sildeshowMapper.insert(sildeshow);
    }

    @Override
    public Integer updateSildeshow(Sildeshow sildeshow) {
        return sildeshowMapper.updateById(sildeshow);
    }

    @Override
    public Integer deleteSildeshow(Integer id) {
        return sildeshowMapper.deleteById(id);
    }

    @Override
    public void batchDelete(List<Integer> ids) {
        sildeshowMapper.deleteBatchIds(ids);
    }
}
