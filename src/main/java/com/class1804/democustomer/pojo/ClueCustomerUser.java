package com.class1804.democustomer.pojo;

public class ClueCustomerUser {
    private  Integer customer_id;//客户id
    private String customer_name;//客户名字
    private Integer customer_jurisdiction;//客户等级
    private  Integer customer_gender;//客户性别
    private String customer_number;//手机号

    @Override
    public String toString() {
        return "ClueCustomerUser{" +
                "customer_id=" + customer_id +
                ", customer_name='" + customer_name + '\'' +
                ", customer_jurisdiction=" + customer_jurisdiction +
                ", customer_gender=" + customer_gender +
                ", customer_number='" + customer_number + '\'' +
                ", customer_text='" + customer_text + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }

    public Integer getCustomer_jurisdiction() {
        return customer_jurisdiction;
    }

    public void setCustomer_jurisdiction(Integer customer_jurisdiction) {
        this.customer_jurisdiction = customer_jurisdiction;
    }

    private String customer_text;//备注
    private String user_name;//负责人名字

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Integer getCustomer_gender() {
        return customer_gender;
    }

    public void setCustomer_gender(Integer customer_gender) {
        this.customer_gender = customer_gender;
    }

    public String getCustomer_number() {
        return customer_number;
    }

    public void setCustomer_number(String customer_number) {
        this.customer_number = customer_number;
    }

    public String getCustomer_text() {
        return customer_text;
    }

    public void setCustomer_text(String customer_text) {
        this.customer_text = customer_text;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

}
