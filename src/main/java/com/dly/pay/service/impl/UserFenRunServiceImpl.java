package com.dly.pay.service.impl;

import java.text.DecimalFormat;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.dly.pay.dao.TUserMapper;
import com.dly.pay.dao.TsLevelMapper;
import com.dly.pay.entity.TUser;
import com.dly.pay.entity.TsLevel;
import com.dly.pay.service.FenRunService;
@Service("userFenRunService")
@Scope("prototype")
public class UserFenRunServiceImpl implements FenRunService{
	
	@Resource
	TUserMapper tUserMapper;
	@Resource
	TsLevelMapper  tsLevelMapper;







	@Transactional(value=TxType.REQUIRED,rollbackOn=Exception.class)
	@Override
	public void fenRun(String userId,String project,Double sum) throws Exception {
		
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
		if(referee.getReferee()!=null) {//
			fenRun(referee.getUserId(),project,sum);
		}	
	}
}
