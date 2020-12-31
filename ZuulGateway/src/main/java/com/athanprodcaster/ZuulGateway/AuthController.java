package com.athanprodcaster.ZuulGateway;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athanprodcaster.AuthorizationServiceRpcClient.IAuthServiceClient;
import com.athanprodcaster.AuthorizationServiceRpcClient.Dtos.LoginResultDto;
import com.athanprodcaster.AuthorizationServiceRpcClient.Dtos.RoleDto;
import com.athanprodcaster.ZuulGateway.Dtos.LoginDto;

import jdk.jfr.TransitionFrom;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@CrossOrigin
@RestController
@RequestMapping("/auth")
@Controller
public class AuthController {
	
	@Autowired
	IAuthServiceClient authService;

	@GetMapping("/test") 
	public String test() 
	{
		return "ok";
	}
	
	@PostMapping("/login") 
	public LoginResultDto test1(@RequestBody LoginDto loginDto) 
	{
		System.out.println("MQTT1 controller email"+loginDto.email);
		var result=authService.loginUser(loginDto.email, loginDto.password);
		return result;
	}
	
	
	
	
}
