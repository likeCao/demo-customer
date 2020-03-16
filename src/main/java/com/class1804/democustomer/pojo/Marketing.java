package com.class1804.democustomer.pojo;

//营销表
public class Marketing {

    private int marketing_id;               //营销表id，唯一标识，主键
    private String marketing_start;         //营销开始时间
    private String market_stop;             //营销结束时间
    private String marketing_name;          //营销活动名称
    private int marketing_userid;           //营销活动负责人，对应员工表
    private String marketing_introduce;     //营销活动介绍
    private Double marketing_money;         //营销活动消费金额
    private int marketing_product;          //营销产品id，对应产品表
    private Double promoney;                //营销之后的价格（折扣）


    public int getMarketing_id() {
        return marketing_id;
    }

    public void setMarketing_id(int marketing_id) {
        this.marketing_id = marketing_id;
    }

    public String getMarketing_start() {
        return marketing_start;
    }

    public void setMarketing_start(String marketing_start) {
        this.marketing_start = marketing_start;
    }

    public String getMarket_stop() {
        return market_stop;
    }

    public void setMarket_stop(String market_stop) {
        this.market_stop = market_stop;
    }

    public String getMarketing_name() {
        return marketing_name;
    }

    public void setMarketing_name(String marketing_name) {
        this.marketing_name = marketing_name;
    }

    public int getMarketing_userid() {
        return marketing_userid;
    }

    public void setMarketing_userid(int marketing_userid) {
        this.marketing_userid = marketing_userid;
    }

    public String getMarketing_introduce() {
        return marketing_introduce;
    }

    public void setMarketing_introduce(String marketing_introduce) {
        this.marketing_introduce = marketing_introduce;
    }

    public Double getMarketing_money() {
        return marketing_money;
    }

    public void setMarketing_money(Double marketing_money) {
        this.marketing_money = marketing_money;
    }

    public int getMarketing_product() {
        return marketing_product;
    }

    public void setMarketing_product(int marketing_product) {
        this.marketing_product = marketing_product;
    }

    public Double getPromoney() {
        return promoney;
    }

    public void setPromoney(Double promoney) {
        this.promoney = promoney;
    }

    @Override
    public String toString() {
        return "Marketing{" +
                "marketing_id=" + marketing_id +
                ", marketing_start=" + marketing_start +
                ", market_stop=" + market_stop +
                ", marketing_name='" + marketing_name + '\'' +
                ", marketing_userid=" + marketing_userid +
                ", marketing_introduce='" + marketing_introduce + '\'' +
                ", marketing_money=" + marketing_money +
                ", marketing_product=" + marketing_product +
                ", promoney=" + promoney +
                '}';
    }
}
