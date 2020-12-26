package com.athanprodcaster.ProjectService;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.athanprodcaster.AuthorizationServiceRpcClient.IAuthServiceClient;
import com.athanprodcaster.LogglyEvents.LogglyEventsLogger;
import com.athanprodcaster.AuthorizationServiceRpcClient.AuthServiceClient;

@Configuration
public class Initializer implements ApplicationRunner {

	@Autowired
	public LogglyEventsLogger _logger;
	
	@Autowired
	public Tracer tracer;
	
	 @Value("${AuthServiceRpcBaseUrl}")
	 private String _AuthServiceRpcBaseUrl;
	
	
	@Bean 
	public IAuthServiceClient getAuthServiceClient() throws MalformedURLException 
	{
		
		return new AuthServiceClient("http://localhost:1231",_logger,tracer);
	};
	
	
	
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		/*
		System.out.println("here");
		var list=_AuthServiceClient.getUserRolesOnRestriction(3, 5);
		System.out.println("here size"+list.size());
		System.out.println(list.get(0).getName());
		*/
	}

}
