package com.dly.pay.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.dly.pay.service.impl.UserIDGenerratedServiceImpl;
import com.dly.pay.sms.ShortMessage;
@RestController
@RequestMapping("test")
public class fest {
	@Resource
	UserIDGenerratedServiceImpl userIDGenerrated;
	@Resource
	ShortMessage sendSms;
	@RequestMapping("test1")
	public void test(HttpServletRequest request, HttpServletResponse response)throws Exception {
		PrintWriter writer = response.getWriter();
		ServletOutputStream outputStream = response.getOutputStream();
		
//		setCharacterEncoding(String charset) //告知服务器使用什么编码 
//		setContentType(String type)
	}
	@PostMapping(value="t1",produces = "application/json;charset=UTF-8")
	public void test1(@RequestBody JSONObject userName) {
		System.out.println(userName);
		
	}
	
	

}
