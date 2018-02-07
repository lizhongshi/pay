package com.dly.pay.base;

public enum ChangeUserInfoMessage {
	OLD_PASSWORD_ERROR("密码错误"),
	PASSWORD_ERROR("密码修改失败"),
	PASSWORD_SUCCESS("修改成功"),
	PHONE_YZM_ERROR("验证码错误"),
	PHONE_ERROR("手机号修改失败"),
	PHONE_SUCCESS("修改成功"),
	RESET_PASSWORD_ERROR("密码重置失败"),
	RESET_PASSWORD_SUCCESS("密码重置成功");
	
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	ChangeUserInfoMessage(String message) {
		this.message=message;
	}
}
