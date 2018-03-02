package com.dly.pay.service.impl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.http.cookie.SM;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.dly.pay.base.RedisKey;
import com.dly.pay.base.Result;
import com.dly.pay.dao.TFenrunMxMapper;
import com.dly.pay.dao.TUserMapper;
import com.dly.pay.dao.TsLevelMapper;
import com.dly.pay.entity.TFenrunMx;
import com.dly.pay.entity.TFenrunMxExample;
import com.dly.pay.entity.TUser;
import com.dly.pay.entity.TUserExample;
import com.dly.pay.entity.TsLevel;
import com.dly.pay.service.FenRunService;
import com.dly.pay.util.CalendarUtil;
import com.dly.pay.util.RedisCacheUtil;
import com.dly.pay.vo.FenRunTopOutput;
import com.dly.pay.vo.PersonFenRunMxInput;
import com.dly.pay.vo.PersonFenRunMxOutput;
import com.dly.pay.vo.UserInfo;
import com.github.pagehelper.PageHelper;
@Service("userFenRunService")
@Scope("prototype")
public class UserFenRunServiceImpl implements FenRunService{
	
	private Logger log=Logger.getLogger(UserFenRunServiceImpl.class);
	@Resource
	TUserMapper tUserMapper;
	@Resource
	TsLevelMapper  tsLevelMapper;
	@Resource
	TFenrunMxMapper  tFenrunMxMapper;
	@Resource
	RedisCacheUtil redisCacheUtil;
	@Transactional(value=TxType.REQUIRED,rollbackOn=Exception.class)
	@Override
	public void fenRun(String userId,String project,Double sum,String orderId) throws Exception {
		
		TUser user= tUserMapper.selectByPrimaryKey(userId);
		if(user.getReferee()==null) {//如果是推荐人是null,结束方法
			return ;
		}
		TUser referee= tUserMapper.selectByPrimaryKey(user.getReferee());//获取推荐人
		if(referee==null||user.getLevel()>=referee.getLevel()) {//如果是用户比推荐人等级高,结束方法
			return ;
		}
		//获取用户费率
		TsLevel userLevel= tsLevelMapper.selectByPrimaryKey(user.getLevel());
		Double userRate=userLevel.getRate();
		//获取推荐人费率
		TsLevel refereeLevel= tsLevelMapper.selectByPrimaryKey(referee.getLevel());
		Double refereeRate=refereeLevel.getRate();
		//计算分润
		DecimalFormat df = new DecimalFormat("#.00");//保留两位小数
		//手续费
		Double poundage=sum*userRate/100;
		Double fenRun=Double.valueOf(df.format((sum/100)*(userRate-refereeRate)));//
		referee.setFyzj(referee.getFyzj()+fenRun);
		tUserMapper.updateByPrimaryKeySelective(referee);
		TFenrunMx tFenrunMx=new TFenrunMx();
		tFenrunMx.setFsje(fenRun);
		tFenrunMx.setJyje(sum);
		tFenrunMx.setUserId(userId);
		tFenrunMx.setReferee(referee.getUserId());
		tFenrunMx.setYwlsh(orderId);
		//tFenrunMx.setTime(new Date());
		int insert = tFenrunMxMapper.insert(tFenrunMx);
		if(!referee.getUserId().equals("-1")) {
			//redisCacheUtil.zincrby(RedisKey.PERSON_RANKING.getKey()+CalendarUtil.getNowTime(CalendarUtil.format), fenRun, referee.getUserId());
			//当日排行榜
			if(!redisCacheUtil.exists(RedisKey.PERSON_TODAY_RANKING.getKey()+CalendarUtil.getNowTime(CalendarUtil.yyyy_MM_ddFormat))) {
				redisCacheUtil.zincrby(RedisKey.PERSON_TODAY_RANKING.getKey()+CalendarUtil.getNowTime(CalendarUtil.yyyy_MM_ddFormat), fenRun, referee.getUserId());
				redisCacheUtil.upKey(RedisKey.PERSON_TODAY_RANKING.getKey()+CalendarUtil.getNowTime(CalendarUtil.yyyy_MM_ddFormat), CalendarUtil.getTodayRemainingMilliseconds());
			}else {
				redisCacheUtil.zincrby(RedisKey.PERSON_TODAY_RANKING.getKey()+CalendarUtil.getNowTime(CalendarUtil.yyyy_MM_ddFormat), fenRun, referee.getUserId());
			}
			//当月排行榜
			if(!redisCacheUtil.exists(RedisKey.PERSON_TOMONTH_RANKING.getKey()+CalendarUtil.getNowTime(CalendarUtil.yyyy_MMFormat))) {
				redisCacheUtil.zincrby(RedisKey.PERSON_TOMONTH_RANKING.getKey()+CalendarUtil.getNowTime(CalendarUtil.yyyy_MMFormat), fenRun, referee.getUserId());
				redisCacheUtil.upKey(RedisKey.PERSON_TOMONTH_RANKING.getKey()+CalendarUtil.getNowTime(CalendarUtil.yyyy_MMFormat), CalendarUtil.getToMonthRemainingMilliseconds());
			}else {
				redisCacheUtil.zincrby(RedisKey.PERSON_TOMONTH_RANKING.getKey()+CalendarUtil.getNowTime(CalendarUtil.yyyy_MMFormat), fenRun, referee.getUserId());
			}
		}
		if(insert<1) {
			throw new Exception();
		}
		if(referee.getReferee()!=null) {//
			fenRun(referee.getUserId(),project,sum,orderId);
		}	
	}
	@Override
	public Result getFenRunTopList(UserInfo input) {
		UserInfo todayFenrunTopList = tFenrunMxMapper.getTodayFenrunTopList();
		UserInfo tomonthFenrunTopList = tFenrunMxMapper.getTomonthFenrunTopList();
		JSONObject result=new JSONObject();
		result.put("today", todayFenrunTopList);
		result.put("tomonth", tomonthFenrunTopList);
		return new Result(true,"",result);
	}
	@Override
	public Result getPersonFenRunRanking(UserInfo input) {
		System.out.println(input);
		JSONObject result=new JSONObject();
		try {
			Long today = redisCacheUtil.zrank(RedisKey.PERSON_TODAY_RANKING.getKey()+CalendarUtil.getNowTime(CalendarUtil.yyyy_MM_ddFormat), input.getUserId());//获取
			Long tomonth= redisCacheUtil.zrank(RedisKey.PERSON_TOMONTH_RANKING.getKey()+CalendarUtil.getNowTime(CalendarUtil.yyyy_MMFormat), input.getUserId());//获取
			result.put("today", today);
			result.put("tomonth", tomonth);
			return new Result(true,"",result);
		}catch(Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			return new Result(false,e.getMessage());
		}
	}
	@Override
	public Result getPersonFenRunMx(PersonFenRunMxInput input) {
		TFenrunMxExample tFenrunMxExample = new TFenrunMxExample(); 
		Date start=new Date();
		start.setTime(Long.valueOf(input.getStart()));
		Date end=new Date();
		end.setTime(Long.valueOf(input.getEnd()));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		String s1=sdf.format(start);
//		String e=sdf.format(end);
//		try {
//			start=sdf.parse(start);
//			start=sdf.parse(s);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			start=sdf.parse(CalendarUtil.getNowTime(CalendarUtil.yyyy_MM_ddFormat)+" 00:00:00.0");
//			
//			end=sdf.parse(CalendarUtil.getNowTime(CalendarUtil.yyyy_MM_ddFormat)+" 23:59:59.0");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		tFenrunMxExample.createCriteria().andUserIdEqualTo(input.getUserId()).andTimeBetween(start, end);
		List<TFenrunMx> selectByExample = tFenrunMxMapper.selectByExample(tFenrunMxExample);
		return new Result(true,"",selectByExample);
	}
	@Override
	public Result getPersonTodayFenRun(PersonFenRunMxInput input) {
		PersonFenRunMxOutput getuserFenrunSum = tFenrunMxMapper.getuserTodayFenrunSum(input);
		if(getuserFenrunSum==null) {
			getuserFenrunSum =new PersonFenRunMxOutput();
			getuserFenrunSum.setFenrunzj(0);
		}
		return new Result(true,"",getuserFenrunSum);
	}
	@Override
	public Result getPersonYesterdayFenRun(PersonFenRunMxInput input) {
		PersonFenRunMxOutput getuserFenrunSum = tFenrunMxMapper.getuserYesterdayFenrunSum(input);
		if(getuserFenrunSum==null) {
			getuserFenrunSum =new PersonFenRunMxOutput();
			getuserFenrunSum.setFenrunzj(0);
		}
		return new Result(true,"",getuserFenrunSum);
	}
	
}
