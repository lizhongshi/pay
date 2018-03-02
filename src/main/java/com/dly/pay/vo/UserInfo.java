package com.dly.pay.vo;

public class UserInfo {
	 String userId;
	 Integer project;//appid
	 private String phone;
	 private String iconUrl;
	 private Integer level;
	 private Double frzj;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	public Double getFrzj() {
		return frzj;
	}
	public void setFrzj(Double frzj) {
		this.frzj = frzj;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getProject() {
		return project;
	}
	public void setProject(Integer project) {
		this.project = project;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", project=" + project + "]";
	}
	
	 
}
