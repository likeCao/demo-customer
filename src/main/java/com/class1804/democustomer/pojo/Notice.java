package com.class1804.democustomer.pojo;

//公告栏
public class Notice {

    private int notice_id;          //公告栏id
    private String notice_name;     //公告栏建议介绍
    private String notice_text;     //公告栏内容
    private int notice_userid;      //发布人，对应员工表
    private int notice_type;        //公告类型（1-日，2-周，3-月，4-年）


    public int getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(int notice_id) {
        this.notice_id = notice_id;
    }

    public String getNotice_name() {
        return notice_name;
    }

    public void setNotice_name(String notice_name) {
        this.notice_name = notice_name;
    }

    public String getNotice_text() {
        return notice_text;
    }

    public void setNotice_text(String notice_text) {
        this.notice_text = notice_text;
    }

    public int getNotice_userid() {
        return notice_userid;
    }

    public void setNotice_userid(int notice_userid) {
        this.notice_userid = notice_userid;
    }

    public int getNotice_type() {
        return notice_type;
    }

    public void setNotice_type(int notice_type) {
        this.notice_type = notice_type;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "notice_id=" + notice_id +
                ", notice_name='" + notice_name + '\'' +
                ", notice_text='" + notice_text + '\'' +
                ", notice_userid=" + notice_userid +
                ", notice_type=" + notice_type +
                '}';
    }
}
