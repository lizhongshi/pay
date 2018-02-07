package com.dly.pay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dly.pay.redis.JedisDateSource;
import com.dly.pay.service.IDGeneratedService;

import redis.clients.jedis.Jedis;
@Service("userIDGenerrated")
public class UserIDGenerratedServiceImpl implements IDGeneratedService{
	
	@Autowired
    private JedisDateSource jedisUtil;
	@Override
	public String increase() {
		Jedis jedis=null;
		String userID=null;
		try {
			 jedis=jedisUtil.getJedis();
			 userID= String.format("%08d", jedis.incr(IDGeneratedService.USER_ID));
		}catch(Exception e) {
			 throw	e;
		}finally {
			jedisUtil.colse(jedis);
		}
		return userID;
	}

}
