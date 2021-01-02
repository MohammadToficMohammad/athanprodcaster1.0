package com.athanprodcaster.ZuulGateway;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.athanprodcaster.ZuulGateway.Dtos.Token;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	public ResponseEntity<LoginDto> test1(@RequestBody LoginDto loginDto) throws Exception 
	{
		System.out.println("MQTT1 controller email"+loginDto.email);
		var rpcResult=authService.loginUser(loginDto.email, loginDto.password);
		var result=new LoginDto();
		result.email=loginDto.email;
		result.success=rpcResult.success;
		if(rpcResult.success==false)
		{	
		   result.message="login failure" ;
		   return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		else
		{
			result.message="login success";
			//result.token=Token.getToken(new Timestamp(System.currentTimeMillis()+(1000 * 60 * 60 * 3)), rpcResult, "iamsecret");
			var now=System.currentTimeMillis();
			var h3now=now+(1000 * 60 * 60 * 3);
			var expireStamp=h3now < SecretContainer.expireTimestamp ? h3now : SecretContainer.expireTimestamp;
			//result.token=Token.createJWT(expireStamp, rpcResult,SecretContainer.secret);
		    result.token=Token.createRsaJWT(expireStamp, rpcResult,SecretContainer.rsaPrivateKey);
			result.expireTimestamp=expireStamp;
			//System.out.println(Token.decodeJWT(result.token, SecretContainer.secret).message);
			System.out.println(Token.decodeRsaJWT(result.token, SecretContainer.rsaPublicKey).message);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
	
	}
	
	
	
	
}
