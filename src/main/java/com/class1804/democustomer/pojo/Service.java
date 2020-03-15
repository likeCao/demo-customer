package com.class1804.democustomer.pojo;

import java.sql.Timestamp;

//客户售后表
public class Service {

    private int Service_id;             //售后id
    private String Service_content;     //售后情况
    private Timestamp Service_date;     //售后时间
    private int Service_userid;         //处理员工id，对应员工表
    private int Service_Situation;      //售后评价，（1最低，5最高）
    private int Service_productid;      //售后相关产品，对应产品表


    public int getService_id() {
        return Service_id;
    }

    public void setService_id(int service_id) {
        Service_id = service_id;
    }

    public String getService_content() {
        return Service_content;
    }

    public void setService_content(String service_content) {
        Service_content = service_content;
    }

    public Timestamp getService_date() {
        return Service_date;
    }

    public void setService_date(Timestamp service_date) {
        Service_date = service_date;
    }

    public int getService_userid() {
        return Service_userid;
    }

    public void setService_userid(int service_userid) {
        Service_userid = service_userid;
    }

    public int getService_Situation() {
        return Service_Situation;
    }

    public void setService_Situation(int service_Situation) {
        Service_Situation = service_Situation;
    }

    public int getService_productid() {
        return Service_productid;
    }

    public void setService_productid(int service_productid) {
        Service_productid = service_productid;
    }

    @Override
    public String toString() {
        return "Service{" +
                "Service_id=" + Service_id +
                ", Service_content='" + Service_content + '\'' +
                ", Service_date=" + Service_date +
                ", Service_userid=" + Service_userid +
                ", Service_Situation=" + Service_Situation +
                ", Service_productid=" + Service_productid +
                '}';
    }
}
