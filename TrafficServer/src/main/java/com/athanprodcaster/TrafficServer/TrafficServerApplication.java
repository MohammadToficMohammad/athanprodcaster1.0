package com.athanprodcaster.TrafficServer;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.athanprodcaster.LogglyEvents.LogglyEventsLogger;
import com.athanprodcaster.TrafficControllerRpcClient.ITrafficControllerClient;

@EnableAspectJAutoProxy(proxyTargetClass=true)  
@EnableAsync
@ComponentScan({"com.athanprodcaster.**"})
@EnableScheduling
@SpringBootApplication
public class TrafficServerApplication {
	
	@Autowired 
	ITrafficControllerClient _TrafficControllerClient;
	
	@Autowired 
	LogglyEventsLogger _Logger;

	private static org.slf4j.Logger log = LoggerFactory.getLogger(TrafficServerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TrafficServerApplication.class, args);
	}

	
//	@Scheduled(fixedRate = 5000)
	//@NewSpan
	public void RegisterTrafficServer() {
		System.out.println("RegisterTrafficServer");
		log.info("sending request...from ts to tsc");
		_Logger.Log("TrafficServerApplication RegisterTrafficServer");
		_TrafficControllerClient.registerTrafficServer("testport");;

	}
}
