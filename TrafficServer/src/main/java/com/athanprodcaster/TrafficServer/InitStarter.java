package com.athanprodcaster.TrafficServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//import com.athanprodcaster.TrafficControllerRpcClient.ITrafficControllerClient;
//import com.athanprodcaster.TrafficControllerRpcClient.Dtos.TsServer;

@Configuration
public class InitStarter {
	
	@Value("${TsAddressProp}")
	public String TsAddress;
	
	@Value("${TsNameProp}")
	public String name;
	
	//@Autowired 
	//ITrafficControllerClient _TrafficControllerClient;
	
	/*
	@Bean
	void init() 
	{
		TsServer tsServer=new TsServer();
		tsServer.name=name;
		tsServer.socketUrl=TsAddress;
		_TrafficControllerClient.registerTrafficServer(tsServer);
	}
	*/

}
