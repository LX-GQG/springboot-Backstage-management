package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Good;
import com.example.demo.entity.Provider;
import com.example.demo.entity.User;
import com.example.demo.result.DataGridViewResult;
import com.example.demo.result.Result;
import com.example.demo.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 顾倾歌
 * @Date 2021/10/3 0:06
 * @Version 1.0
 */
@RestController
public class ProviderController {

    @Autowired
    private ProviderService service;

    /**
     * 分页查询
     * @param queryDTO
     * @return
     */

    @PostMapping("api/provider/list")
    public Result providerList(@RequestBody QueryDTO queryDTO){

        return new Result(200,"",service.selectProviderPage(queryDTO));
    }

    /**
     * 添加
     * @param provider
     * @return
     */
    @PostMapping("api/provider/add")
    public Result addProvider(@RequestBody Provider provider){
        return new Result(200,"",service.addProvider(provider));
    }

    /**
     * 更新/修改
     * @param provider
     * @return
     */
    @PostMapping("api/provider/update")
    public Result updateProvider(@RequestBody Provider provider){
        return new Result(200,"",service.updateProvider(provider));
    }

    /**
     * 删除
     * @param providerid
     * @return
     */
    @PostMapping("api/provider/delete")
    public Result deleteProvider(Integer providerid){
        return new Result(200,"",service.deleteProvider(providerid));
    }

    /**
     * 批量删除
     * @param providerids
     * @return
     */
    @PostMapping("api/provider/delete/batch")
    public Result batchDeleteProvider(@RequestBody List<Integer> providerids){
        service.batchDelete(providerids);
        return new Result(200,"","");
    }

    /**
     * 根据供应商id加载供应商信息
     * @param
     * @return
     */
    @PostMapping("api/provider/loadProviderById")
    public DataGridViewResult loadProviderById(Integer providerid) {
        QueryWrapper<Provider> goodsQueryWrapper = new QueryWrapper<>();
        goodsQueryWrapper.eq(providerid != 0, "providerid", providerid);
        Provider provider = service.getById(providerid);
        System.out.println(provider);
        return new DataGridViewResult(provider);
    }

    /**
     * 根据供应商id加载供应商信息
     * @param
     * @return
     */
    @PostMapping("api/provider/loadProviderByIds")
    public DataGridViewResult loadProviderByIds(Integer providerid) {
        QueryWrapper<Provider> goodsQueryWrapper = new QueryWrapper<>();
        goodsQueryWrapper.eq(providerid != 0, "providerid", providerid);
        Provider provider = service.getById(providerid);
        System.out.println(provider);
        return new DataGridViewResult(provider);

    }

    /**
     * 加载下拉框
     *
     * @return
     */
    @RequestMapping("api/provider/AllProvider")
    public DataGridViewResult loadAllProvider() {
        QueryWrapper<Provider> queryWrapper = new QueryWrapper<>();
        List<Provider> list = service.list(queryWrapper);
        return new DataGridViewResult(list);

    }
}
