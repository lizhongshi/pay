package com.dly.pay;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.dly.pay.base.RedisKey;
import com.dly.pay.util.CalendarUtil;

import redis.clients.jedis.Jedis;

public class T2 {
//	@Test
//	public void t5() {
//		
//		    String host = "https://yunyidata.market.alicloudapi.com";
//		    String path = "/bankAuthenticate4";
//		    String method = "POST";
//		    String appcode = "c31ed83201354352adbb2409fb704da6";
//		    Map<String, String> headers = new HashMap<String, String>();
//		    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
//		    headers.put("Authorization", "APPCODE " + appcode);
//		    //根据API的要求，定义相对应的Content-Type
//		    headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
//		    Map<String, String> querys = new HashMap<String, String>();
//		    Map<String, String> bodys = new HashMap<String, String>();
//		    bodys.put("ReturnBankInfo", "YES");
//		    bodys.put("cardNo", "6228480638924776872");
//		    bodys.put("idNo", "130130199504101213");
//		    bodys.put("name", "李中石");
//		    bodys.put("phoneNo", "15932218282");
//		    
////		    bodys.put("ReturnBankInfo", "YES");
////		    bodys.put("cardNo", "6217000130023943540");
////		    bodys.put("idNo", "130638199203167014");
////		    bodys.put("name", "姜承志");
////		    bodys.put("phoneNo", "15832199886");
//
//
//		    try {
//		    	/**
//		    	* 重要提示如下:
//		    	* HttpUtils请从
//		    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
//		    	* 下载
//		    	*
//		    	* 相应的依赖请参照
//		    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
//		    	*/
//		    //	String s=HttpClientUtil.doPost("https://yunyidata.market.alicloudapi.com/bankAuthenticate4", bodys, headers);
//		    	HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
//		    	System.out.println("------"+response.getStatusLine().getStatusCode());
//		    	//获取response的body
//		    	System.out.println("++++"+EntityUtils.toString(response.getEntity()));
//		    //	System.out.println(s);
//		    } catch (Exception e) {
//		    	e.printStackTrace();
//		    }
//		
//	}
//	@Test
//	public  void ss() {
//		asd(RedisKey.PERSON_RANKING);
//	}
//	
	@Test
	public void asd() {
		Jedis jedis =new Jedis("39.106.210.162",6379);
		jedis.auth("200814");
		System.out.println(jedis.zrank("person_today_ranking:2018-02", "00000001"));
	
	}
	public static void main(String[] args) {
//		 CalendarUtil tt = new CalendarUtil(); 
//		 
//		 System.out.println(tt.getNowTime("yyyy-MM-dd"));
//		 System.out.println(tt.getDefaultDay());
//int value=Integer.valueOf(CalendarUtil.getTwoDay(tt.getNowTime("yyyy-MM-dd"), tt.getDefaultDay()));
//System.out.println((value+1)*24*60*60);
		System.out.println(System.currentTimeMillis());
		
		Date start=new Date();
		start.setTime(Long.valueOf(System.currentTimeMillis()));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//start=sdf.format(start);
		System.out.println(sdf.format(start));
	}
}
