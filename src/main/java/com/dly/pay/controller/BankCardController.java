package com.dly.pay.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dly.pay.base.Result;
import com.dly.pay.entity.TUserBankcard;
import com.dly.pay.service.BankCardService;
import com.dly.pay.vo.CheckCardFourElementsInput;
import com.dly.pay.vo.UserInfoInput;

@RestController
@RequestMapping("api/bankCard")
public class BankCardController {
	@Resource
	BankCardService bankCardService;
	//获取用户所有银行卡
	@GetMapping(value="",produces = "application/json;charset=UTF-8")
	public Result getBankCardByUserId(UserInfoInput input) {
		return bankCardService.getBankCardByUserId(input);
	}
	//检查银行卡是否绑定通道
	@PostMapping(value="checkCardIsBindChannel",produces = "application/json;charset=UTF-8")
	public  Result checkCardIsBindChannel(@RequestBody TUserBankcard input) {
		return bankCardService.checkCardIsBindChannel(input);
	}
	//绑定信用卡
	@PostMapping(value="bindCreditCard",produces = "application/json;charset=UTF-8")
	public  Result bindCreditCard(@RequestBody CheckCardFourElementsInput input) {
		return bankCardService.bindCreditCard(input);
	}
	
		
	
}
