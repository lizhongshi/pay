package com.dly.pay.controller;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dly.pay.base.Result;
import com.dly.pay.service.FenRunService;
import com.dly.pay.vo.PersonFenRunMxInput;
import com.dly.pay.vo.UserInfo;

@RestController
@RequestMapping("api/fenrun")
public class FenRunController {
	
	@Resource
	FenRunService fenRunService;
	//获取分润排行榜
	@GetMapping(value="top")
	public Result getFenRunTopList(UserInfo input) {
		return fenRunService.getFenRunTopList(input);
	}
	//获取本人分润排行
	@GetMapping(value="ranking")
	public Result getPersonFenRunRanking(UserInfo input) {
		return fenRunService.getPersonFenRunRanking(input);
	}
	//获取今日明细
	@GetMapping(value="")
	public Result getPersonFenRunMx( PersonFenRunMxInput input) {
		//PersonFenRunMxInput 
		return fenRunService.getPersonFenRunMx(input);
	}
	//获取今日分润
	@GetMapping(value="today")
	public Result getPersonTodayFenRun( PersonFenRunMxInput input) {
		//PersonFenRunMxInput 
		return fenRunService.getPersonTodayFenRun(input);
	}
	//获取昨日分润
	@GetMapping(value="yesterday")
	public Result getPersonYesterdayFenRun( PersonFenRunMxInput input) {
		//PersonFenRunMxInput 
		return fenRunService.getPersonYesterdayFenRun(input);
	}
}
