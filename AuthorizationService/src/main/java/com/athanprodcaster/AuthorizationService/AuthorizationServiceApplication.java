package com.athanprodcaster.AuthorizationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableAspectJAutoProxy(proxyTargetClass=true)  
@SpringBootApplication
@EnableAsync
@ComponentScan({"com.athanprodcaster.**"})
@EnableScheduling
public class AuthorizationServiceApplication {
	


	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServiceApplication.class, args);
	}
	
	

}
