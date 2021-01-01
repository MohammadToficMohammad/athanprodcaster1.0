package com.athanprodcaster.LogglyEvents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class LogglyEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogglyEventsApplication.class, args);
	}

}
