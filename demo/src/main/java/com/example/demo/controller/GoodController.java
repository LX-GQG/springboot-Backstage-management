package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Good;
import com.example.demo.entity.Provider;
import com.example.demo.mapper.GoodMapper;
import com.example.demo.result.DataGridViewResult;
import com.example.demo.result.Result;
import com.example.demo.service.GoodService;
import com.example.demo.service.ProviderService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**

 * Description:

 * date: 2021/9/18 23:56

 * @author: 顾倾歌

 * @since JDK 1.8

 */
@RestController
public class GoodController {

    @Autowired
    private GoodService service;

    @Autowired
    private GoodMapper goodMapper;

    /**
     * 分页查询
     * @param queryDTO
     * @return
     */

    @PostMapping("api/good/list")
    public Result goodList(@RequestBody QueryDTO queryDTO){
        return new Result(200,"",service.selectGoodPage(queryDTO));
    }

    @PostMapping("api/good/listpro")
    public Result goodProList(String keyword){
        return new Result(200,"",goodMapper.selectname(keyword));
    }

    /**
     * 前台显示
     * @return
     */
    @PostMapping("api/good/lists")
    public Result goodLists(){
        return new Result(200,"",service.list());
    }

    /**
     * 前台查询商品名称
     * @return
     */
    @PostMapping("api/good/selectlists")
    public Result goodSelectLists(String keyword){
        return new Result(200,"",goodMapper.selectgood(keyword));
    }

    /**
     * 添加
     * @param good
     * @return
     */
    @PostMapping("api/good/add")
    public Result addGood(@RequestBody Good good){
        // 随机的商品编号
        String bering = RandomStringUtils.randomAlphanumeric(8);
        good.setCommbering(bering);
        good.setInventory(0);
        return new Result(200,"",service.addGood(good));
    }

    /**
     * 更新/修改
     * @param good
     * @return
     */
    @PostMapping("api/good/update")
    public Result updateGoods(@RequestBody Good good){
        return new Result(200,"",service.updateGood(good));
    }

    /**
     * 删除
     * @param commid
     * @return
     */
    @PostMapping("api/good/delete")
    public Result deleteGood(Integer commid){
        return new Result(200,"",service.deleteGood(commid));
    }

    /**
     * 批量删除
     * @param commids
     * @return
     */
    @PostMapping("api/good/delete/batch")
    public Result batchDeleteGood(@RequestBody List<Integer> commids){
        service.batchDelete(commids);
        return new Result(200,"","");
    }

    /**
     * 根据商品id加载商品信息
     * @param
     * @return
     */
    @PostMapping("api/good/loadGoodById")
    public DataGridViewResult loadGoodsById(Integer commid) {
        QueryWrapper<Good> goodsQueryWrapper = new QueryWrapper<>();
        goodsQueryWrapper.eq(commid != 0, "commid", commid);
        Good good = service.getById(commid);
        System.out.println(good);
        return new DataGridViewResult(good);
    }

    /**
     * 根据供应商id加载商品信息
     * @param
     * @return
     */
    @PostMapping("api/good/loadProById")
    public DataGridViewResult loadProById(Integer providerid) {
        QueryWrapper<Good> goodsQueryWrapper = new QueryWrapper<>();
        goodsQueryWrapper.eq(providerid != 0, "providerid", providerid);
        Good good = service.getById(providerid);
        System.out.println(good);
        return new DataGridViewResult(good);
    }

    /**
     * 加载下拉框
     *
     * @return
     */
    @RequestMapping("api/good/AllGood")
    public DataGridViewResult loadAllGoods() {
        QueryWrapper<Good> queryWrapper = new QueryWrapper<>();
        List<Good> list = service.list(queryWrapper);
        return new DataGridViewResult(list);

    }
}