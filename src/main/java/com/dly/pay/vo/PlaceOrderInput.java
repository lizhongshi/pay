package com.dly.pay.vo;

public class PlaceOrderInput {
	private String userId;
	private Integer channelId;
	private String phone;
	private Integer cardId;
	private String jyje;
	private String shbh;
	private String grbh;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getCardId() {
		return cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public String getJyje() {
		return jyje;
	}
	public void setJyje(String jyje) {
		this.jyje = jyje;
	}
	public String getShbh() {
		return shbh;
	}
	public void setShbh(String shbh) {
		this.shbh = shbh;
	}
	public String getGrbh() {
		return grbh;
	}
	public void setGrbh(String grbh) {
		this.grbh = grbh;
	}
	

}
