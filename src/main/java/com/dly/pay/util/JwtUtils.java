package com.dly.pay.util;


import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
/**
*  jwt实现方式
*/
public class JwtUtils {
	public static final String PRIVATE_KEY="1adadasdadsszczwWW";
	public static final Long TIME_OUT=1000L*60*15000000;
	
public static Claims parseJWT(String jsonWebToken, String base64Security) {

			Claims claims = Jwts.parser().
					setSigningKey(DatatypeConverter.parseBase64Binary(base64Security)).parseClaimsJws(jsonWebToken)
					.getBody();
			return claims;
	
	
}
//前三个参数为自己用户token的一些信息比如id，权限，名称等。不要将隐私信息放入（大家都可以获取到）
public static String createJWT(String project, String userId) {
			SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
			long nowMillis = System.currentTimeMillis();
            Date now = new Date(nowMillis);
            	//生成签名密钥 就是一个base64加密后的字符串？
            byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary (PRIVATE_KEY); 
            Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm. getJcaName());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("project", project);
            jsonObject.put("userId", userId);
            //添加构成JWT的参数
            JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
            		.setIssuedAt(now) //创建时间
            		.setSubject(jsonObject.toString()) //主题，也差不多是个人的一些信息
            		.signWith(signatureAlgorithm, signingKey); //估计是第三段密钥
			//添加Token过期时间
			if (TIME_OUT >= 0) {
			//过期时间
			long expMillis = nowMillis + TIME_OUT;
			//现在是什么时间
				Date exp = new Date(expMillis);
					//系统时间之前的token都是不可以被承认的
			builder.setExpiration(exp).setNotBefore(now);
			}

return builder.compact();
	}
public static void main(String[] args) {
String s=createJWT("aa","aaaa");
	System.out.println(s);
	System.out.println(parseJWT(s,
			PRIVATE_KEY));
}
}
