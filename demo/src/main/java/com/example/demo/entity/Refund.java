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
 * @Date 2021/10/11 14:13
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("refund")
public class Refund implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 退货id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 商品id
     */
    private Integer commid;

    /**
     * 商品名称
     */
    @TableField(exist = false)
    private String commname;

    /**
     * 退货价格
     */
    private Double rfmoney;

    /**
     * 退货数量
     */
    private Integer rfnumber;

    /**
     * 退货备注
     */
    private String remark;

    /**
     * 退货时间
     */
    private Date reftime;

    @TableField(exist = false)
    private Integer countnumbers;

    @TableField(exist = false)
    private String counttime;

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

    public Double getRfmoney() {
        return rfmoney;
    }

    public void setRfmoney(Double rfmoney) {
        this.rfmoney = rfmoney;
    }

    public Integer getRfnumber() {
        return rfnumber;
    }

    public void setRfnumber(Integer rfnumber) {
        this.rfnumber = rfnumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getReftime() {
        return reftime;
    }

    public void setReftime(Date reftime) {
        this.reftime = reftime;
    }

    @Override
    public String toString() {
        return "Refund{" +
                "id=" + id +
                ", commid=" + commid +
                ", rfmoney=" + rfmoney +
                ", rfnumber=" + rfnumber +
                ", remark='" + remark + '\'' +
                ", reftime=" + reftime +
                '}';
    }
}
