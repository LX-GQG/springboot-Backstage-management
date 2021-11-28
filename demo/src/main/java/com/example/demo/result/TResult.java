package com.example.demo.result;

/**
 * @Author 顾倾歌
 * @Date 2021/10/7 14:20
 * @Version 1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TResult {


    private boolean status;

    /**
     * 返回状态码 200是正常 非200表示数据异常
     */
    private String code;

    /**
     * 返回信息
     */
    private String message;


    public static TResult error(boolean status,String code,String message) {
        TResult result = new TResult();
        result.setStatus(status);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static TResult success(boolean status,String code,String message) {
        TResult result = new TResult();
        result.setStatus(status);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}