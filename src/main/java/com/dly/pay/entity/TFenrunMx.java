package com.dly.pay.entity;

import java.util.Date;

public class TFenrunMx {
    private Integer id;

    private Double fsje;

    private String userId;

    private String referee;

    private Date time;

    private Double jyje;

    private String ywlsh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getFsje() {
        return fsje;
    }

    public void setFsje(Double fsje) {
        this.fsje = fsje;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee == null ? null : referee.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getJyje() {
        return jyje;
    }

    public void setJyje(Double jyje) {
        this.jyje = jyje;
    }

    public String getYwlsh() {
        return ywlsh;
    }

    public void setYwlsh(String ywlsh) {
        this.ywlsh = ywlsh == null ? null : ywlsh.trim();
    }
}