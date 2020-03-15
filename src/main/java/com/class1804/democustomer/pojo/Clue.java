package com.class1804.democustomer.pojo;

import java.sql.Timestamp;

//客户线索表
public class Clue {

    private int clue_id;            //客户线索id
    private int clue_name;          //可以重复，是客户线索的标识（客户id+第一条线索id）
    private String clue_state;      //线索状态
    private String clue_content;    //跟进情况详细介绍
    private int clue_userid;        //跟进员工id。对应员工表
    private Timestamp clue_date;    //此次跟进时间
    private int clue_custome;       //客户id，对应客户表
    private int clue_product;       //产品id，对应产品表


    public int getClue_id() {
        return clue_id;
    }

    public void setClue_id(int clue_id) {
        this.clue_id = clue_id;
    }

    public int getClue_name() {
        return clue_name;
    }

    public void setClue_name(int clue_name) {
        this.clue_name = clue_name;
    }

    public String getClue_state() {
        return clue_state;
    }

    public void setClue_state(String clue_state) {
        this.clue_state = clue_state;
    }

    public String getClue_content() {
        return clue_content;
    }

    public void setClue_content(String clue_content) {
        this.clue_content = clue_content;
    }

    public int getClue_userid() {
        return clue_userid;
    }

    public void setClue_userid(int clue_userid) {
        this.clue_userid = clue_userid;
    }

    public Timestamp getClue_date() {
        return clue_date;
    }

    public void setClue_date(Timestamp clue_date) {
        this.clue_date = clue_date;
    }

    public int getClue_custome() {
        return clue_custome;
    }

    public void setClue_custome(int clue_custome) {
        this.clue_custome = clue_custome;
    }

    public int getClue_product() {
        return clue_product;
    }

    public void setClue_product(int clue_product) {
        this.clue_product = clue_product;
    }

    @Override
    public String toString() {
        return "Clue{" +
                "clue_id=" + clue_id +
                ", clue_name=" + clue_name +
                ", clue_state='" + clue_state + '\'' +
                ", clue_content='" + clue_content + '\'' +
                ", clue_userid=" + clue_userid +
                ", clue_date=" + clue_date +
                ", clue_custome=" + clue_custome +
                ", clue_product=" + clue_product +
                '}';
    }
}
