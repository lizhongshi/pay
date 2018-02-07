package com.dly.pay.base;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.dly.pay.util.HttpClientUtil;

/**
 * 支付请求
 * @author 12622
 *
 */
@Component
public class PayRequest {
	@Value("${sign.dataKey}")
	private  String dataKey;
	@Value("${sign.signKey}")
	private   String signKey;
	
	public   String  payPost(String url,Map<String,String> params) {
		String sign="";
		
		for (Entry<String, String> entry : params.entrySet()) {
			
				sign+=entry.getKey()+"="+entry.getValue()+"&";
			
			
		}
		if(params.size()%2!=0) {
			sign=	sign.substring(0, sign.length()-1);
		}
		System.out.println("sign:"+sign);
		params.put("sign", DigestUtils.md5Hex(sign+signKey));
		return	HttpClientUtil.doPost(url, params, null);
		 
	}

}
