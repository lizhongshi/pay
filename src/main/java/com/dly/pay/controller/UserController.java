package com.dly.pay.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dly.pay.base.Result;
import com.dly.pay.service.UserService;
import com.dly.pay.vo.ChangeUserInfoInput;
import com.dly.pay.vo.LoginInput;
import com.dly.pay.vo.RegisterInput;
import com.dly.pay.vo.UserInfoInput;


@RestController
@RequestMapping("/api/personal")
public class UserController {
	private static Logger log = Logger.getLogger(UserController.class);
	@Resource
	UserService userService;
	/**
	 * 登录
	 * @param see
	 * @param user
	 * @return
	 */
	@PostMapping(value="login",produces = "application/json;charset=UTF-8")
	public String  login(@RequestBody LoginInput user) {
	
	 Result re=	userService.login(user);
		String json=JSONObject.toJSONString(re);
	
		
		return json;
	}
	/**
	 * 注册
	 * @param user
	 * @return 
	 */
	@PostMapping(value="register",produces = "application/json;charset=UTF-8")
	public Object  register(@RequestBody RegisterInput user) {
		
		 Result re=	userService.register(user);
	       String json=JSONObject.toJSONString(re);
	      
			//req.
			return json;
	}
	/**
	 * 退出登录
	 * @param jo
	 * @return
	 */
	@PostMapping(value="logout",produces = "application/json;charset=UTF-8")
	public Object  logout(@RequestBody JSONObject jo) {
		 Result re=	userService.logout(jo.getString("tokenId"));
	       String json=JSONObject.toJSONString(re);
			return json;
	}
	
	@GetMapping(value="",produces = "application/json;charset=UTF-8")
	public Object  getUserInfo( UserInfoInput input){
		return userService.getUserInfo(input);
	}
	/**
	 * 获取下级
	 * @param input
	 * @return
	 */
	@GetMapping(value="userSubordinate",produces = "application/json;charset=UTF-8")
	public Result getUserSubordinate(@RequestBody UserInfoInput input) {
		return userService.getUserSubordinate(input,new JSONArray() );
	}
	/**
	 * 修改用户信息
	 * @param input
	 * @return
	 */
	@PostMapping(value="",produces = "application/json;charset=UTF-8")
	public Object  changeUserInfo(@RequestBody ChangeUserInfoInput input){
		return userService.changeUserInfo(input);
	}
	/**
	 * 忘记密码
	 * @param input
	 * @return
	 */
	@PostMapping(value="resetPassword",produces = "application/json;charset=UTF-8")
	public Object  resetPassword(@RequestBody ChangeUserInfoInput input){
		return userService.resetPassword(input);
	}

}
