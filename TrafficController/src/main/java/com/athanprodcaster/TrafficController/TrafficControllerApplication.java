package com.athanprodcaster.TrafficController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAspectJAutoProxy(proxyTargetClass=true)  
@EnableAsync
@ComponentScan({"com.athanprodcaster.**"})
@EnableScheduling
@SpringBootApplication
public class TrafficControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrafficControllerApplication.class, args);
	}

}
