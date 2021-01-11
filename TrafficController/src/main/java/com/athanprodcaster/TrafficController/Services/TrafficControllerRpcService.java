package com.athanprodcaster.TrafficController.Services;

import org.springframework.stereotype.Service;

import com.athanprodcaster.TrafficController.Cache;
import com.athanprodcaster.TrafficControllerRpcClient.ITrafficControllerClient;
import com.athanprodcaster.TrafficControllerRpcClient.Dtos.TsServer;
import com.googlecode.jsonrpc4j.JsonRpcService;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;

@Service
@JsonRpcService("/rpc/TrafficContollerRpcService")
@AutoJsonRpcServiceImpl
public class TrafficControllerRpcService implements ITrafficControllerClient {

	@Override
	public void registerTrafficServer(TsServer tsServer) {
		System.out.println("New traffic server registered "+tsServer.socketUrl);
		Cache.tsServers.add(tsServer);
		
	}

}

