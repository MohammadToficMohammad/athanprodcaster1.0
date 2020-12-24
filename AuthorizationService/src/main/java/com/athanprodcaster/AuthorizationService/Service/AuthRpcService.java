package com.athanprodcaster.AuthorizationService.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Service;

import com.athanprodcaster.AuthorizationService.Entities.Role;
import com.athanprodcaster.AuthorizationServiceRpcClient.IAuthServiceClient;
import com.athanprodcaster.AuthorizationServiceRpcClient.VOs.RoleVo;
import com.athanprodcaster.LogglyEvents.LogglyEventsLogger;
import com.googlecode.jsonrpc4j.JsonRpcService;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;

import brave.propagation.TraceContextOrSamplingFlags;
import brave.propagation.TraceIdContext;
 
@Service
@JsonRpcService("/rpc/AuthRpcService")
@AutoJsonRpcServiceImpl
public class AuthRpcService implements IAuthServiceClient{
	

	private AuthService _AuthService;

	private LogglyEventsLogger _Logger;

	Tracer tracer;
	
	@Autowired
	public AuthRpcService(AuthService authService,LogglyEventsLogger logger,Tracer _tracer) 
	{
		_AuthService = authService;
		_Logger=logger;
		tracer=_tracer;
		
	}
	
	
	
	@Override
	public List<RoleVo> getUserRolesOnRestriction(long userId, long roleRestrictionId) {

		_Logger.Log("AuthRpcService rpc getUserRolesOnRestriction userId:"+userId+" roleRestrictionId:"+roleRestrictionId);
		var listRoles=_AuthService.getUserRolesOnRestriction(userId, roleRestrictionId);
		var listRoleVos=listRoles.stream().map(role -> getRoleVo(role)).collect(Collectors.toList());
		return listRoleVos;
	}

	
	private RoleVo getRoleVo(Role role) 
	{
		RoleVo vo=new RoleVo(role.getName());
		return vo;
	}
}
