package com.class1804.democustomer.pojo;

import java.sql.Timestamp;

//产品表
public class Product {

    private int product_id;             //产品id，主键，唯一标识
    private String product_name;        //产品姓名
    private Timestamp product_start;    //上架时间（当前时间）
    private String product_introduce;   //产品介绍
    private int product_category;       //产品类别，对应产品类别表
    private Double product_money;       //售卖金额，单件
    private Double product_cost;        //成本金额


    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Timestamp getProduct_start() {
        return product_start;
    }

    public void setProduct_start(Timestamp product_start) {
        this.product_start = product_start;
    }

    public String getProduct_introduce() {
        return product_introduce;
    }

    public void setProduct_introduce(String product_introduce) {
        this.product_introduce = product_introduce;
    }

    public int getProduct_category() {
        return product_category;
    }

    public void setProduct_category(int product_category) {
        this.product_category = product_category;
    }

    public Double getProduct_money() {
        return product_money;
    }

    public void setProduct_money(Double product_money) {
        this.product_money = product_money;
    }

    public Double getProduct_cost() {
        return product_cost;
    }

    public void setProduct_cost(Double product_cost) {
        this.product_cost = product_cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_start=" + product_start +
                ", product_introduce='" + product_introduce + '\'' +
                ", product_category=" + product_category +
                ", product_money=" + product_money +
                ", product_cost=" + product_cost +
                '}';
    }
}
