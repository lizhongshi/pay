package com.dly.pay;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dly.pay.base.PayRequest;
import com.dly.pay.util.HttpClientUtil;
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1 {
	@Resource
	PayRequest payRequest;
	@Test
	public void t1() {//下单
		Map<String, String> body=new TreeMap<String, String>();

		body.put("merchNo", "M00000064");
		body.put("userName", "田世乾");
		body.put("userIdentity", "130431199510312116");
		body.put("userCardNo", "6210810200000052212");//储蓄卡卡号
		body.put("userPhone", "15512365836");
		body.put("userAddress", "河北省石家庄市");
		body.put("hasPoint", "1");
		body.put("payRateD0plus", "0");
		body.put("noPointPayRate", "0");
		body.put("hasPointPayRate", "50");
		body.put("settleExtraFee", "100");
		System.out.println(body);
		System.out.println(payRequest.payPost("http://47.94.208.216:8080/app/doQuickMerchantRegister.do", body));
	}
	
	@Test
	public void t2() {
		Map<String, String> body=new TreeMap<String, String>();
		body.put("merchNo", "M00000064");
		body.put("subMerchNo", "QM2018020114344100026");
		body.put("userName", "姜承志");
		body.put("hasPointPayRate", "50");
		body.put("settleExtraFee", "100");//储蓄卡卡号
		
		System.out.println(payRequest.payPost("http://47.94.208.216:8080/app/doQuickMerchantChangeFee.do", body));
	}
	
	@Test
	public void t3() {//提现
		Map<String, String> body=new TreeMap<String, String>();
		body.put("merchNo", "M00000064");
		body.put("subMerchNo", "QM2018020114344100026");
		body.put("orderNo", "000001");
		body.put("notifyUrl", "http://198tj48540.iask.in:37379/test/t1");
		body.put("pageUrl", "www.baidu.com");//储蓄卡卡号cardInfo
		body.put("transAmount", "10000");
		body.put("cardInfo", "6/TA61+4cndsKNFLCKgryKnXY2N4Yk8MloGYTu7Da5Y=");
		
		System.out.println(payRequest.payPost("http://47.94.208.216:8080/app/doQuickMerchantPay.do", body));
	}
	
	@Test
	public void t4() {//查询
		Map<String, String> body=new TreeMap<String, String>();
		body.put("merchNo", "M00000064");
		body.put("subMerchNo", "QM2018020114344100026");
		body.put("orderNo", "000003");
		body.put("notifyUrl", "http://198tj48540.iask.in:37379/test/t1");
		body.put("pageUrl", "http://198tj48540.iask.in:37379/test/t1");//储蓄卡卡号cardInfo
		body.put("transAmount", "10000");
		body.put("cardInfo", "6/TA61+4cndsKNFLCKgryKnXY2N4Yk8MloGYTu7Da5Y=");
		
		System.out.println(payRequest.payPost("http://47.94.208.216:8080/app/doQuickMerchantPay.do", body));
	}

}
