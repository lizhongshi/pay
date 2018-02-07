package com.dly.pay.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.dly.pay.dao.TOrderMapper;
import com.dly.pay.entity.TOrder;
import com.dly.pay.service.FenRunService;
import com.dly.pay.service.PayNotifyService;
@Service("payNotifyService1")
public class PayNotifyServiceImpl1 implements PayNotifyService {
	@Resource
	TOrderMapper tOrderMapper;
	@Resource(name="userFenRunService")
	FenRunService fenRunService;
	@Override
	public String PayNotify(JSONObject json)throws Exception {
		switch (json.getString("orderStatus")) {
			case "1":{      //支付成功{
				TOrder tOrder = new TOrder();
				tOrder.setOrderId(	json.getString("orderNo"));
				tOrder.setIszf(true);
				tOrder.setPayStatus("1");
				tOrder.setPayTime(new Date());
				int i=tOrderMapper.updateByPrimaryKeySelective(tOrder);
				if(i>0) {
					switch (json.getString("settleStatus")) {
					case "0":{      //等待结算
						TOrder tOrder1 = new TOrder();
						tOrder1.setOrderId(	json.getString("orderNo"));
						tOrder1.setIsdz(false);
						tOrder1.setDzStatus("0");
						int i0= tOrderMapper.updateByPrimaryKeySelective(tOrder1);
						if(i0>0) {
							return "success";
						}else {
							return "fail";
						}
					}
					case "1":{     //结算处理中
						TOrder tOrder1 = new TOrder();
						tOrder1.setOrderId(	json.getString("orderNo"));
						tOrder1.setIsdz(false);
						tOrder1.setDzStatus("1");
						int i1= tOrderMapper.updateByPrimaryKeySelective(tOrder1);
						if(i1>0) {
							return "success";
						}else {
							return "fail";
						}
					}
					case "2":{      //结算成功
						TOrder tOrder1 = new TOrder();
						tOrder1.setOrderId(json.getString("orderNo"));
						tOrder1.setIsdz(true);
						tOrder1.setDzTime(new Date());
						tOrder1.setDzStatus("2");
						int i2= tOrderMapper.updateByPrimaryKeySelective(tOrder1);
						if(i2>0) {
							TOrder order = tOrderMapper.selectByPrimaryKey(json.getString("orderNo"));
							try {
								fenRunService.fenRun(order.getUserId(), "1", Double.valueOf(order.getJyje()));
							} catch (Exception e) {
								// TODO: handle exception
							}
							return "success";
						}else {
							return "fail";
						}
					}
					case "3":{     //结算失败
						TOrder tOrder1 = new TOrder();
						tOrder1.setOrderId(	json.getString("orderNo"));
						tOrder1.setIsdz(false);
						tOrder1.setDzStatus("3");
						int i3= tOrderMapper.updateByPrimaryKeySelective(tOrder1);
						if(i3>0) {
							return "success";
						}else {
							return "fail";
						}
					}
				}
				}else {
					
					
					return "fail";
				}
			}
			case "2":{     //支付失败{
				TOrder tOrder = new TOrder();
				tOrder.setOrderId(	json.getString("orderNo"));
				tOrder.setIszf(false);
				tOrder.setPayStatus("2");
				//tOrder.setPayTime(new Date());
				int i=tOrderMapper.updateByPrimaryKeySelective(tOrder);
				if(i>0) {
					return "success";
				}else {
					
					
					return "fail";
				}
				
			}
		}
		
		
	
		
		return "fail";
		
	}

}
