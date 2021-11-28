package com.example.demo.controller;

import com.example.demo.dto.QueryDTO;
import com.example.demo.entity.Sildeshow;
import com.example.demo.entity.User;
import com.example.demo.result.Result;
import com.example.demo.service.SildeshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 顾倾歌
 * @Date 2021/11/3 15:48
 * @Version 1.0
 */
@RestController
public class SildeshowController {

    @Autowired
    private SildeshowService sildeshowService;

    /**
     * 分页查询
     * @param queryDTO
     * @return
     */

    @PostMapping("api/sildeshow/list")
    public Result sildeshowList(@RequestBody QueryDTO queryDTO){
        return new Result(200,"",sildeshowService.selectSildeshowPage(queryDTO));
    }

    /**
     * 前台显示
     * @return
     */
    @PostMapping("api/sildeshow/lists")
    public Result sildeshowLists(){
        return new Result(200,"",sildeshowService.list());
    }

    /**
     * 添加
     * @param sildeshow
     * @return
     */
    @PostMapping("api/sildeshow/add")
    public Result addSildeshow(@RequestBody Sildeshow sildeshow){
        return new Result(200,"",sildeshowService.addSildeshow(sildeshow));
    }

    /**
     * 更新/修改
     * @param sildeshow
     * @return
     */
    @PostMapping("api/sildeshow/update")
    public Result updateSildeshow(@RequestBody Sildeshow sildeshow){
        return new Result(200,"",sildeshowService.updateSildeshow(sildeshow));
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping("api/sildeshow/delete")
    public Result deleteSildeshow(Integer id){
        return new Result(200,"",sildeshowService.deleteSildeshow(id));
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("api/sildeshow/delete/batch")
    public Result batchDeleteSildeshow(@RequestBody List<Integer> ids){
        sildeshowService.batchDelete(ids);
        return new Result(200,"","");
    }
}
