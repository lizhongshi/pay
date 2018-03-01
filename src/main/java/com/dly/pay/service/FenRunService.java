package com.dly.pay.service;

import com.dly.pay.base.Result;
import com.dly.pay.vo.PersonFenRunMxInput;
import com.dly.pay.vo.UserInfo;

/**
 * 分润计算
 * @author lzs
 *
 */
public interface FenRunService {
		public  void  fenRun(String userId,String project,Double sum,String orderId) throws Exception;//
		public Result getFenRunTopList(UserInfo input);
		public Result getPersonFenRunRanking(UserInfo input);
		public Result getPersonFenRunMx(PersonFenRunMxInput input) ;
}
