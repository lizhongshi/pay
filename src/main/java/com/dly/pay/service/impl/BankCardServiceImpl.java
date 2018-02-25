package com.dly.pay.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.dly.pay.base.Result;
import com.dly.pay.dao.TUserBankcardMapper;
import com.dly.pay.dao.TUserChannelMapper;
import com.dly.pay.entity.TUserBankcard;
import com.dly.pay.entity.TUserBankcardExample;
import com.dly.pay.entity.TUserChannel;
import com.dly.pay.entity.TUserChannelExample;
import com.dly.pay.service.BankCardService;
import com.dly.pay.vo.UserInfoInput;
@Service
public class BankCardServiceImpl implements BankCardService {
	
	@Resource
	TUserBankcardMapper tUserBankcardMapper;
	@Resource
	TUserChannelMapper tUserChannelMapper;
	@Override
	public Result getBankCardByUserId(UserInfoInput input) {
		TUserBankcardExample tUserBankExample = new TUserBankcardExample(); 
		tUserBankExample.createCriteria()
		.andUserIdEqualTo(input.getUserId())
		.andStautsEqualTo("0");//未删除的卡
		List<TUserBankcard> result = tUserBankcardMapper.selectByExample(tUserBankExample);
		for (TUserBankcard tUserBankcard : result) {
			tUserBankcard.setCardNo(tUserBankcard.getCardNo().substring(tUserBankcard.getCardNo().length()-4, tUserBankcard.getCardNo().length()));//银行卡截取后4位
			tUserBankcard.setPhone((tUserBankcard.getPhone().substring(tUserBankcard.getPhone().length()-4, tUserBankcard.getPhone().length())));//手机号截取后4位
		}
		return new Result(true,"",result);
	}
	@Override
	public Result checkCardIsBindChannel(TUserBankcard input) {
		TUserBankcardExample tUserBankExample = new TUserBankcardExample(); 
		tUserBankExample.createCriteria()
		.andUserIdEqualTo(input.getUserId())
		.andCardTypeEqualTo("借记卡")
		.andChannelEqualTo(input.getChannel());
		 List<TUserBankcard> result = tUserBankcardMapper.selectByExample(tUserBankExample);
		 JSONObject json =new JSONObject();
		 if(result.size()>0) {
			 json.put("isBind", true);
			TUserChannelExample tUserChannelExample = new TUserChannelExample();
			 List<TUserChannel> selectByExample = tUserChannelMapper.selectByExample(tUserChannelExample);
			 json.put("grbh", selectByExample.get(0).getGrbh());
			 return new Result(true,"",json);
		 }else {
			 json.put("isBind", false);
			 return new Result(true,"",json);
		 }
	}

}
