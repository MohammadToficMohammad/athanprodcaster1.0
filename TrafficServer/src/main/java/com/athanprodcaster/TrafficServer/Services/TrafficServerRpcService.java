package com.athanprodcaster.TrafficServer.Services;

import org.springframework.stereotype.Service;

import com.athanprodcaster.TrafficServerRpcClient.ITrafficServerClient;
import com.googlecode.jsonrpc4j.JsonRpcService;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;


@Service
@JsonRpcService("/rpc/TrafficServerRpcService")
@AutoJsonRpcServiceImpl
public class TrafficServerRpcService implements ITrafficServerClient {

	@Override
	public void sendCommandToTs(String cmd) {
		System.out.println("Ts recv command: "+cmd );
		
	}

}
