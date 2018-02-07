package com.dly.pay.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.dly.pay.base.Result;
import com.dly.pay.service.SmsService;


/**
 * 短信发送接口
 * @author 12622
 *
 */
@RestController
@RequestMapping(value="/api/sms")
public class SmsController  {
	@Resource
	private SmsService smsService;
	private static Logger log = Logger.getLogger(SmsController.class);
	@GetMapping(value="shortMessage",produces = "application/json;charset=UTF-8")
	public Object  shortMessage( String phone){
		 Result result= smsService.sendSms(phone);
		 String json=JSONObject.toJSONString(result);
			return json;
	}
	
}