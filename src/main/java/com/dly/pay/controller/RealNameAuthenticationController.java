package com.dly.pay.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dly.pay.base.Result;
import com.dly.pay.service.RealNameAuthenticationService;
import com.dly.pay.vo.CheckCardFourElementsInput;
import com.dly.pay.vo.UploadImageInput;
import com.dly.pay.vo.UserInfo;
@RestController
@RequestMapping("api/realNameAuthentication")
public class RealNameAuthenticationController {
	@Resource
	private  RealNameAuthenticationService realNameAuthenticationService;
	//检查银行卡4要素是否匹配
		@PostMapping(value="checkCardFourElements",produces = "application/json;charset=UTF-8")
		public  Result checkCardFourElements(@RequestBody CheckCardFourElementsInput input) {
			return realNameAuthenticationService.checkCardFourElements(input);
		}
		//提交实名认证
		@PostMapping(value="uploadImage",produces = "application/json;charset=UTF-8")
		public  Result uploadImage(@RequestBody UploadImageInput input) {
			return realNameAuthenticationService.uploadImage(input);
		}
		//获取实名认证状态
		@GetMapping(value="",produces = "application/json;charset=UTF-8")
		public  Result getRealNameAuthentication(@RequestBody UserInfo input) {
			return realNameAuthenticationService.getRealNameAuthentication(input);
		}
		
		
		

		
}
