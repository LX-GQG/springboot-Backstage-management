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
 * @Date 2021/10/12 22:03
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "rtsale")
public class Rtsale implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 销售退货id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品id外键
     */
    private Integer commid;

    /**
     * 销售退货数量
     */
    private Integer rtsnumber;

    /**
     * 销售退货时间
     */
    private Date rtstime;

    /**
     * 销售退货金额
     */
    private Integer rtsmoney;

    /**
     * 销售退货备注
     */
    private String rtsmark;

    @TableField(exist = false)
    private String commname;

    @TableField(exist = false)
    private Integer inventory;

    @TableField(exist = false)
    private String counttime;

    @TableField(exist = false)
    private Integer moneys;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommid() {
        return commid;
    }

    public void setCommid(Integer commid) {
        this.commid = commid;
    }

    public Integer getRtsnumber() {
        return rtsnumber;
    }

    public void setRtsnumber(Integer rtsnumber) {
        this.rtsnumber = rtsnumber;
    }

    public Date getRtstime() {
        return rtstime;
    }

    public void setRtstime(Date rtstime) {
        this.rtstime = rtstime;
    }

    public Integer getRtsmoney() {
        return rtsmoney;
    }

    public void setRtsmoney(Integer rtsmoney) {
        this.rtsmoney = rtsmoney;
    }

    public String getCommname() {
        return commname;
    }

    public void setCommname(String commname) {
        this.commname = commname;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Rtsale{" +
                "id=" + id +
                ", commid=" + commid +
                ", rtsnumber=" + rtsnumber +
                ", rtstime=" + rtstime +
                ", rtsmoney=" + rtsmoney +
                ", commname='" + commname + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
