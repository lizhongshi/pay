package com.dly.pay.vo;


public class RegisterInput {
	

	    private String phone;

	    private String nickName;

	    private String password;

	    private String referee; //推荐人

	    private Integer project;//appid
	   
	    private String verificationCode;//验证码

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getNickName() {
			return nickName;
		}

		public void setNickName(String nickName) {
			this.nickName = nickName;
		}

	
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getReferee() {
			return referee;
		}

		public void setReferee(String referee) {
			this.referee = referee;
		}

		public Integer getProject() {
			return project;
		}

		public void setProject(Integer project) {
			this.project = project;
		}

		public String getVerificationCode() {
			return verificationCode;
		}

		public void setVerificationCode(String verificationCode) {
			this.verificationCode = verificationCode;
		}
	    
	    
}
