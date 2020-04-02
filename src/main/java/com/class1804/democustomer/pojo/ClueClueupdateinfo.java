package com.class1804.democustomer.pojo;

public class ClueClueupdateinfo {
    private Integer clue_id;//线索名称
    private String clue_content;//线索介绍
    private String CuName;//负责人
    private String CluName;//此次跟进人
    private String CcName;//客户名称
    private String PName;//产品名称
    private String clue_date;//线索创建日期
    private String clueupdate_date;//线索更新日期
    private String clueupdate_name;//线索更新介绍
    private String clueupdate_state;//线索当前状态

    public Integer getClue_id() {
        return clue_id;
    }

    public void setClue_id(Integer clue_id) {
        this.clue_id = clue_id;
    }

    public String getClue_content() {
        return clue_content;
    }

    public void setClue_content(String clue_content) {
        this.clue_content = clue_content;
    }

    public String getCuName() {
        return CuName;
    }

    public void setCuName(String cuName) {
        CuName = cuName;
    }

    public String getCluName() {
        return CluName;
    }

    public void setCluName(String cluName) {
        CluName = cluName;
    }

    public String getCcName() {
        return CcName;
    }

    public void setCcName(String ccName) {
        CcName = ccName;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public String getClue_date() {
        return clue_date;
    }

    public void setClue_date(String clue_date) {
        this.clue_date = clue_date;
    }

    public String getClueupdate_date() {
        return clueupdate_date;
    }

    public void setClueupdate_date(String clueupdate_date) {
        this.clueupdate_date = clueupdate_date;
    }

    public String getClueupdate_name() {
        return clueupdate_name;
    }

    public void setClueupdate_name(String clueupdate_name) {
        this.clueupdate_name = clueupdate_name;
    }

    public String getClueupdate_state() {
        return clueupdate_state;
    }

    public void setClueupdate_state(String clueupdate_state) {
        this.clueupdate_state = clueupdate_state;
    }

    @Override
    public String toString() {
        return "ClueClueupdateinfo{" +
                "clue_id=" + clue_id +
                ", clue_content='" + clue_content + '\'' +
                ", CuName='" + CuName + '\'' +
                ", CluName='" + CluName + '\'' +
                ", CcName='" + CcName + '\'' +
                ", PName='" + PName + '\'' +
                ", clue_date='" + clue_date + '\'' +
                ", clueupdate_date='" + clueupdate_date + '\'' +
                ", clueupdate_name='" + clueupdate_name + '\'' +
                ", clueupdate_state='" + clueupdate_state + '\'' +
                '}';
    }
}
