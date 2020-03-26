package com.class1804.democustomer.pojo;

/**
 * 线索更新表
 */
public class ClueUpdate {

    private int clueupdate_id ;         //线索更新id
    private String clueupdate_name ;    //线索更新介绍
    private String clueupdate_date ;    //线索更新时间
    private int clueupdate_userid ;     //线索更新人，对应员工表
    private String clueupdate_state;    //线索当前状态
    private int clueupdate_clueid ;     //线索id，对应线索表

    @Override
    public String toString() {
        return "ClueUpdateDao{" +
                "clueupdate_id=" + clueupdate_id +
                ", clueupdate_name='" + clueupdate_name + '\'' +
                ", clueupdate_date='" + clueupdate_date + '\'' +
                ", clueupdate_userid=" + clueupdate_userid +
                ", clueupdate_state='" + clueupdate_state + '\'' +
                ", clueupdate_clueid=" + clueupdate_clueid +
                '}';
    }

    public int getClueupdate_id() {
        return clueupdate_id;
    }

    public void setClueupdate_id(int clueupdate_id) {
        this.clueupdate_id = clueupdate_id;
    }

    public String getClueupdate_name() {
        return clueupdate_name;
    }

    public void setClueupdate_name(String clueupdate_name) {
        this.clueupdate_name = clueupdate_name;
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

    public int getClueupdate_clueid() {
        return clueupdate_clueid;
    }

    public void setClueupdate_clueid(int clueupdate_clueid) {
        this.clueupdate_clueid = clueupdate_clueid;
    }
}
