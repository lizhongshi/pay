package com.dly.pay.base;

public enum RegisterMessage {
	NOFIND_REFEREE("推荐人无效"),
	USER_REPEAT("此手机号已注册"),
	SUCCESS("注册成功"),
	VERIFICATION_CODE("验证码错误"),
	ERROR("注册失败");
	
	private String message;

	private RegisterMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
