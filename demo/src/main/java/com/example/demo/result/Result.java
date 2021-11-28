package com.example.demo.result;

/**
 * @Author: 顾倾歌
 * @Date: 2021/7/16
 * @Description: 统一结果封装
 **/


public class Result {
    //响应码
    private Integer code;
    //信息
    private String message;
    //返回数据
    private Object data;

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    //利用static的静态方法 将数据动态返回
    public static Result fail(){
        return new Result(201,"执行失败",null);
    }

    public static Result fail(String msp){ return new Result(201,"业务执行失败",null); }

    public static Result success(){
        return new Result(200,"执行成功",null);
    }

    public static Result success(Object data){
        return new Result(200,"执行成功",data);
    }

    public static Result success(String message,Object data){
        return new Result(200,message,data);
    }

}
