package com.dly.pay.vo;

public class UserInfo {
	 String userId;
	 Integer project;//appid
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
