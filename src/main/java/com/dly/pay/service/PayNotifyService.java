package com.dly.pay.service;

import com.alibaba.fastjson.JSONObject;

public interface PayNotifyService {
	public String PayNotify(JSONObject json)throws Exception;
	
}
