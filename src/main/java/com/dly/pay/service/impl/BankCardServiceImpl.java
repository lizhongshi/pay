package com.dly.pay.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.api.gateway.demo.util.HttpUtils;
import com.dly.pay.base.Result;
import com.dly.pay.dao.TUserBankcardMapper;
import com.dly.pay.dao.TUserChannelMapper;
import com.dly.pay.entity.TUserBankcard;
import com.dly.pay.entity.TUserBankcardExample;
import com.dly.pay.entity.TUserChannel;
import com.dly.pay.entity.TUserChannelExample;
import com.dly.pay.service.BankCardService;
import com.dly.pay.vo.CheckCardFourElementsInput;
import com.dly.pay.vo.UserInfoInput;
@Service
public class BankCardServiceImpl implements BankCardService {
	@Value(value = "${bank.host}")
	private String host;
	@Value(value = "${bank.path}")
	private String path;
	@Value(value = "${bank.appcode}")
	private String appcode ;
	@Resource
	TUserBankcardMapper tUserBankcardMapper;
	@Resource
	TUserChannelMapper tUserChannelMapper;
	@Override
	public Result getBankCardByUserId(UserInfoInput input) {
		TUserBankcardExample tUserBankExample = new TUserBankcardExample(); 
		tUserBankExample.createCriteria()
		.andUserIdEqualTo(input.getUserId())
		.andStautsEqualTo("0")
		.andCardTypeEqualTo("信用卡");//未删除的卡
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
	@Override
	public Result bindCreditCard(CheckCardFourElementsInput input) {
		Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    //根据API的要求，定义相对应的Content-Type
	    headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
	    Map<String, String> querys = new HashMap<String, String>();
	    Map<String, String> bodys = new HashMap<String, String>();
	    bodys.put("ReturnBankInfo", "YES");
	    bodys.put("cardNo", input.getCardNo());
	    bodys.put("idNo", input.getIdNo());
	    bodys.put("name", input.getName());
	    bodys.put("phoneNo", input.getPhoneNo());
	    HttpResponse response;
		try {
			response = HttpUtils.doPost(host, path, "POST", headers, querys, bodys);
    	JSONObject resJson=JSONObject.parseObject(EntityUtils.toString(response.getEntity()));
    	if(response.getStatusLine().getStatusCode()==200) {//判断http状态
    		String name=resJson.getString("name");
   	     String phoneNo=resJson.getString("phoneNo");
   	     String cardNo=resJson.getString("cardNo");
   	     String idNo=resJson.getString("idNo");
   	     String respMessage=resJson.getString("respMessage");
   	     String respCode=resJson.getString("respCode");
   	     String bankName=resJson.getString("bankName");
   	     String bankKind=resJson.getString("bankKind");
   	     String bankType=resJson.getString("bankType");
   	     String bankCode=resJson.getString("bankCode");	
   	     if(respCode.equals("0000")) {//判断是否匹配
   	    	 TUserBankcard tUserBankcard=new TUserBankcard();
   	    	 	tUserBankcard.setUserId(input.getUserId());
   	    	 	tUserBankcard.setCardNo(cardNo);
   	    	 	tUserBankcard.setCardLen(String.valueOf(cardNo.length()));
   	    	 	tUserBankcard.setBankName(bankName);
   	    	 	tUserBankcard.setBankNo(bankCode);
   	    	 	tUserBankcard.setCardName(bankKind);
   	    	 	tUserBankcard.setCardType(bankType);
   	    	 	tUserBankcard.setPhone(phoneNo);
   	    	 	tUserBankcard.setStauts("0");//0:正常 1:删除
   	    	 	//注册结算卡
   	    	 	TUserBankcardExample tUserBankcardExample =new TUserBankcardExample();
   	    	 	tUserBankcardExample.createCriteria().andCardNoEqualTo(cardNo);
   	    	 	List<TUserBankcard> selectByExample = tUserBankcardMapper.selectByExample(tUserBankcardExample);
   	    	 	if(selectByExample.size()<1) {
   	    	 		int insert = tUserBankcardMapper.insert(tUserBankcard);  
   	    	 		if(insert>0) {
   	    	 			return new Result(true,"绑定成功");
   	    	 		}else {
   	    	 		return new Result(false,"绑定失败");
   	    	 		}
   	    	 	}else {
   	    	 	return new Result(false,"绑定失败,此卡已绑定");
   	    	 	}
   	     }
    	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result(false,"绑定失败");
		}
		return new Result(false,"绑定失败");
		
	}

}
