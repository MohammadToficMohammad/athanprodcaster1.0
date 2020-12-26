package com.athanprodcaster.ProjectServiceRpcClient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.springframework.cloud.sleuth.Tracer;
import org.springframework.context.annotation.Bean;

import com.athanprodcaster.LogglyEvents.LogglyEventsLogger;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;

public class ProjectServiceClient implements IProjectServiceClient{

	private LogglyEventsLogger _Logger;
	private Tracer tracer;
	private String baseUrl;
	
	@Bean 
	void test() 
	{
		
		System.out.println("bean test");
	}
	

	public ProjectServiceClient(String _baseUrl, LogglyEventsLogger logger, Tracer _tracer) throws MalformedURLException {
		_Logger = logger;
		tracer = _tracer;
		baseUrl = _baseUrl;
	}

	

	private IProjectServiceClient getRpcClient() {

		JsonRpcHttpClient rpcClient = null;
		try {
			rpcClient = new JsonRpcHttpClient(new URL(baseUrl + "/rpc/{ProjectRpcService"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		IProjectServiceClient Service = ProxyUtil.createClientProxy(getClass().getClassLoader(),
				IProjectServiceClient.class, rpcClient);

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
