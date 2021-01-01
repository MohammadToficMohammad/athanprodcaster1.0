package com.athanprodcaster.AuthorizationServiceRpcClient.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class UserRoleDto {

	public long roleId;
	
	public String name;
	
	public long roleRestrictionId;
	
	public String roleRestrictionName;
	
}
