package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 顾倾歌
 * @Date: 2021/7/17
 * @Description: MP分页
 **/

@Configuration
@MapperScan("com.example.demo.mapper.*,mapper*")
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor  paginationInnerInterceptor() {
        PaginationInterceptor paginationInnerInterceptor = new PaginationInterceptor ();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInnerInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条， -1 不受限制
        // paginationInnerInterceptor.setLimit(500)
        // 开启 count 的json 优化，只针对部分 Left join
        paginationInnerInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInnerInterceptor;
    }
}
