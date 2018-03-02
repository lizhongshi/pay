package com.dly.pay.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dly.pay.base.Result;
import com.dly.pay.entity.TUser;
import com.dly.pay.vo.ChangeUserInfoInput;
import com.dly.pay.vo.LoginInput;
import com.dly.pay.vo.RegisterInput;
import com.dly.pay.vo.UserInfoInput;



public interface UserService  {
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public Result login(LoginInput user);//登录
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	public Result register(RegisterInput user);//注册
	/**
	 * 获取用户角色
	 * @param userName
	 * @return
	 */
	/**
	 * 退出登录
	 * @param tokenid
	 * @return
	 */
	public Result logout(String tokenid);
	/**
	 * 修改用户信息
	 * @param userName
	 * @return
	 */
	
	public Result changeUserInfo(ChangeUserInfoInput input);
	/**
	 * 插入一条评论
	 * @param in
	 * @return
	 */
	/**
	 * 忘记密码
	 * @param user
	 * @return
	 */
	public  Result resetPassword(ChangeUserInfoInput user);

	/*
	 * 获取用户信息
	 */
	public Result getUserInfo(UserInfoInput user);
	/**
	 * 获取用户下级
	 * @return
	 */
	public Result getUserSubordinate(UserInfoInput user,JSONArray result);
	
	public Object  uploadUserIcon(TUser input);
	

}
