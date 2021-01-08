package com.athanprodcaster.TrafficServer;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.athanprodcaster.LogglyEvents.LogglyEventsLogger;
import com.athanprodcaster.TrafficControllerRpcClient.ITrafficControllerClient;
import com.athanprodcaster.TrafficControllerRpcClient.TrafficControllerClient;


@Configuration
public class Initializer implements ApplicationRunner {

	@Autowired
	public LogglyEventsLogger _logger;
	
	@Autowired
	public Tracer tracer;
	
	 @Value("${TrafficControllerRpcBaseUrl}")
	 private String _TrafficControllerRpcBaseUrl;
	
	
	@Bean 
	public ITrafficControllerClient getTrafficControllerClient() throws MalformedURLException 
	{
		
		return new TrafficControllerClient(_TrafficControllerRpcBaseUrl,_logger,tracer);
	};
	
	
	
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		
		
		
	}

}
