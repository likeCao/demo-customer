package com.class1804.democustomer.pojo;

//客户购买信息表
public class Customer_dynamic {

    private int cd_id;              //购买信息编号
    private String cd_content;      //购买信息介绍
    private int cd_customerid;      //客户id,对应客户表
    private int cd_userid;          //负责人id,对应员工表
    private int cd_productid;       //产品id,对应产品表
    private String cd_date;         //购买时间


    public int getCd_id() {
        return cd_id;
    }

    public void setCd_id(int cd_id) {
        this.cd_id = cd_id;
    }

    public String getCd_content() {
        return cd_content;
    }

    public void setCd_content(String cd_content) {
        this.cd_content = cd_content;
    }

    public int getCd_customerid() {
        return cd_customerid;
    }

    public void setCd_customerid(int cd_customerid) {
        this.cd_customerid = cd_customerid;
    }

    public int getCd_userid() {
        return cd_userid;
    }

    public void setCd_userid(int cd_userid) {
        this.cd_userid = cd_userid;
    }

    public int getCd_productid() {
        return cd_productid;
    }

    public void setCd_productid(int cd_productid) {
        this.cd_productid = cd_productid;
    }

    public String getCd_date() {
        return cd_date;
    }

    public void setCd_date(String cd_date) {
        this.cd_date = cd_date;
    }

    @Override
    public String toString() {
        return "Customer_dynamic{" +
                "cd_id=" + cd_id +
                ", cd_content='" + cd_content + '\'' +
                ", cd_customerid=" + cd_customerid +
                ", cd_userid=" + cd_userid +
                ", cd_productid=" + cd_productid +
                ", cd_date=" + cd_date +
                '}';
    }
}
