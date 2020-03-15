package com.class1804.democustomer.pojo;

import java.sql.Date;

//员工表
public class User {

    private int user_id;            //员工id，主键，自动增长，是员工的唯一标识（开始100001）
    private String user_name;       //员工姓名，不允许为Null，但是可以重复
    private int user_gender;        //员工性别（0为女，1为男）
    private Date user_birthday;     //员工出生日期，方便查询员工年龄、生日等
    private int user_jurisdiction;  //员工级别id，对应级别表
    private int user_number;        //员工联系电话
    private String user_address;    //员工住址
    private Double user_money;      //员工工资
    private int user_password;      //员工密码，初始密码是出生日期（20190516）
    private Date user_entry;        //入职时间


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(int user_gender) {
        this.user_gender = user_gender;
    }

    public Date getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(Date user_birthday) {
        this.user_birthday = user_birthday;
    }

    public int getUser_jurisdiction() {
        return user_jurisdiction;
    }

    public void setUser_jurisdiction(int user_jurisdiction) {
        this.user_jurisdiction = user_jurisdiction;
    }

    public int getUser_number() {
        return user_number;
    }

    public void setUser_number(int user_number) {
        this.user_number = user_number;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public Double getUser_money() {
        return user_money;
    }

    public void setUser_money(Double user_money) {
        this.user_money = user_money;
    }

    public int getUser_password() {
        return user_password;
    }

    public void setUser_password(int user_password) {
        this.user_password = user_password;
    }

    public Date getUser_entry() {
        return user_entry;
    }

    public void setUser_entry(Date user_entry) {
        this.user_entry = user_entry;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_gender=" + user_gender +
                ", user_birthday=" + user_birthday +
                ", user_jurisdiction=" + user_jurisdiction +
                ", user_number=" + user_number +
                ", user_address='" + user_address + '\'' +
                ", user_money=" + user_money +
                ", user_password=" + user_password +
                ", user_entry=" + user_entry +
                '}';
    }
}
