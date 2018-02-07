package com.dly.pay.service;

import com.dly.pay.base.Result;
import com.dly.pay.entity.TUserBankcard;
import com.dly.pay.vo.UserInfoInput;

public interface BankCardService {
	
	public Result getBankCardByUserId(UserInfoInput input);
	public  Result checkCardIsBindChannel( TUserBankcard input);
}
