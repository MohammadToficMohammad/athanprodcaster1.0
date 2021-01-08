package com.athanprodcaster.TrafficController.Services;

import org.springframework.stereotype.Service;

import com.athanprodcaster.TrafficControllerRpcClient.ITrafficControllerClient;
import com.googlecode.jsonrpc4j.JsonRpcService;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;

@Service
@JsonRpcService("/rpc/TrafficContollerRpcService")
@AutoJsonRpcServiceImpl
public class TrafficControllerRpcService implements ITrafficControllerClient {

	@Override
	public void registerTrafficServer(String port) {
		System.out.println(port);
		
	}

}

