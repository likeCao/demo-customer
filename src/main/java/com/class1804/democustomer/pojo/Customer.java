package com.class1804.democustomer.pojo;

import java.util.Date;

//客户表
public class Customer {

    private int customer_id;            //客户表id，客户唯一标识
    private String customer_name;       //客户姓名，可以重复
    private int customer_gender;        //客户性别，（0为女，1为男）
    private int customer_number;        //客户联系电话
    private int customer_userid;        //客户负责人，对应员工表
    private double customer_money;      //客户消费总金额，默认为0
    private int customer_jurisdiction;  //客户级别id，对应级别表
    private String customer_address;    //客户家庭住址
    private Date customer_birthday;     //客户生日
    private String customer_text;       //客户备注


    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getCustomer_gender() {
        return customer_gender;
    }

    public void setCustomer_gender(int customer_gender) {
        this.customer_gender = customer_gender;
    }

    public int getCustomer_number() {
        return customer_number;
    }

    public void setCustomer_number(int customer_number) {
        this.customer_number = customer_number;
    }

    public int getCustomer_userid() {
        return customer_userid;
    }

    public void setCustomer_userid(int customer_userid) {
        this.customer_userid = customer_userid;
    }

    public double getCustomer_money() {
        return customer_money;
    }

    public void setCustomer_money(double customer_money) {
        this.customer_money = customer_money;
    }

    public int getCustomer_jurisdiction() {
        return customer_jurisdiction;
    }

    public void setCustomer_jurisdiction(int customer_jurisdiction) {
        this.customer_jurisdiction = customer_jurisdiction;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public Date getCustomer_birthday() {
        return customer_birthday;
    }

    public void setCustomer_birthday(Date customer_birthday) {
        this.customer_birthday = customer_birthday;
    }

    public String getCustomer_text() {
        return customer_text;
    }

    public void setCustomer_text(String customer_text) {
        this.customer_text = customer_text;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", customer_name='" + customer_name + '\'' +
                ", customer_gender=" + customer_gender +
                ", customer_number=" + customer_number +
                ", customer_userid=" + customer_userid +
                ", customer_money=" + customer_money +
                ", customer_jurisdiction=" + customer_jurisdiction +
                ", customer_address='" + customer_address + '\'' +
                ", customer_birthday=" + customer_birthday +
                ", customer_text='" + customer_text + '\'' +
                '}';
    }
}
