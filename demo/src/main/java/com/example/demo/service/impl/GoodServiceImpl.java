package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Good;
import com.example.demo.mapper.GoodMapper;
import com.example.demo.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**

 * Description:  商品实现类

 * date: 2021/9/18 15:01

 * @author: 顾倾歌

 * @since JDK 1.8

 */
@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Good> implements GoodService {

    @Autowired
    private GoodMapper goodMapper;

    /**
     * 分页查询
     **/
    @Override
    public IPage<Good> selectGoodPage(QueryDTO queryDTO) {
        Page<Good> page = new Page<>(queryDTO.getPageNo(),queryDTO.getPageSize());
        return goodMapper.selectGoodPage(page,queryDTO.getKeyword());
    }

    @Override
    public Integer addGood(Good good) {
        return goodMapper.insert(good);
    }

    @Override
    public Integer updateGood(Good good) {
        return goodMapper.updateById(good);
    }

    @Override
    public Integer deleteGood(Integer commid) {
        return goodMapper.deleteById(commid);
    }

    @Override
    public void batchDelete(List<Integer> commids) {
        goodMapper.deleteBatchIds(commids);
    }
}
