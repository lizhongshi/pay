package com.dly.pay.service;


import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.dly.pay.base.Result;



public interface SmsService {
	/**
	 * 发送短信
	 * @param phoneNmb
	 * @param message
	 * @return
	 */
    public Result  sendSms(String phoneNmb);
    /**
     * 查询短信是否发送成功
     * @param bizId
     * @return
     */
    public QuerySendDetailsResponse querySendDetails(String bizId) ;
   
	
}
