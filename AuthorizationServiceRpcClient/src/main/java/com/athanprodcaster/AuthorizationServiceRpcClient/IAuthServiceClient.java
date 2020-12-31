package com.athanprodcaster.AuthorizationServiceRpcClient;

import java.util.List;

import com.athanprodcaster.AuthorizationServiceRpcClient.Dtos.LoginResultDto;
import com.athanprodcaster.AuthorizationServiceRpcClient.Dtos.RoleDto;




public interface IAuthServiceClient
{
	
	public List<RoleDto> getUserRolesOnRestriction(long userId,long roleRestrictionId);
	
	public LoginResultDto loginUser(String email,String password);
	

}
