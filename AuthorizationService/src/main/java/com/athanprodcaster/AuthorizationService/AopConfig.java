package com.athanprodcaster.AuthorizationService;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.athanprodcaster.LogglyEvents.LogglyEventsLogger;

@Aspect 
@Configuration
public class AopConfig
{
	@Autowired
	private LogglyEventsLogger _Logger;
	
	@Pointcut("within(@org.springframework.stereotype.Service *)")
	public void serviceClassMethods() {}
	
	@Around("serviceClassMethods()")
	public Object logServiceCall(ProceedingJoinPoint jp) throws Throwable {
		Object ret=null;
		System.out.println("The method before invocation of " + jp.getSignature().getName() + " Service"+ jp.getTarget().getClass() +" args:"+Arrays.toString(jp.getArgs()));
		_Logger.Log("The method before invocation of " + jp.getSignature().getName() + " Service"+ jp.getTarget().getClass() +" args:"+Arrays.toString(jp.getArgs()));
		try   
		{  
		 ret=jp.proceed();  
		}   
		finally   
		{  
		  
		}  
		System.out.println("The method after invocation of " + jp.getSignature().getName() + " Service"+ jp.getTarget().getClass() +" args:"+Arrays.toString(jp.getArgs()) + " result:"+ret);
		_Logger.Log("The method after invocation of " + jp.getSignature().getName() + " Service"+ jp.getTarget().getClass() +" args:"+Arrays.toString(jp.getArgs()) + " result:"+ret);
		 
		return ret;
	   
	}
	
	
/*
	@Pointcut("within(@org.rejeev.Monitor *)")
public void beanAnnotatedWithMonitor() {}

@Pointcut("execution(public * *(..))")
public void publicMethod() {}

@Pointcut("publicMethod() && beanAnnotatedWithMonitor()")
public void publicMethodInsideAClassMarkedWithAtMonitor() {}
	
*/
}
