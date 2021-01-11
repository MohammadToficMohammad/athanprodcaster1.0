package com.athanprodcaster.AthanProdcasterSlave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class AthanProdcasterSlaveApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(AthanProdcasterSlaveApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}

}
