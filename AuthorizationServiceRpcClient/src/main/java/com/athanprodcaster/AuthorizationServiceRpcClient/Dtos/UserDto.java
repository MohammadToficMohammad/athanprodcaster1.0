package com.athanprodcaster.AuthorizationServiceRpcClient.Dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	public long userId;
	
	public String name;
	
	public String email;
	
	public List<UserRoleDto> roles;

}
