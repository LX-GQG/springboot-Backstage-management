package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 顾倾歌
 * @Date 2021/10/11 22:01
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "sale")
public class Sale implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 销售id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 客户id外键
     */
    private Integer custid;

    /**
     * 商品id外键
     */
    private Integer commid;

    /**
     * 销售数量
     */
    private Integer salemount;

    /**
     * 销售时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date saletime;

    /**
     * 销售金额
     */
    private Integer salemoney;

    /**
     * 销售总额
     */
    private Integer allmoney;

    @TableField(exist = false)
    private String commname;

    @TableField(exist = false)
    private Integer inventory;

    @TableField(exist = false)
    private String custname;

    /**
     * 销量
     */
    @TableField(exist = false)
    private Integer total;

    @TableField(exist = false)
    private String counttime;

    @TableField(exist = false)
    private Integer moneys;

    @TableField(exist = false)
    private Date startTime;

    @TableField(exist = false)
    private Date endTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustid() {
        return custid;
    }

    public void setCustid(Integer custid) {
        this.custid = custid;
    }

    public Integer getCommid() {
        return commid;
    }

    public void setCommid(Integer commid) {
        this.commid = commid;
    }

    public Integer getSalemount() { return salemount; }

    public void setSalemount(Integer salemount) {
        this.salemount = salemount;
    }

    public Date getSaletime() {
        return saletime;
    }

    public void setSaletime(Date saletime) {
        this.saletime = saletime;
    }

    public Integer getSalemoney() {
        return salemoney;
    }

    public void setSalemoney(Integer salemoney) {
        this.salemoney = salemoney;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", custid=" + custid +
                ", commid=" + commid +
                ", salemount=" + salemount +
                ", saletime=" + saletime +
                ", salemoney=" + salemoney +
                '}';
    }
}
