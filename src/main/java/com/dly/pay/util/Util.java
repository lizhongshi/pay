package com.dly.pay.util;

import java.util.Random;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;

public class Util {
	/**
	 * 短信验证码
	 * @return
	 */
	public static String randomNumber() {
		Random r=new Random();
		StringBuffer randomNumber=new StringBuffer();
		for (int i = 0; i < 4; i++) {
			randomNumber.append(r.nextInt(10));
		}
		return  randomNumber.toString();
			
	}
	  public static  String getUUID(){
	    String uuid = UUID.randomUUID().toString().replaceAll("-", "");
	    return uuid;
	  }

	  public static String Md5(String pwd, String salt){
	    return DigestUtils.md5Hex(pwd + salt);
	  }
	  public static void main(String[] args) {
		String salt=getUUID();
		System.out.println(salt);
		System.out.println(Md5("111111",salt));
	}

}
