package com.athanprodcaster.AuthorizationServiceRpcClient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.athanprodcaster.AuthorizationServiceRpcClient.Dtos.LoginResultDto;
import com.athanprodcaster.AuthorizationServiceRpcClient.Dtos.RoleDto;
import com.athanprodcaster.LogglyEvents.LogglyEventsLogger;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;

public class AuthServiceClient implements IAuthServiceClient {

	private LogglyEventsLogger _Logger;
	private Tracer tracer;
	private String baseUrl;
	
	@Bean 
	void test() 
	{
		
		System.out.println("bean test");
	}
	

	public AuthServiceClient(String _baseUrl, LogglyEventsLogger logger, Tracer _tracer) throws MalformedURLException {
		_Logger = logger;
		tracer = _tracer;
		baseUrl = _baseUrl;
	}

	@Override
	public List<RoleDto> getUserRolesOnRestriction(long userId, long roleRestrictionId) {
		_Logger.Log("AuthServiceClient rpc getUserRolesOnRestriction userId:" + userId + " roleRestrictionId:"
				+ roleRestrictionId);
		var _AuthService = getRpcClient();
		return _AuthService.getUserRolesOnRestriction(userId, roleRestrictionId);
	}
	
	
	@Override
	public LoginResultDto loginUser(String email, String password) {
		_Logger.Log("AuthServiceClient rpc loginUser email:" + email );
		System.out.println("MQTT1 AuthServiceClient email"+email);
		var _AuthService = getRpcClient();
		return _AuthService.loginUser(email, password);
	}
	
	

	private IAuthServiceClient getRpcClient() {

		JsonRpcHttpClient rpcClient = null;
		try {
			rpcClient = new JsonRpcHttpClient(new URL(baseUrl + "/rpc/AuthRpcService"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		IAuthServiceClient authService = ProxyUtil.createClientProxy(getClass().getClassLoader(),
				IAuthServiceClient.class, rpcClient);

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

		return authService;
	}




}
