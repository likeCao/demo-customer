package com.class1804.democustomer.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.Date;

//客户预约表
public class Order {

    private int order_id;           //预约id
    private  int order_number;      //预约号，当前日期（20200305）+客户id
    private  int order_customerid;  //客户id
    private int order_userid;       //处理员工id，对应员工表
    private int order_productid;    //产品id
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @JsonProperty("order_date")
    private String order_date;   //预约时间
    private String order_text;      //备注


    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public int getOrder_customerid() {
        return order_customerid;
    }

    public void setOrder_customerid(int order_customerid) {
        this.order_customerid = order_customerid;
    }

    public int getOrder_userid() {
        return order_userid;
    }

    public void setOrder_userid(int order_userid) {
        this.order_userid = order_userid;
    }

    public int getOrder_productid() {
        return order_productid;
    }

    public void setOrder_productid(int order_productid) {
        this.order_productid = order_productid;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_text() {
        return order_text;
    }

    public void setOrder_text(String order_text) {
        this.order_text = order_text;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_number=" + order_number +
                ", order_customerid=" + order_customerid +
                ", order_userid=" + order_userid +
                ", order_productid=" + order_productid +
                ", order_date=" + order_date +
                ", order_text='" + order_text + '\'' +
                '}';
    }
}
