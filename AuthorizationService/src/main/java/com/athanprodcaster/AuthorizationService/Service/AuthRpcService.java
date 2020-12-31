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
import com.athanprodcaster.AuthorizationServiceRpcClient.Dtos.LoginResultDto;
import com.athanprodcaster.AuthorizationServiceRpcClient.Dtos.RoleDto;
import com.athanprodcaster.AuthorizationServiceRpcClient.Dtos.UserDto;
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
	public List<RoleDto> getUserRolesOnRestriction(long userId, long roleRestrictionId) {

		_Logger.Log("AuthRpcService rpc getUserRolesOnRestriction userId:"+userId+" roleRestrictionId:"+roleRestrictionId);
		var listRoles=_AuthService.getUserRolesOnRestriction(userId, roleRestrictionId);
		var listRoleVos=listRoles.stream().map(role -> getRoleDto(role)).collect(Collectors.toList());
		return listRoleVos;
	}

	
	private RoleDto getRoleDto(Role role) 
	{
		RoleDto vo=new RoleDto(role.getRoleId(),role.getName());
		return vo;
	}



	@Override
	public LoginResultDto loginUser(String email,String password) {
		System.out.println("MQTT1 rpcserver email"+email); 
		LoginResultDto result=new  LoginResultDto();
		
		var user=_AuthService.getUserByEmail(email);
		if(user.isEmpty()) 
		{
			result.success=false;
			result.message="User not found";
			return result;
		}
		
		if(!user.get().getPassword().equals(password)) 
		{
			result.success=false;
			result.message="Wrong Password or Email";
			return result;
		}
		
		
		result.success=true;
		result.message="login success..";
		var userDto=new UserDto();
		userDto.userId=user.get().getUserId();
		userDto.name=user.get().getName();
		userDto.email=user.get().getEmail();
		userDto.roles=_AuthService.getAllUserRoleDtos(user.get().getUserId());
		result.user=userDto;
		
		return result;
	}
}
