package com.dly.pay.service.impl;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.dly.pay.base.ChannelMessage;
import com.dly.pay.base.PayRequest;
import com.dly.pay.base.Result;
import com.dly.pay.dao.TChannelMapper;
import com.dly.pay.dao.TOrderMapper;
import com.dly.pay.dao.TUserBankcardMapper;
import com.dly.pay.dao.TUserChannelMapper;
import com.dly.pay.entity.OpenQuickpay;
import com.dly.pay.entity.TChannel;
import com.dly.pay.entity.TOrder;
import com.dly.pay.entity.TOrderExample;
import com.dly.pay.entity.TUserBankcard;
import com.dly.pay.entity.TUserBankcardExample;
import com.dly.pay.entity.TUserChannel;
import com.dly.pay.service.ChannelService;
import com.dly.pay.service.IDGeneratedService;
import com.dly.pay.util.DESede;
import com.dly.pay.vo.OpenQuickPayInput;
import com.dly.pay.vo.PlaceOrderInput;
import com.dly.pay.vo.UserInfoInput;
@Service
public class ChannelServiceImpl implements ChannelService{
	@Resource
	TChannelMapper tChannelMapper;
	@Resource
	TUserChannelMapper  tUserChannelMapper;
	@Resource
	TOrderMapper tOrderMapper;
	@Resource
	PayRequest payRequest;
	@Resource
	TUserBankcardMapper tUserBankcardMapper;
	@Resource(name="orderIDGenerated")
	IDGeneratedService iDGeneratedService;
	private Logger log=Logger.getLogger(ChannelServiceImpl.class);
	@Value("${sign.dataKey}")
	private String Sign;
	@Value("${notify.Htmlurl}")
	private String Htmlurl;
	@Value("${notify.notifyUrl}")
	private String notifyUrl;
	
	@Override
	public Result getChannel(UserInfoInput input) {
		List<TChannel> result =tChannelMapper.getChannelAndUserId(input.getUserId());
		return new Result(true,"",result);
	}
	@Override
	public Result openQuickPay(OpenQuickPayInput input) {
		OpenQuickpay userInfo = tUserChannelMapper.getUserInfo(input);
		if(userInfo!=null) {
			switch (input.getChannelId()) {
			case 1:{
				Map<String, String> body=new TreeMap<String, String>();
				body.put("merchNo", userInfo.getShbh());
				body.put("userName", userInfo.getUserName());
				body.put("userIdentity",userInfo.getIdCard());
				body.put("userCardNo", userInfo.getCardNo());//储蓄卡卡号
				body.put("userPhone", userInfo.getPhone());
				body.put("userAddress", userInfo.getAddress());
				body.put("hasPoint", userInfo.getIsjf()?"1":"0");//是否积分
				body.put("payRateD0plus", "0");
				body.put("noPointPayRate", "0");
				body.put("hasPointPayRate", String.valueOf(Integer.valueOf((int) (userInfo.getRate()*100))));
				body.put("settleExtraFee",String.valueOf(Integer.valueOf((int) (userInfo.getDbsxf()*100))));
				log.info("开通快捷支付参数"+body);
				JSONObject res=JSONObject.parseObject(payRequest.payPost("http://47.94.208.216:8080/app/doQuickMerchantRegister.do", body));
				log.info("开通快捷支付返回:"+res.toJSONString());
				String respCode=res.getString("respCode");
				String respDesc=res.getString("respDesc");
				 if(respCode!=null&&respCode.equals("00000")) {  //成功
					 JSONObject result=new JSONObject();
					 String subMerchNo=res.getString("subMerchNo");
					 TUserChannel tUserChannel = new TUserChannel();
					 tUserChannel.setRate(userInfo.getRate());
					 tUserChannel.setGrbh(subMerchNo);
					 tUserChannel.setChannelId(input.getChannelId());
					 tUserChannel.setBankcardId(input.getCardId());
					int i= tUserChannelMapper.insert(tUserChannel);
					if(i>0) {
						result.put("grbh", subMerchNo);
						return new Result(true,respDesc,result);
					}else {
						return new Result(false,ChannelMessage.LOCAL_DATA_UPDATE_ERROR.getMessage());
					}
				 }else {//失败
					 return new Result(false,respDesc);
				 }
			}
			default:{
				return new Result(false,ChannelMessage.NOT_FIND.getMessage());
			}	
			}
		}else {
			return new Result(false,ChannelMessage.ERROR.getMessage());
		}
		
	}
	@Override
	public Result placeOrder(PlaceOrderInput input) {
		switch (input.getChannelId()) {
		case 1:{
			TUserBankcard selectByPrimaryKey = tUserBankcardMapper.selectByPrimaryKey(input.getCardId());
			String orderId= iDGeneratedService.increase();
			Map<String, String> body=new TreeMap<String, String>();
			body.put("merchNo", input.getShbh());
			body.put("subMerchNo", input.getGrbh());
			body.put("orderNo", orderId);
			body.put("notifyUrl", notifyUrl);
			body.put("pageUrl", Htmlurl);
			body.put("transAmount", String.valueOf(Integer.valueOf((int) (Double.valueOf(input.getJyje())*100))));
			String cardInfo= DESede.encode(selectByPrimaryKey.getCardNo()+"-"+selectByPrimaryKey.getPhone(),Sign);//加密
			body.put("cardInfo", cardInfo);
			log.info("请求下单参数:"+body);
			JSONObject res=JSONObject.parseObject(payRequest.payPost("http://47.94.208.216:8080/app/doQuickMerchantPay.do", body));
			log.info("请求下单返回:"+res.toJSONString());
			String respCode=res.getString("respCode");
			String respDesc=res.getString("respDesc");
			if(respCode!=null&&respCode.equals("00000")) {  //成功
				TUserBankcardExample example = new TUserBankcardExample();
				example.createCriteria().andCardTypeEqualTo("1");//储蓄卡
				List<TUserBankcard> selectByExample = tUserBankcardMapper.selectByExample(example);
				TOrder tOrder = new TOrder();
				tOrder.setCardNo(selectByPrimaryKey.getCardNo());
				tOrder.setChannelId(input.getChannelId());
				tOrder.setDzCardNo(selectByExample.get(0).getCardNo());
				tOrder.setGrbh(input.getGrbh());
				DecimalFormat df = new DecimalFormat("#.00");//保留两位小数
				tOrder.setJyje(df.format(Double.valueOf(input.getJyje())));
				tOrder.setOrderId(orderId);
				tOrder.setIsdz(false);
				tOrder.setIszf(false);
				tOrder.setPayStatus("0");//0未支付 1支付成功 2支付失败 
				tOrder.setPhone(selectByPrimaryKey.getPhone());
				tOrder.setShbh(input.getShbh());
				tOrder.setUserId(input.getUserId());
				int i=tOrderMapper.insert(tOrder);
				if(i>0) {
					JSONObject result=new JSONObject();
					result.put("returnHtml", res.getString("returnHtml"));
					return new Result(true,respDesc,result);
				}else {
					return new Result(false,ChannelMessage.LOCAL_DATA_UPDATE_ERROR.getMessage());
				}
			 }else {//失败
				 return new Result(false,respDesc);
			 }
			
		}
		}
		return new Result(false,ChannelMessage.NOT_FIND.getMessage());
	}
	@Override
	public Result checkQuota(PlaceOrderInput input) {
		TOrderExample example=new TOrderExample();
		example.createCriteria()
		.andUserIdEqualTo(input.getUserId())
		.andChannelIdEqualTo(input.getChannelId())
		.andIszfEqualTo(true)
		.andPayStatusEqualTo("1")
		
		;
		tOrderMapper.selectByExample(example);
		return null;
	}
	

}
