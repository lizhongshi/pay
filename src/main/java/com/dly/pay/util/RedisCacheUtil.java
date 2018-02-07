package com.dly.pay.util;



import javax.annotation.Resource;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dly.pay.redis.JedisDateSource;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;


@Component
public class RedisCacheUtil {
	    public static final Long TIME_OUT = 1500l;
	    public static final String USER="User:";
	   
	    @Resource
	    private JedisDateSource redisDataSource;
	   
	static Logger logger = Logger.getLogger(RedisCacheUtil.class);

	 /**
     * 缓存value操作
     * @param key
     * @param value
     * @param 缓存的时间
     * @return
     */
    public   boolean cacheValue(String key, String value, int time) {
    	Jedis jedis = null;
        try {
        	 jedis=redisDataSource.getJedis();
        	jedis.set(key, value);
        	//jedis.expire(key, time);
            logger.info("缓存[" + key+ "], value[" + value + "]");
            return true;
        } catch (Throwable t) {
            logger.error("缓存[" + key + "]失败, value[" + value + "]", t);
            t.printStackTrace();
        }finally{
        	jedis.close();
        }
        return false;
    }
    
    /**
     * 根据key获取缓存
     * @param key
     * @return
     */
    public   String getValue(String key) {
    	Jedis jedis = null;
        try {
        	 jedis=redisDataSource.getJedis();
    	}catch(Exception e) {
    		 logger.error(e.getMessage());
    		 e.printStackTrace();
    	}finally{
        	jedis.close();
        }
            String value=jedis.get(key);
            return  value;
    }
    public void sd(String key,long time) {
    	
    }
    /**
     * 根据传入的key和判断value和data是否一致
     * @param key
     * @param data
     * @return
     */
    public   boolean equalValue(String key,String data) {
    	if(key==null||data==null) {
    		return false;
    	}

    	Jedis jedis = null;
        try {
        	 jedis=redisDataSource.getJedis();
    		 String value=jedis.get(key);
    	        if(data.equals(value)) {
    	        	return  true;
    	        }
    		
    	}catch(Exception e) {
    		 logger.error(e.getMessage());
    		 e.printStackTrace();
    	}finally{
        	jedis.close();
        }
       
        return  false;
}


    /**
     * 删除key
     *
     * @param key
     * @return
     */
    public void deleteKey(String key) {
    	Jedis jedis = null;
        try {
        	 jedis=redisDataSource.getJedis();
    		 jedis.del(key);
    		 	logger.info("删除[" + key+ "]");
    	}catch(Exception e) {
    		 logger.error(e.getMessage());
    		 e.printStackTrace();
    	}finally{
        	jedis.close();
        }
  
   
    	 
    }
    /**
     * 更新key过期时间
     *
     * @param key
     * @return
     */
    public void upKey(String key) {
    	Jedis jedis = null;
        try {
        	 jedis=redisDataSource.getJedis();
    		jedis.expire(key, 500000);
    	}catch(Exception e) {
    		 logger.error(e.getMessage());
    		 e.printStackTrace();
    	}finally{
        	jedis.close();
        }
    }
    /**
     * 获取key的剩余过期时间
     * @param key
     * @return
     */
    public long getKeyTime(String key) {
   	 
    	Jedis jedis = null;
        try {
        	 jedis=redisDataSource.getJedis();
    		return  jedis.ttl(key);
    	}catch(Exception e) {
    		 logger.error(e.getMessage());
    		 e.printStackTrace();
    	}finally{
        	jedis.close();
        }
	 
	return 0; 
    }
    
    public  void  ss(String groupid,String userId) {
    	Jedis jedis = null;
        try {
        	 jedis=redisDataSource.getJedis();
    		jedis.lpush("comment:"+groupid, userId);
    	}catch(Exception e) {
    		 logger.error(e.getMessage());
    		 e.printStackTrace();
    	}finally{
        	jedis.close();
        }
    }
    /**
     * 有序集合
     * @param key 
     * @param score  时间戳
     * @param member 值
     */
    public  void  sortedSet(String key,double score,String member ) {
    	Jedis jedis = null;
        try {
        	 jedis=redisDataSource.getJedis();
    		jedis.zadd(key, score, member);
    	}catch(Exception e) {
    		 logger.error(e.getMessage());
    		 e.printStackTrace();
    	}finally{
        	jedis.close();
        }
    }
   /**
    * 集合
    * @param key
    * @param value
    */
    public  void  set(String key,String members ) {
    	Jedis jedis = null;
        try {
        	 jedis=redisDataSource.getJedis();
    		jedis.sadd(key, members);
    	}catch(Exception e) {
    		 logger.error(e.getMessage());
    		 e.printStackTrace();
    	}finally{
        	jedis.close();
        }
    }
    
    
    
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    /**
//     * 会覆盖指定的hashKey
//     * @param key
//     * @param hashKey
//     * @param value
//     */
//    public void hashSet(String key,String hashKey,String value) {
//    	 HashOperations<String, String, String> ho=redisTemplate.opsForHash();
//    	 ho.put(key,":"+ hashKey, value); 
//    }
//    /**
//     * 如果指定的hashKey存在不会覆盖
//     * @param key
//     * @param hashKey
//     * @param value
//     * @return
//     */
//    public boolean hashSetIfAbsent(String key,String hashKey,String value) {
//   	 	HashOperations<String, String, String> ho=redisTemplate.opsForHash();
//   	 	return  ho.putIfAbsent(key, hashKey, value); 
//   }
//    /**
//     *缓存map
//     * @param key
//     * @param map
//     * @param value
//     */
//    public boolean hashSetAll(String key,Map<String,String> map,String per ){
//    	String finalKey=key+per;
//    	try {
//    		 HashOperations<String, String, String> ho=redisTemplate.opsForHash();
//    		 List<String> keys=new ArrayList<String>();
//    		 List<String> values=new ArrayList<String>();
//    		 for (Object string : map.keySet()) {
//    			 keys.add((String) string);
//    			String value=(String) map.get(string);
//    			values.add(value);
//    		}
//    		 for (int i = 0; i < keys.size(); i++) {
//    			map.remove(keys.get(i));
//    			map.put(":"+keys.get(i), (String) values.get(i));
//    		}
//    		 ho.putAll(finalKey, map);
//    	   	 logger.info("缓存[" + key+ "], map[" + map.toString() + "]");
//    	   	return true;
//             
//        } catch (Throwable t) {
//            logger.error("缓存[" + key + "]失败, map[" + map.toString() + "]", t);
//            return false;
//        }
//   	
//   }
//    /**
//     *获取指定key的hashKeys
//     * @param key
//     * @return
//     */
//    public Set<String>  getHashKeys(String key) {
//      	 HashOperations<String, String, String> ho=redisTemplate.opsForHash();
//      Set<String> set=ho.keys(key);
//      return set;
//    }
//    /**
//     * 获取指定key的hashKey
//     * @param key
//     * @return
//     */
//    public String  getHashKey(String key,String hashKey) {
//      	 HashOperations<String, String, String> ho=redisTemplate.opsForHash();
//      String value=ho.get(key, hashKey);
//      return value;
//    }
//    /**
//     * 删除指定的hashKey
//     * @param key
//     * @param hashKey
//     * @return
//     */
//    public Long deleteHashKey(String key,String hashKey) {
//   	 HashOperations<String, String, String> ho=redisTemplate.opsForHash();
//   	 	return ho.delete(key, hashKey);
//    }
//    /**
//     * 根据传入的hashKeyList 返回一个valueList
//     * @param key
//     * @param list
//     * @return
//     */
//    public List<String> multiGet(String key,List<String>list){
//    	HashOperations<String, String, String> ho=redisTemplate.opsForHash();
//   	 	return ho.multiGet(key, list);
//    }
//    /**
//     * 
//     * @param key
//     * @return 返回指定的key
//     */
//    public Map<String,String> entries(String key){
//    	HashOperations<String, String, String> ho=redisTemplate.opsForHash();
//   	 	return ho.entries(key);
//    }
    
    

   


    

