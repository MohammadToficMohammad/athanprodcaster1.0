package com.athanprodcaster.AthanProdcasterMaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AthanProdcasterMasterApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(AthanProdcasterMasterApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}

}
