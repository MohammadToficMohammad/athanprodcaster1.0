package com.athanprodcaster.TrafficControllerRpcClient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.springframework.cloud.sleuth.Tracer;
import org.springframework.context.annotation.Bean;

import com.athanprodcaster.LogglyEvents.LogglyEventsLogger;
import com.athanprodcaster.TrafficControllerRpcClient.Dtos.TsServer;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;

public class TrafficControllerClient implements ITrafficControllerClient {

	private LogglyEventsLogger _Logger;
	private Tracer tracer;
	private String baseUrl;
	
	@Bean 
	void test() 
	{
		
		System.out.println("bean test");
	}
	

	public TrafficControllerClient(String _baseUrl, LogglyEventsLogger logger, Tracer _tracer) throws MalformedURLException {
		_Logger = logger;
		tracer = _tracer;
		baseUrl = _baseUrl;
	}

	
	
	
	
	@Override
	public void registerTrafficServer(TsServer tsServer) {
		_Logger.Log("TrafficControllerClient rpc registerTrafficServer");
		System.out.println("TrafficControllerClient rpc registerTrafficServer");
		var service = getRpcClient();
	    service.registerTrafficServer(tsServer);
		
	}
	
	

	private ITrafficControllerClient getRpcClient() {

		JsonRpcHttpClient rpcClient = null;
		try {
			rpcClient = new JsonRpcHttpClient(new URL(baseUrl + "/rpc/TrafficContollerRpcService"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ITrafficControllerClient Service = ProxyUtil.createClientProxy(getClass().getClassLoader(),
				ITrafficControllerClient.class, rpcClient);

		// set sleuth Headers
		HashMap<String, String> map = new HashMap<String, String>();
		if (tracer.currentSpan() != null && tracer.currentSpan().context() != null) {
			map.put("x-b3-traceid", tracer.currentSpan().context().traceId());
			map.put("x-b3-spanid", tracer.currentSpan().context().spanId());
		} else {

			map.put("x-b3-traceid", "NotAvaliable");
			map.put("x-b3-spanid", "NotAvaliable");
		}
		rpcClient.setHeaders(map);

		return Service;
	}



}
