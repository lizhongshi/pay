package com.dly.pay.base;

public enum HttpSturts {
	http_401(401,"会话认证失败");
	private int code;
	private String message;
	HttpSturts(int code,String message){
		this.code=code;
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
