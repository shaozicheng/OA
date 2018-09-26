package com.app.OA.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class WeblogAspect {
	
	final static Logger logger = LoggerFactory.getLogger(WeblogAspect.class);
	
	public WeblogAspect(){
		
	}
	
	@Pointcut("execution(public * com.app.OA.controller.*.*(..))")
	private void controllerAspect(){
		
	}
	
	@Before(value = "controllerAspect()")
	public void doBefore(JoinPoint joinPoint){
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		logger.info("[ip:{}] [url:{}] [method:({}) {}]", request.getRemoteAddr(), request.getRequestURI().toString(), 
				request.getMethod(), joinPoint.getSignature());
		logger.info("args: "+Arrays.toString(joinPoint.getArgs()));
	}
	
}
