package com.dly.pay.vo;

public class UserInfoInput {
		private String userId; 
		private String phone;
		private Integer project;//appid
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public Integer getProject() {
			return project;
		}
		public void setProject(Integer project) {
			this.project = project;
		}
		public UserInfoInput() {
			
		}
		public UserInfoInput(String userId, String phone, Integer project) {
			super();
			this.userId = userId;
			this.phone = phone;
			this.project = project;
		}
		@Override
		public String toString() {
			return "UserInfoInput [userId=" + userId + ", phone=" + phone + ", project=" + project + "]";
		}
		
	 
}
