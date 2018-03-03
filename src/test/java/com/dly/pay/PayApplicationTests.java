package com.dly.pay;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dly.pay.rabbitMQ.Sender;
import com.dly.pay.service.FenRunService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PayApplicationTests {
	@Resource
	FenRunService fenRunService;
	@Resource
	Sender sender;
	@Test
	public void contextLoads() {
//		 Calendar cal = Calendar.getInstance();
//			int year= cal.get(Calendar.YEAR);//年
//			String month=String.format("%02d", cal.get(Calendar.MONTH)+1) ;
//			String day=String.format("%02d", cal.get(Calendar.DAY_OF_MONTH)) ;
//			
//			System.out.println(year);
//			System.out.println(month);
//			System.out.println(day);
		//ThreadPoolExecutor pool=new ThreadPoolExecutor(10, 10, 0, null, null);
		
		try {
			fenRunService.fenRun("00000010", "1",new Double(16666),"2018020600051");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	@Test
	public  void s1() throws InterruptedException {
		for (int i = 0; i < 150; i++) {
			System.out.println(i);
			sender.send("sss"+i);
		}
		Thread.sleep(10000);
	}

}
