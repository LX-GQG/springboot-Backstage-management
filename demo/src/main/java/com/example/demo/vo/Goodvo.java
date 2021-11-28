package com.example.demo.vo;


import com.example.demo.entity.Good;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 顾倾歌
 * @Date 2021/10/6 13:05
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goodvo extends Good {
    /**
     * 当前页码
     */
    private Integer page;

    /**
     * 每页显示数量
     */
    private Integer limit;
}

