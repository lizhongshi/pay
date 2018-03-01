package com.dly.pay.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dly.pay.rabbitMQ.Sender;
import com.dly.pay.service.impl.UserIDGenerratedServiceImpl;
import com.dly.pay.sms.ShortMessage;
@RestController
@RequestMapping("test")
public class fest {
	@Resource
	UserIDGenerratedServiceImpl userIDGenerrated;
	@Resource
	ShortMessage sendSms;
	@Resource
	Sender sender;
	@RequestMapping("test1")
	public void test(HttpServletRequest request, HttpServletResponse response)throws Exception {
		PrintWriter writer = response.getWriter();
		ServletOutputStream outputStream = response.getOutputStream();
		
//		setCharacterEncoding(String charset) //告知服务器使用什么编码 
//		setContentType(String type)
	}
	@GetMapping(value="t1",produces = "application/json;charset=UTF-8")
	public void test1() {
//		for (int i = 0; i <150; i++) {
//			sender.send("sssssss"+i);
//		} 
		sender.send("sssssss1");
		sender.send("sssssss2");
		sender.send("sssssss3");
		sender.send("sssssss4");
		sender.send("sssssss5");
	}
	
	

}
