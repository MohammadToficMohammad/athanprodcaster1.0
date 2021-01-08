package com.athanprodcaster.TrafficController;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.athanprodcaster.LogglyEvents.LogglyEventsLogger;
import com.athanprodcaster.TrafficControllerRpcClient.ITrafficControllerClient;
import com.athanprodcaster.TrafficControllerRpcClient.TrafficControllerClient;
import com.athanprodcaster.TrafficServerRpcClient.ITrafficServerClient;
import com.athanprodcaster.TrafficServerRpcClient.TrafficServerClient;


@Component
public class Initializer  {

	@Autowired
	public  LogglyEventsLogger _logger;
	
	@Autowired
	public  Tracer tracer;
	
	
	
	public   ITrafficServerClient getTrafficServerClient(String baseurl) throws MalformedURLException 
	{
		
		return new TrafficServerClient(baseurl,_logger,tracer);
	};
	
	
	
	


}
