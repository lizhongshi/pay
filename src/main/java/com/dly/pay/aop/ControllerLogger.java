package com.dly.pay.aop;

import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;


@Aspect  
@Component
public class ControllerLogger {
	private static Logger log = Logger.getLogger(ControllerLogger.class);
	@Around("execution(* com.dly.pay.controller..*.*(..))")
	 public Object Interceptor(ProceedingJoinPoint pjp){ 
		Object result=new Object();
		long beginTime = System.currentTimeMillis();  
        MethodSignature signature = (MethodSignature) pjp.getSignature();  
        Method method = signature.getMethod(); //获取被拦截的方法  
        String methodName = method.getName(); //获取被拦截的方法名  
        Set<Object> allParams = new LinkedHashSet<>(); //保存所有请求参数，用于输出到日志中  
        log.info("方法{"+methodName+"}开始---------------------------->");  
        Object[] args = pjp.getArgs(); 
        for(Object arg : args){  
            //logger.debug("arg: {}", arg);  
            if (arg instanceof Map<?, ?>) {  
                //提取方法中的MAP参数，用于记录进日志中  
                @SuppressWarnings("unchecked")  
                Map<String, Object> map = (Map<String, Object>) arg;  
  
                allParams.add(map);  
            }
        }
        log.info("参数:"+JSONObject.toJSONString(args)); 
        try {
			result=pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        log.info("返回值"+JSONObject.toJSONString(result));
        long endTime = System.currentTimeMillis();  
        log.info("方法{"+methodName+"}结束<----------------------------耗时:"+(endTime-beginTime)+"毫秒");  
		 return result;
	 }
	

}
