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
	@GetMapping(value="top")
	public Result getFenRunTopList(UserInfo input) {
		return fenRunService.getFenRunTopList(input);
	}
	@GetMapping(value="ranking")
	public Result getPersonFenRunRanking(UserInfo input) {
		return fenRunService.getPersonFenRunRanking(input);
	}
	@GetMapping(value="")
	public Result getPersonFenRunMx( PersonFenRunMxInput input) {
		//PersonFenRunMxInput 
		return fenRunService.getPersonFenRunMx(input);
	}

}
