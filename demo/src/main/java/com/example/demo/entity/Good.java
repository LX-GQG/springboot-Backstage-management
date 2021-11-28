package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@AllArgsConstructor//全参构造
@NoArgsConstructor//无参构造
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)//链式写法
@TableName(value = "good")
public class Good implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 商品id
     */
    private Integer commid;
    /**
     * 商品名
     */
    private String commname;
    /**
     * 前台销售价格
     */
    private Double commoney;
    /**
     * 商品描述
     */
    private String commdesc;
    /**
     * 商品编号
     */
    private String commbering;
    /**
     * 规格
     */
    private String size;
    /**
     * 库存
     */
    private Integer inventory;
    /**
     * 简介图
     */
    private String picture;

    /**
     * 供应商编号
     */
    private Integer providerid;

    @TableField(exist = false)
    private String pvename;

    public Integer getcommid() {
        return commid;
    }

    public void setcommid(Integer commid) {
        this.commid = commid;
    }

    public String getCommname() {
        return commname;
    }

    public void setCommname(String commname) {
        this.commname = commname;
    }

    public Double getCommoney() { return commoney; }

    public void setCommoney(Double commoney) { this.commoney = commoney; }

    public String getCommdesc() {
        return commdesc;
    }

    public void setCommdesc(String commdesc) {
        this.commdesc = commdesc;
    }

    public Integer getProviderid() {
        return providerid;
    }

    public void setProviderid(Integer providerid) {
        this.providerid = providerid;
    }

    public String getPvename() {
        return pvename;
    }

    public void setPvename(String pvename) {
        this.pvename = pvename;
    }

    public String getCommbering() {
        return commbering;
    }

    public void setCommbering(String commbering) {
        this.commbering = commbering;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Good{" +
                "commid='" + commid + '\'' +
                ", commname='" + commname + '\'' +
                ", commdesc='" + commdesc + '\'' +
                ", commbering='" + commbering + '\'' +
                ", inventory='" + inventory + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}