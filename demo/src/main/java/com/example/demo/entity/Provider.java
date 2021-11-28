package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author 顾倾歌
 * @Date 2021/9/30 23:17
 * @Version 1.0
 */
@AllArgsConstructor//全参构造
@NoArgsConstructor//无参构造
@Data
@Accessors(chain = true)//链式写法
@TableName(value = "provider")
public class Provider {
    @TableId(type = IdType.AUTO)
    /**
     * 供应商id
     */
    private Integer providerid;
    /**
     * 供应商名称
     */
    private String pvename;
    /**
     * 供应商电话
     */
    private String pvephone;
    /**
     * 供应商地址
     */
    private String pveaddress;

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

    public String getPvephone() {
        return pvephone;
    }

    public void setPvephone(String pvephone) {
        this.pvephone = pvephone;
    }

    public String getPveaddress() {
        return pveaddress;
    }

    public void setPveaddress(String pveaddress) {
        this.pveaddress = pveaddress;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "providerid='" + providerid + '\'' +
                ", pvename='" + pvename + '\'' +
                ", pvephone='" + pvephone + '\'' +
                ", pveaddress='" + pveaddress + '\'' +
                '}';
    }
}
