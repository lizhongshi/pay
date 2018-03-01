package com.dly.pay.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.dly.pay.base.Result;
import com.dly.pay.entity.TUserBankcard;
import com.dly.pay.vo.CheckCardFourElementsInput;
import com.dly.pay.vo.UploadImageInput;
import com.dly.pay.vo.UserInfo;

@Service
public interface RealNameAuthenticationService {
	public  Result checkCardFourElements(CheckCardFourElementsInput input);
	public  Result uploadImage(@RequestBody UploadImageInput input) ;
	public  Result getRealNameAuthentication(@RequestBody UserInfo input) ;
	
}
