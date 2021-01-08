package com.athanprodcaster.TrafficServer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;

@Component
public class RpcInitializer {

	 @Bean
	   public AutoJsonRpcServiceImplExporter getAutoJsonRpcServiceImplExporter() 
	   {
		   
		   return new AutoJsonRpcServiceImplExporter();
	   }
	
}
