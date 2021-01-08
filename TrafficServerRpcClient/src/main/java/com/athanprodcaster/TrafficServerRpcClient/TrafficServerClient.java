package com.athanprodcaster.TrafficServerRpcClient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.springframework.cloud.sleuth.Tracer;
import org.springframework.context.annotation.Bean;

import com.athanprodcaster.LogglyEvents.LogglyEventsLogger;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;

public class TrafficServerClient implements ITrafficServerClient {

	private LogglyEventsLogger _Logger;
	private Tracer tracer;
	private String baseUrl;
	
	@Bean 
	void test() 
	{
		
		System.out.println("bean test");
	}
	

	public TrafficServerClient(String _baseUrl, LogglyEventsLogger logger, Tracer _tracer) throws MalformedURLException {
		_Logger = logger;
		tracer = _tracer;
		baseUrl = _baseUrl;
	}

	
	
	
	

	private ITrafficServerClient getRpcClient() {

		JsonRpcHttpClient rpcClient = null;
		try {
			rpcClient = new JsonRpcHttpClient(new URL(baseUrl + "/rpc/TrafficServerRpcService"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ITrafficServerClient Service = ProxyUtil.createClientProxy(getClass().getClassLoader(),
				ITrafficServerClient.class, rpcClient);

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


	@Override
	public void sendCommandToTs(String cmd) {
		_Logger.Log("TrafficServerClient rpc sendCommandToTs");
		System.out.println("TrafficServerClient rpc sendCommandToTs");
		var service = getRpcClient();
	    service.sendCommandToTs(cmd);
		
	}



}
