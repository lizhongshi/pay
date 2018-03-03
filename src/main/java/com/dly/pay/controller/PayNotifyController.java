package com.dly.pay.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.dly.pay.service.PayNotifyService;

/**
 * 支付异步通知
 * @author 12622
 *
 */
@RestController
@RequestMapping("payNotify")
public class PayNotifyController  {
	@Resource
	PayNotifyService payNotifyService;

	@PostMapping(value="order",produces = "application/json;charset=UTF-8")
	//@ResponseBody
	public String  payNotify(@RequestBody JSONObject json) {
		try {
			return payNotifyService.PayNotify(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		
	}
	
	@PostMapping(value="payInfo.do",produces = "application/json;charset=UTF-8")
	//@ResponseBody
	public String  payInfo(@RequestBody JSONObject json) {
		System.out.println("支付异步:"+json);
		return "success";
	}

	

}
