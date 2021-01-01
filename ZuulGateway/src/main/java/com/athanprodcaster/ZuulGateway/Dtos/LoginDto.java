package com.athanprodcaster.ZuulGateway.Dtos;

import java.util.Date;

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
	public boolean success;
	public String message;
	public String token;
	public long expireTimestamp;
	
}

