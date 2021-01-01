package com.athanprodcaster.ProjectService;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.athanprodcaster.AuthorizationServiceRpcClient.IAuthServiceClient;
import com.athanprodcaster.LogglyEvents.LogglyEventsLogger;

@EnableDiscoveryClient
@SpringBootApplication
@EnableScheduling
@EnableAsync
@ComponentScan({"com.athanprodcaster.**"})
public class ProjectServiceApplication {
	
	@Autowired 
	IAuthServiceClient _AuthServiceClient;
	
	@Autowired 
	LogglyEventsLogger _Logger;
	
	private static org.slf4j.Logger log = LoggerFactory.getLogger(ProjectServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProjectServiceApplication.class, args);
	}
	
	@Scheduled(fixedRate = 5000)
	//@NewSpan
	public void reportCurrentTime() {
		System.out.println("here");
		log.info("sending request...from project service to auth");
		_Logger.Log("ProjectServiceApplication reportCurrentTime _AuthServiceClient.getUserRolesOnRestriction(3, 5)");
		var list=_AuthServiceClient.getUserRolesOnRestriction(3, 5);
		System.out.println("here size"+list.size());
		//System.out.println(list.get(0).getName());
	}
}
