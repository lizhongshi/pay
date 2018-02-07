package com.dly.pay.base;

public enum ChannelMessage {
	LOCAL_DATA_UPDATE_ERROR("本地数据更新失败"),
	NOT_FIND("未找到该通道"),
	ERROR("开通快捷支付失败"),
	SUCCESS("开通快捷支付成功");
	
	private String message;

	private ChannelMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
