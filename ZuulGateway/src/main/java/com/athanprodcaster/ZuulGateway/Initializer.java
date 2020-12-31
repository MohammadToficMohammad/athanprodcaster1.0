package com.athanprodcaster.ZuulGateway;

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
		
		return new AuthServiceClient(_AuthServiceRpcBaseUrl,_logger,tracer);
	};
	
	
	
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
	}

}
