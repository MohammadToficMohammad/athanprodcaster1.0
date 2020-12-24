package com.athanprodcaster.AuthorizationServiceRpcClient;

import java.util.List;

import com.athanprodcaster.AuthorizationServiceRpcClient.VOs.RoleVo;

public interface IAuthServiceClient
{
	
	public List<RoleVo> getUserRolesOnRestriction(long userId,long roleRestrictionId);
	

}
