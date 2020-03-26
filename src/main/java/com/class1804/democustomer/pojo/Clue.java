package com.class1804.democustomer.pojo;

//客户线索表
public class Clue {

    private int clue_id;            //客户线索id
    private String clue_content;    //线索介绍
    private int clue_userid;        //创建人id。对应员工表
    private String clue_date;       //创建时间
    private int clue_custome;       //客户id，对应客户表
    private int clue_product;       //产品id，对应产品表


    //连表查询
    private String clueupdate_date;     //线索更新时间
    private int clueupdate_userid;      //线索更新人
    private String clueupdate_state;       //线索当前状态


    @Override
    public String toString() {
        return "Clue{" +
                "clue_id=" + clue_id +
                ", clue_content='" + clue_content + '\'' +
                ", clue_userid=" + clue_userid +
                ", clue_date='" + clue_date + '\'' +
                ", clue_custome=" + clue_custome +
                ", clue_product=" + clue_product +
                '}';
    }

    public int getClue_id() {
        return clue_id;
    }

    public void setClue_id(int clue_id) {
        this.clue_id = clue_id;
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

    public String getClue_date() {
        return clue_date;
    }

    public void setClue_date(String clue_date) {
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








    public String getClueupdate_date() {
        return clueupdate_date;
    }

    public void setClueupdate_date(String clueupdate_date) {
        this.clueupdate_date = clueupdate_date;
    }

    public int getClueupdate_userid() {
        return clueupdate_userid;
    }

    public void setClueupdate_userid(int clueupdate_userid) {
        this.clueupdate_userid = clueupdate_userid;
    }

    public String getClueupdate_state() {
        return clueupdate_state;
    }

    public void setClueupdate_state(String clueupdate_state) {
        this.clueupdate_state = clueupdate_state;
    }
}
