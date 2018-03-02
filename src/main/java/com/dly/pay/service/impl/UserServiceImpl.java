package com.dly.pay.service.impl;




import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dly.pay.base.ChangeUserInfoMessage;
import com.dly.pay.base.LoginMessage;
import com.dly.pay.base.RegisterMessage;
import com.dly.pay.base.Result;
import com.dly.pay.dao.TUserMapper;
import com.dly.pay.entity.TUser;
import com.dly.pay.entity.TUserExample;
import com.dly.pay.entity.TUserExample.Criteria;
import com.dly.pay.service.IDGeneratedService;
import com.dly.pay.service.UserService;
import com.dly.pay.util.JwtUtils;
import com.dly.pay.util.RedisCacheUtil;
import com.dly.pay.util.Util;
import com.dly.pay.vo.ChangeUserInfoInput;
import com.dly.pay.vo.LoginInput;
import com.dly.pay.vo.RegisterInput;
import com.dly.pay.vo.UserInfoInput;

@Service("userService")
@Transactional
public class UserServiceImpl  implements UserService {
	@Value(value = "${level.kafen}")
	private Integer kafen;
	@Value(value = "${level.kabei}")
	private Integer kabei;
	private static Logger log = Logger.getLogger(UserServiceImpl.class);
	
	@Resource
	TUserMapper tUserMapper;
	@Resource(name="userIDGenerrated")
	IDGeneratedService userIDGenerrated;
	
	@Resource
	RedisCacheUtil redisCacheUtil;
	
	@Override
	public Result login(LoginInput user) {
		TUserExample TUserExample =new TUserExample();
		Criteria createCriteria = TUserExample.createCriteria();
		//-----> 条件
		createCriteria.andPhoneEqualTo(user.getPhone());
		createCriteria.andProjectEqualTo(user.getProject());
				//<----
		List<TUser> daoResult= tUserMapper.selectByExample(TUserExample);
		if(daoResult.size()>0) {
			TUser userOut=	daoResult.get(0);
			 String password=	userOut.getPassword();
			 String salt=userOut.getSalt();
			 if(Util.Md5(user.getPassword(), salt).equals(password)) {//登录
				String token=  JwtUtils.createJWT(String.valueOf(user.getProject()), userOut.getUserId());
				JSONObject result=new JSONObject();
				result.put("jwt", token);
				result.put("userId", userOut.getUserId());
				 return new Result(true,LoginMessage.SUCCESS.getMessage(),result);
			 }else {
				 return new Result(false,LoginMessage.PASSWORD_ERROR.getMessage());
			 }
			
		}else {
			return new Result(false,LoginMessage.NOFINDUSER.getMessage());
		}
	}

	@Override
	public Result register(RegisterInput user) {
		
		if(!redisCacheUtil.getValue(user.getPhone()).equals(user.getVerificationCode())) { //验证短信
			return new Result(false,RegisterMessage.VERIFICATION_CODE.getMessage());
		}
		TUserExample TUserExample1 =new TUserExample();
		Criteria createCriteria1= TUserExample1.createCriteria();
		//-----> 条件1 查询是否已经注册
				createCriteria1.andPhoneEqualTo(user.getPhone());
				createCriteria1.andProjectEqualTo(user.getProject());
				//<----
		List<TUser> result1= tUserMapper.selectByExample(TUserExample1);
		if(result1.size()==0) {
			TUserExample TUserExample2 =new TUserExample();
			Criteria createCriteria2= TUserExample2.createCriteria();
			//-----> 条件2 查询推荐人是否已经注册
			createCriteria2.andPhoneEqualTo(user.getReferee());
			createCriteria2.andProjectEqualTo(user.getProject());
			//<----
			List<TUser> result2= tUserMapper.selectByExample(TUserExample2);
			if(result2.size()>0) {//进行注册
				TUser referee =result2.get(0);//获取推荐人
				TUser inUser=new TUser();
				String salt=Util.getUUID();
				inUser.setPassword(Util.Md5(user.getPassword(), salt));
				inUser.setSalt(salt);
				inUser.setPhone(user.getPhone());
				inUser.setProject(user.getProject());//项目id
				inUser.setUserId(userIDGenerrated.increase());
				inUser.setReferee(referee.getUserId());//推荐人
				inUser.setLevel(5);
				if(tUserMapper.insert(inUser)>0) {
					if(result2.size()+1>kafen) {
						referee.setLevel(2);
					}else if(result2.size()+1>kabei) {
						referee.setLevel(3);
					}
					TUserExample TUserExample3 =new TUserExample();
					TUserExample3.createCriteria().andUserIdEqualTo(referee.getUserId());
					tUserMapper.updateByExampleSelective(referee, TUserExample3);
					 return new Result(true,RegisterMessage.SUCCESS.getMessage());
					 
				}else {
					return new Result(false,RegisterMessage.ERROR.getMessage());
				}
				
			}else {//推荐人不存在
				return new Result(false,RegisterMessage.NOFIND_REFEREE.getMessage());
			}
		}else {//已经注册
			return new Result(false,RegisterMessage.USER_REPEAT.getMessage());
		}
	}

	@Override
	public Result logout(String tokenid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result changeUserInfo(ChangeUserInfoInput input) {
		TUser user= tUserMapper.selectByPrimaryKey(input.getUserId());
		if(user!=null) {
			switch (input.getFfbm()) {
				case "1":{                                 //修改手机号
					if(input.getYzm().equals(redisCacheUtil.getValue(input.getNewPhone()))) {//验证手机验证码
//						TUserExample tUserExample = new TUserExample();
//						tUserExample.createCriteria().and
						user.setPhone(input.getNewPhone());
						int i=tUserMapper.updateByPrimaryKey(user);
						if(i>0) {
							
							return new Result(true,ChangeUserInfoMessage.PHONE_SUCCESS.getMessage());
						}else {
							return new Result(false,ChangeUserInfoMessage.PHONE_ERROR.getMessage());
						}
					}else {
						return new Result(false,ChangeUserInfoMessage.PHONE_YZM_ERROR.getMessage());
					}
				}
				
				case "2":{                              //修改密码
					String salt=user.getSalt();
					if(user.getPassword().equals(Util.Md5(input.getOldPassword(), salt))&&input.getNewPassword()!=null) {//验证密码
						user.setPassword(Util.Md5(input.getNewPassword(), salt));
						int i=tUserMapper.updateByPrimaryKey(user);
						if(i>0) {
							return new Result(true,ChangeUserInfoMessage.PASSWORD_SUCCESS.getMessage());
						}else {
							return new Result(false,ChangeUserInfoMessage.PASSWORD_ERROR.getMessage());
						}
					}else {
						return new Result(false,ChangeUserInfoMessage.OLD_PASSWORD_ERROR.getMessage());
					}
				}
				
			}
		}
		return null;
	}

	@Override
	public Result resetPassword(ChangeUserInfoInput input) {
		
		TUserExample tUserExample = new  TUserExample();
		tUserExample.createCriteria().andPhoneEqualTo(input.getPhone()).andProjectEqualTo(input.getProject());
		List<TUser> result= tUserMapper.selectByExample(tUserExample);
		if(result.size()==1) {
			if(input.getYzm().equals(redisCacheUtil.getValue(input.getPhone()))) {//验证手机验证码
				String salt=Util.getUUID();
				result.get(0).setPassword(Util.Md5(input.getNewPassword(), salt));
				result.get(0).setSalt(salt);
				int i=tUserMapper.updateByPrimaryKey(result.get(0));
				if(i>0) {
					return new Result(true,ChangeUserInfoMessage.RESET_PASSWORD_SUCCESS.getMessage());
				}else {
					return new Result(false,ChangeUserInfoMessage.RESET_PASSWORD_ERROR.getMessage());
				}
			}else {
				return new Result(false,ChangeUserInfoMessage.PHONE_YZM_ERROR.getMessage());
			}
		}
	
		return new Result(false,ChangeUserInfoMessage.RESET_PASSWORD_ERROR.getMessage());
	}

	@Override
	public Result getUserInfo(UserInfoInput user) {
		
		return new Result(true,"");
	}

	@Override
	public Result getUserSubordinate(UserInfoInput input,JSONArray result) {
		TUserExample tUserExample=new TUserExample();
		tUserExample.createCriteria().andRefereeEqualTo(input.getUserId());
		 List<TUser> daoResult1= tUserMapper.selectByExample(tUserExample);
		if(daoResult1.size()==0) {
			return new Result(true,"",new JSONArray());
		}else if(daoResult1.size()>0) {
			for (TUser user : daoResult1) {
				JSONObject json =new JSONObject();
				json.put("zhixi", user.getPhone());
				JSONArray jsonArray =new JSONArray();
				TUserExample tUserExample1=new TUserExample();
				tUserExample1.createCriteria().andRefereeEqualTo(input.getUserId());
				 List<TUser> daoResult2= tUserMapper.selectByExample(tUserExample1);
				 for (TUser userInfoInput : daoResult2) {
					 JSONObject json1=new JSONObject();
					 json1.put("zhixi", userInfoInput.getPhone());
					 jsonArray.add(json1);
					 JSONArray jsonArray1 =new JSONArray();
					 TUserExample tUserExample2=new TUserExample();
						tUserExample2.createCriteria().andRefereeEqualTo(input.getUserId());
					 List<TUser> daoResult3= tUserMapper.selectByExample(tUserExample2);
					 for (TUser userInfoInput2 : daoResult3) {
						 jsonArray1.add(userInfoInput2.getPhone());
					}
					 json1.put("pangxis", jsonArray1);
				}
				 json.put("pangxis",jsonArray);
				 result.add(json);
			}
			return new Result(true,"",result);
		}
		return new Result(false,"",new JSONArray() );
	}
	@Override
	public Object uploadUserIcon(TUser input) {
		int updateByExampleSelective = tUserMapper.updateByPrimaryKeySelective(input);
		if(updateByExampleSelective>0) {
			return new Result(true,"上传成功");
		}else {
			return new Result(false,"上传失败");
		}
	}
	
}
