package com.dly.pay.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dly.pay.sms.SmsBean;
@Configuration
@EnableCaching
public class SmsConfig {
	@Value("${sms.product}")
	private String product;
	
	@Value("${sms.domain}")
	private String domain;

	@Value("${sms.accessKeyId}")
	private String accessKeyId;
	
	@Value("${sms.accessKeySecret}")
	private String accessKeySecret;
	
	@Value("${sms.templateCode}")
	private String templateCode;
	
	@Value("${sms.signName}")
	private String signName;
	
	@Bean
	public SmsBean smsBean() {
		SmsBean bean =new SmsBean();
		bean.setAccessKeyId(accessKeyId);
		bean.setAccessKeySecret(accessKeySecret);
		bean.setDomain(domain);
		bean.setProduct(product);
		bean.setSignName(signName);
		bean.setTemplateCode(templateCode);
		return bean;
	}

}
