package com.class1804.democustomer.pojo;

//产品类别表
public class Product_category {

    private int pc_id;          //产品类别id，主键，唯一标识
    private String pc_name;     //产品类别名称（欧式，韩式，中国风，写真，婚纱）


    public int getPc_id() {
        return pc_id;
    }

    public void setPc_id(int pc_id) {
        this.pc_id = pc_id;
    }

    public String getPc_name() {
        return pc_name;
    }

    public void setPc_name(String pc_name) {
        this.pc_name = pc_name;
    }

    @Override
    public String toString() {
        return "Product_category{" +
                "pc_id=" + pc_id +
                ", pc_name='" + pc_name + '\'' +
                '}';
    }
}
