package com.athanprodcaster.ZuulGateway.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto
{
	public String email;
	public String password;
	
}
