package com.dly.pay.entity;

import java.util.Date;

public class TOrder {
    private String orderId;

    private String userId;

    private Date creationTime;

    private String jyje;

    private Date payTime;

    private String payStatus;

    private Integer channelId;

    private String cardNo;

    private String phone;

    private String grbh;

    private String shbh;

    private String dzCardNo;

    private Boolean iszf;

    private Boolean isdz;

    private Date dzTime;

    private String dzStatus;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getJyje() {
        return jyje;
    }

    public void setJyje(String jyje) {
        this.jyje = jyje == null ? null : jyje.trim();
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getGrbh() {
        return grbh;
    }

    public void setGrbh(String grbh) {
        this.grbh = grbh == null ? null : grbh.trim();
    }

    public String getShbh() {
        return shbh;
    }

    public void setShbh(String shbh) {
        this.shbh = shbh == null ? null : shbh.trim();
    }

    public String getDzCardNo() {
        return dzCardNo;
    }

    public void setDzCardNo(String dzCardNo) {
        this.dzCardNo = dzCardNo == null ? null : dzCardNo.trim();
    }

    public Boolean getIszf() {
        return iszf;
    }

    public void setIszf(Boolean iszf) {
        this.iszf = iszf;
    }

    public Boolean getIsdz() {
        return isdz;
    }

    public void setIsdz(Boolean isdz) {
        this.isdz = isdz;
    }

    public Date getDzTime() {
        return dzTime;
    }

    public void setDzTime(Date dzTime) {
        this.dzTime = dzTime;
    }

    public String getDzStatus() {
        return dzStatus;
    }

    public void setDzStatus(String dzStatus) {
        this.dzStatus = dzStatus == null ? null : dzStatus.trim();
    }
}