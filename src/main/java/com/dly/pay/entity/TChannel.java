package com.dly.pay.entity;

public class TChannel {
    private Integer channelId;

    private String name;

    private String rate;

    private String type;

    private Double dbsxf;

    private Double min;

    private Double max;

    private Double sum;

    private Boolean isjf;

    private String shbh;

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate == null ? null : rate.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Double getDbsxf() {
        return dbsxf;
    }

    public void setDbsxf(Double dbsxf) {
        this.dbsxf = dbsxf;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Boolean getIsjf() {
        return isjf;
    }

    public void setIsjf(Boolean isjf) {
        this.isjf = isjf;
    }

    public String getShbh() {
        return shbh;
    }

    public void setShbh(String shbh) {
        this.shbh = shbh == null ? null : shbh.trim();
    }
}