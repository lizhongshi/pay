package com.dly.pay.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dly.pay.redis.JedisDateSource;
import com.dly.pay.service.IDGeneratedService;

import redis.clients.jedis.Jedis;
@Service("orderIDGenerated")
public class OrderIDGeneratedServiceImpl implements IDGeneratedService {
	@Autowired
    private JedisDateSource jedisUtil;
	@Override
	public String increase() {
		Jedis jedis=null;
		String orderID=null;
		try {
			 jedis=jedisUtil.getJedis();
			 String id= String.format("%05d", jedis.incr(IDGeneratedService.ORDER_ID));
			 Calendar cal = Calendar.getInstance();
			 String year=String.valueOf(cal.get(Calendar.YEAR));//年
			 String month=String.format("%02d", cal.get(Calendar.MONTH)+1) ;
			 String day=String.format("%02d", cal.get(Calendar.DAY_OF_MONTH));
			 orderID=year+month+day+id;
		}catch(Exception e) {
		    throw e;
		}finally {
			jedisUtil.colse(jedis);
		}
		return orderID;
	}
}
