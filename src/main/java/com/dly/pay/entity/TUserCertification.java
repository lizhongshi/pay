package com.dly.pay.entity;

import java.util.Date;

public class TUserCertification {
    private Integer id;

    private String idCard;

    private String userName;

    private String address;

    private String userId;

    private String status;

    private String shouchi1;

    private String shouchi2;

    private String sfz1;

    private String sfz2;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getShouchi1() {
        return shouchi1;
    }

    public void setShouchi1(String shouchi1) {
        this.shouchi1 = shouchi1 == null ? null : shouchi1.trim();
    }

    public String getShouchi2() {
        return shouchi2;
    }

    public void setShouchi2(String shouchi2) {
        this.shouchi2 = shouchi2 == null ? null : shouchi2.trim();
    }

    public String getSfz1() {
        return sfz1;
    }

    public void setSfz1(String sfz1) {
        this.sfz1 = sfz1 == null ? null : sfz1.trim();
    }

    public String getSfz2() {
        return sfz2;
    }

    public void setSfz2(String sfz2) {
        this.sfz2 = sfz2 == null ? null : sfz2.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}