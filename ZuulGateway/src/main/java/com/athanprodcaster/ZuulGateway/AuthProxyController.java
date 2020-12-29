package com.athanprodcaster.ZuulGateway;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@CrossOrigin
@RestController
@RequestMapping("/authproxy")
@Controller
public class AuthProxyController {

	@GetMapping("/test") 
	public String test() 
	{
		return "ok";
	}
	
	
	
}
