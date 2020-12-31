package com.athanprodcaster.AuthorizationServiceRpcClient.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class LoginResultDto {
	
	public boolean success;
	public String message;
	public UserDto user;


}
