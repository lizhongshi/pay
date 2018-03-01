package com.dly.pay.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.dly.pay.base.Result;
import com.dly.pay.entity.TUserBankcard;
import com.dly.pay.vo.CheckCardFourElementsInput;
import com.dly.pay.vo.UserInfoInput;

public interface BankCardService {
	
	public Result getBankCardByUserId(UserInfoInput input);
	public  Result checkCardIsBindChannel( TUserBankcard input);
	public  Result bindCreditCard( CheckCardFourElementsInput input);
}
