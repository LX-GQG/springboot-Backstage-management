package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Description: 客户

 * @Author 顾倾歌

 * @Date 2021/9/30 23:10

 * @Version 1.0

 */
@AllArgsConstructor//全参构造
@NoArgsConstructor//无参构造
@Data
@Accessors(chain = true)//链式写法
@TableName(value = "customer")
public class Customer {
    @TableId(type = IdType.AUTO)
    /**
     * 客户编号
     */
    private Integer custid;
    /**
     * 客户登录账号
     */
    private String custlogin;
    /**
     * 客户密码
     */
    private String custpass;
    /**
     * 客户姓名
     */
    private String custname;
    /**
     * 客户电话
     */
    private String phone;
    /**
     * 客户性别
     */
    private String custsex;

    @TableField(exist = false)
    private Integer custnumber;

    public Integer getCustid() {
        return custid;
    }

    public void setCustid(Integer custid) {
        this.custid = custid;
    }

    public String getCustlogin() {
        return custlogin;
    }

    public void setCustlogin(String custlogin) {
        this.custlogin = custlogin;
    }

    public String getCustpass() {
        return custpass;
    }

    public void setCustpass(String custpass) {
        this.custpass = custpass;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustsex() {
        return custsex;
    }

    public void setCustsex(String custsex) {
        this.custsex = custsex;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custid='" + custid + '\'' +
                ", custlogin='" + custlogin + '\'' +
                ", custpass='" + custpass + '\'' +
                ", custname='" + custname + '\'' +
                ", phone='" + phone + '\'' +
                ", custsex='" + custsex + '\'' +
                '}';
    }
}
