package com.class1804.democustomer.pojo;

//级别表
public class Jurisdiction {

    private int j_id;               //级别表id，唯一标识
    private int j_classification;   //级别表分类（用于指定是员工级别还是客户级别，员工为1，客户为2）
    private String j_name;          //级别名称（普通员工，大堂经理，店长/普通客户，白银客户，黄金客户，钻石客户）


    public int getJ_id() {
        return j_id;
    }

    public void setJ_id(int j_id) {
        this.j_id = j_id;
    }

    public int getJ_classification() {
        return j_classification;
    }

    public void setJ_classification(int j_classification) {
        this.j_classification = j_classification;
    }

    public String getJ_name() {
        return j_name;
    }

    public void setJ_name(String j_name) {
        this.j_name = j_name;
    }

    @Override
    public String toString() {
        return "Jurisdiction{" +
                "j_id=" + j_id +
                ", j_classification=" + j_classification +
                ", j_name='" + j_name + '\'' +
                '}';
    }
}
