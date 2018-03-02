package com.dly.pay.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.api.gateway.demo.util.HttpUtils;
import com.dly.pay.base.Result;
import com.dly.pay.dao.TUserBankcardMapper;
import com.dly.pay.dao.TUserCertificationMapper;
import com.dly.pay.entity.TUserBankcard;
import com.dly.pay.entity.TUserBankcardExample;
import com.dly.pay.entity.TUserCertification;
import com.dly.pay.entity.TUserCertificationExample;
import com.dly.pay.service.RealNameAuthenticationService;
import com.dly.pay.util.RedisCacheUtil;
import com.dly.pay.vo.CheckCardFourElementsInput;
import com.dly.pay.vo.UploadImageInput;
import com.dly.pay.vo.UserInfo;
import com.dly.pay.vo.UserRealNameInfoOutput;
@Service
public class RealNameAuthenticationServiceImpl implements RealNameAuthenticationService{
	
	private  static final String SCSFZ="scsfz:"; 
	private  static final String SFZ="sfz:"; 
	 Logger log=Logger.getLogger(RealNameAuthenticationServiceImpl.class);
	@Value(value = "${bank.host}")
	private String host;
	@Value(value = "${bank.path}")
	private String path;
	@Value(value = "${bank.appcode}")
	private String appcode ;
	@Resource
	TUserBankcardMapper tUserBankcardMapper;
	@Resource
	TUserCertificationMapper tUserCertificationMapper;
	@Resource(name="transactionManager")  
    private DataSourceTransactionManager transactionManager;  
	@Resource
	RedisCacheUtil redisCacheUtil;
	@Override
	public Result checkCardFourElements(CheckCardFourElementsInput input) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();  
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW); // 事物隔离级别，开启新事务，这样会比较安全些。  
		TransactionStatus status = transactionManager.getTransaction(def); // 获得事务状态  
		
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
		    try {
		    	HttpResponse response = HttpUtils.doPost(host, path, "POST", headers, querys, bodys);
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
		    	    	 			//注册身份信息
		    	    	 			TUserCertificationExample tUserCertificationExample =new TUserCertificationExample();
		    	    	 			tUserCertificationExample.createCriteria().andIdCardEqualTo(idNo);
		    	    	 			List<TUserCertification> selectByExample2 = tUserCertificationMapper.selectByExample(tUserCertificationExample);
		    	    	 			if(selectByExample2.size()<1) {
		    	    	 				TUserCertification tUserCertification=new TUserCertification();
		    	    	 				tUserCertification.setIdCard(idNo);
		    	    	 				tUserCertification.setUserName(name);
		    	    	 				tUserCertification.setUserId(input.getUserId());
		    	    	 				tUserCertification.setStatus("0");
		    	    	 				tUserCertification.setSfz1(input.getIdCard1());
		    	    	 				tUserCertification.setSfz2(input.getIdCard2());
		    	    	 				int insert2 = tUserCertificationMapper.insert(tUserCertification);
		    	    	 				if(insert2>0) {
//		    	    	 					//上传身份证图片
//		    	    	 					Date date=new Date();
//		    	    	 					redisCacheUtil.sortedSet(SFZ, date.getTime(), JSONObject.toJSONString(input));
		    	    	 					transactionManager.commit(status);
		    	    	 					return new Result(true,respMessage);
		    	    	 				}else {
		    	    	 					transactionManager.rollback(status);
		    	    	 					return new Result(false,"添加失败");
		    	    	 				}
		    	    	 			}else {
		    	    	 				transactionManager.rollback(status);
		    	    	 				return new Result(false,"此人已填写实名信息");
		    	    	 			}
		    	    	 		}else {
		    	    	 			return new Result(false,"添加失败");
		    	    	 		}
		    	    	 	}else {
		    	    	 		return new Result(false,"此卡已添加");
		    	    	 	}
		    	    	
		    	     }else {
		    	    	 return new Result(false,respMessage);
		    	     }
		    	}else {
		    		return new Result(false,"接口请求失败,状态码:"+response.getStatusLine().getStatusCode());
		    	}
		    } catch (Exception e) {
		    	e.printStackTrace();
		    	transactionManager.rollback(status);
		    	log.error(e);
		    	return new Result(false,e.getMessage());
		    }
	}

	@Override
	public Result uploadImage(UploadImageInput input) {
	//	System.out.println(input);
		Date date=new Date();
		String jsonObject =JSONObject.toJSONString(input);
		TUserCertification tUserCertification=new TUserCertification();
		try {
			//redisCacheUtil.sortedSet(SCSFZ, date.getTime(), jsonObject);//手持身份证
			tUserCertification.setStatus("2");
			tUserCertification.setShouchi1(input.getShouChi1());
			tUserCertification.setShouchi2(input.getShouChi2());
			tUserCertification.setTime(new Date());
			TUserCertificationExample tUserCertificationExample=new TUserCertificationExample();
			tUserCertificationExample.createCriteria().andUserIdEqualTo(input.getUserId());
			int updateByExampleSelective = tUserCertificationMapper.updateByExampleSelective(tUserCertification, tUserCertificationExample);
			if(updateByExampleSelective>0) {
				return new Result(true,"成功");
			}else {
				return new Result(false,"失败");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false,"失败");
		}
//		System.out.println(redisCacheUtil.getSortedSet("smrz:"+input.getUserId()));
	}

	@Override
	public Result getRealNameAuthentication(UserInfo input) {
		TUserCertificationExample tUserCertificationExample = new TUserCertificationExample();
		tUserCertificationExample.createCriteria().andUserIdEqualTo(input.getUserId());
		List<TUserCertification> selectByExample = tUserCertificationMapper.selectByExample(tUserCertificationExample);
		TUserBankcardExample tUserBankcardExample = new TUserBankcardExample();
		tUserBankcardExample.createCriteria().andUserIdEqualTo(input.getUserId());
		List<TUserBankcard> selectByExample2 = tUserBankcardMapper.selectByExample(tUserBankcardExample);
		if(selectByExample.size()>0&&selectByExample2.size()>0) {
			UserRealNameInfoOutput output=new UserRealNameInfoOutput();
			output.setBankName(selectByExample2.get(0).getBankName());
			output.setCardNo(selectByExample2.get(0).getCardNo());
			output.setUserName(selectByExample.get(0).getUserName());
			output.setIdCard(selectByExample.get(0).getIdCard());
			output.setStatus(selectByExample.get(0).getStatus());
			return new Result(true,"成功",output);
		}else {
			return new Result(false,"未认证");
		}
	}
}
