package com.athanprodcaster.AuthorizationService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athanprodcaster.AuthorizationService.Entities.Role;
import com.athanprodcaster.AuthorizationService.Service.AuthService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/tests")
@Slf4j
@Controller
public class TestController 
{
	
	@Autowired
	AuthService authService;
	
	
	
	@GetMapping("/{userId}/{restrictId}") 
	public ResponseEntity<List<Role>> getUserRoles(@PathVariable("userId") long userId,@PathVariable("restrictId") long restrictId) 
	{
		return ResponseEntity.ok(authService.getUserRolesOnRestriction(userId, restrictId));
	}
	
	
	
	
	
}
