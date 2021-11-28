package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 顾倾歌
 * @Date 2021/10/7 0:20
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "stock")
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "skid", type = IdType.AUTO)
    private Integer skid;

    // 商品id
    private Integer commid;

    // 商品名称
    @TableField(exist = false)
    private String commname;

    // 商品价格
    private Double skmoney;

    // 进货数量
    private Integer sknumber;

    // 总价
    private Double totalprice;

    // 进货时间
    private Date skdate;

    @TableField(exist = false)
    private Integer countnumbers;

    @TableField(exist = false)
    private String counttime;


    public Integer getSkid() {
        return skid;
    }

    public void setSkid(Integer skid) {
        this.skid = skid;
    }

    public Integer getCommid() {
        return commid;
    }

    public void setCommid(Integer commid) {
        this.commid = commid;
    }

    public String getCommname() {
        return commname;
    }

    public void setCommname(String commname) {
        this.commname = commname;
    }

    public Double getSkmoney() {
        return skmoney;
    }

    public void setSkmoney(Double skmoney) {
        this.skmoney = skmoney;
    }

    public Integer getSknumber() {
        return sknumber;
    }

    public void setSknumber(Integer sknumber) {
        this.sknumber = sknumber;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public Date getSkdate() {
        return skdate;
    }

    public void setSkdate(Date skdate) {
        this.skdate = skdate;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "skid=" + skid + '\'' +
                ", commid=" + commid + '\'' +
                ", commname='" + commname + '\'' +
                ", skmoney=" + skmoney + '\'' +
                ", sknumber=" + sknumber + '\'' +
                ", totalprice=" + totalprice + '\'' +
                ", skdate=" + skdate +
                '}';
    }
}