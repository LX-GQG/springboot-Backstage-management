package com.example.demo.dto;

/**
 * @Author 顾倾歌
 * @Date 2021/10/14 15:16
 * @Version 1.0
 */
public class LogincustDTO {

        private String custlogin;
        private String custpass;
        private String phone;

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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
}
