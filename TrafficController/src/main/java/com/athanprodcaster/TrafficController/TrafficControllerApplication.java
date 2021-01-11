package com.athanprodcaster.TrafficController;

import java.net.MalformedURLException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.athanprodcaster.LogglyEvents.LogglyEventsLogger;
import com.athanprodcaster.TrafficControllerRpcClient.ITrafficControllerClient;
import com.athanprodcaster.TrafficServerRpcClient.ITrafficServerClient;

@EnableAspectJAutoProxy(proxyTargetClass=true)  
@EnableAsync
@ComponentScan({"com.athanprodcaster.**"})
@EnableScheduling
@SpringBootApplication
public class TrafficControllerApplication {

	
	@Autowired 
	LogglyEventsLogger _Logger;
	
	@Autowired 
	Initializer _Initializer;

	private static org.slf4j.Logger log = LoggerFactory.getLogger(TrafficControllerApplication.class);
	
	
	 @Value("${TrafficServerRpcBaseUrl1}")
	 private  String _TrafficServerRpcBaseUrl1;
	
	public static void main(String[] args) {
		SpringApplication.run(TrafficControllerApplication.class, args);
	}
	
	/*
	@Scheduled(fixedRate = 5000)
	//@NewSpan
	public void SendCommandToTs() throws MalformedURLException {
		System.out.println("SendCommandToTs");
		log.info("sending request...from tsc to ts");
		_Logger.Log("TrafficControllerApplication SendCommandToTs");
		var client=_Initializer.getTrafficServerClient(_TrafficServerRpcBaseUrl1);
		client.sendCommandToTs("command1");

	}
	*/

}
