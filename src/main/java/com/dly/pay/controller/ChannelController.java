package com.dly.pay.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dly.pay.base.Result;
import com.dly.pay.service.ChannelService;
import com.dly.pay.vo.OpenQuickPayInput;
import com.dly.pay.vo.PlaceOrderInput;
import com.dly.pay.vo.UserInfoInput;

@RestController
@RequestMapping("api/channel")
public class ChannelController {
	@Resource
	ChannelService channelService;
	//获取通道列表
	@GetMapping(value="",produces = "application/json;charset=UTF-8")
	public  Result getChannel( UserInfoInput input) {
		return channelService.getChannel(input);
	}
	//开通快捷支付
	@PostMapping(value="openQuickPay",produces = "application/json;charset=UTF-8")
	public  Result openQuickPay(@RequestBody OpenQuickPayInput input) {
		return channelService.openQuickPay(input);
	}
	//下单
	@PostMapping(value="placeOrder",produces = "application/json;charset=UTF-8")
	public  Result placeOrder(@RequestBody PlaceOrderInput input) {
		return channelService.placeOrder(input);
	}
	//检查额度
	@PostMapping(value="checkQuota",produces = "application/json;charset=UTF-8")
	public Result checkQuota(PlaceOrderInput input) {
		return channelService.checkQuota(input);
	}
	
}
