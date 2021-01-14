package com.athanprodcaster.ZuulGateway;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class WebAppController {

	@RequestMapping(value = "/") 
	public String index() {
		return "index"; 
	}
	
	@RequestMapping(value = "/c1") 
	public String c1() {
		return "ClientOne"; 
	}
	
	@RequestMapping(value = "/c2") 
	public String c2() {
		return "ClientTwo"; 
	}


}
