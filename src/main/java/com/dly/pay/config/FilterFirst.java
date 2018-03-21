package com.dly.pay.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.core.annotation.Order;

import com.alibaba.fastjson.JSONObject;
import com.dly.pay.base.HttpSturts;
import com.dly.pay.base.MyHttpServletRequestWrapper;
import com.dly.pay.util.JwtUtils;

import io.jsonwebtoken.Claims;

@Order(1)
//重点
@WebFilter(filterName = "verification", urlPatterns = "/api/*")
public class FilterFirst implements Filter {
	Logger log=Logger.getLogger(FilterFirst.class);
	List<String> path=new ArrayList<String>();
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
	  log.info("初始化");
	  path.add("/api/personal/login");//注册 登录操作不拦截
	  path.add("/api/personal/register");//注册 登录操作不拦截
	  path.add("/api/sms/shortMessage");//发送短信验证码
	  path.add("/api/personal/resetPassword");//忘记密码
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
          throws IOException, ServletException {
	  String jwt= (String) servletRequest.getParameter("jwt");
	  HttpServletRequest  req=(HttpServletRequest) servletRequest;
	  HttpServletResponse  res=(HttpServletResponse) servletResponse;
	  System.out.println(jwt);
	  System.out.println(req.getQueryString());
	  
	String url=req.getServletPath();
	for (String string : path) {  //对登录注册接口放行
		if(url.equals(string)) {
			filterChain.doFilter(servletRequest,servletResponse);
			return ;
		}
	}
	MyHttpServletRequestWrapper beforeReq=new MyHttpServletRequestWrapper(req);//前置req
	MyHttpServletRequestWrapper afterReq=null;//后置
	try {
		Claims claims= JwtUtils.parseJWT(jwt, JwtUtils.PRIVATE_KEY);
		JSONObject user=JSONObject.parseObject(claims.getSubject());//获取用户信息
		BufferedReader br=beforeReq.getReader();
		String str= "";
		StringBuffer wholeStr=new StringBuffer();
		while((str = br.readLine()) != null){
		wholeStr.append( str);
		}
		System.out.println("源数据"+wholeStr);
		JSONObject parameter=null;
		try {
			parameter=JSONObject.parseObject(wholeStr.toString());	
			parameter.put("project", user.get("project"));
			parameter.put("userId", user.get("userId"));
			
		}catch(Exception e) {
			parameter=new JSONObject();	
			parameter.put("project", user.get("project"));
			parameter.put("userId", user.get("userId"));
		}
		System.out.println("重装数据"+parameter.toJSONString());
		
		afterReq=new MyHttpServletRequestWrapper(req,parameter.toJSONString().getBytes());//重新组装参数
	//	req.getHeader(name);
		
	}catch(Exception e) {
		e.printStackTrace();
		res.sendError(HttpSturts.http_401.getCode(),HttpSturts.http_401.getMessage());
		return;
	}
	filterChain.doFilter(afterReq,res);
  }

  @Override
  public void destroy() {

  }
}


