package com.dly.pay.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.dly.pay.base.Result;
import com.dly.pay.entity.TUserBankcard;
import com.dly.pay.vo.OpenQuickPayInput;
import com.dly.pay.vo.PlaceOrderInput;
import com.dly.pay.vo.UserInfoInput;

public interface ChannelService {
	public  Result getChannel(UserInfoInput input);
	public  Result openQuickPay(OpenQuickPayInput input);
	public  Result placeOrder(PlaceOrderInput input);
	public  Result checkQuota(PlaceOrderInput input);
	
}
