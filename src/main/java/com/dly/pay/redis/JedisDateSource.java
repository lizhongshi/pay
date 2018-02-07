package com.dly.pay.redis;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class JedisDateSource {
	@Autowired
    private JedisPool jedisPool;
	
	public Jedis getJedis() {
		synchronized(this) {
		Jedis jedis=null;
		try {
				 jedis=	jedisPool.getResource();
			
		}catch(Exception e) {
			jedis.close();
		}
		return jedis;
		}
	}
	public void colse(Jedis jddis) {
		if(jddis!=null) {
			jddis.close();;
		}
	}
}
