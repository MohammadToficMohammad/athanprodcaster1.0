package com.athanprodcaster.AuthorizationService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.athanprodcaster.AuthorizationService.Entities.Role;
import com.athanprodcaster.AuthorizationService.Entities.RoleRestriction;
import com.athanprodcaster.AuthorizationService.Entities.User;
import com.athanprodcaster.AuthorizationService.Entities.UserRole;
import com.athanprodcaster.AuthorizationService.Repository.RoleRepository;
import com.athanprodcaster.AuthorizationService.Repository.RoleRestrictionRepository;
import com.athanprodcaster.AuthorizationService.Repository.UserRepository;
import com.athanprodcaster.LogglyEvents.LogglyEventsLogger;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;


@Configuration
public class DbInitializer implements ApplicationRunner {

	

    @Autowired
    RoleRepository _RoleRepository;
    

    @Autowired
    UserRepository _UserRepository;
    

    @Autowired
    RoleRestrictionRepository _RoleRestrictionRepository;
    
    @Autowired
    LogglyEventsLogger logger;
    


 
/*
   @Bean
   public void initDb() {
	   
	   ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	   scheduler.schedule(() -> {
		   
		   System.out.println("hihi");
		   var role1=new Role();
		  	role1.setName("role1");
		  	var role2=new Role();
		  	role2.setName("role2");
		  	role1=_RoleRepository.save(role1);
		  	role2=_RoleRepository.save(role2);
			
			var user1=new User();
			user1.setName("Mohammad");
			var user2=new User();
			user2.setName("Zaher");
			user1=_UserRepository.save(user1);
			user2=_UserRepository.save(user2);
			
			var rr1=new RoleRestriction(); 
			rr1.setName("prj1");
			var rr2=new RoleRestriction(); 
			rr2.setName("prj2");
			rr1=_RoleRestrictionRepository.save(rr1);
			rr2=_RoleRestrictionRepository.save(rr2);
			
			var ur1=new UserRole();
			ur1.setRole(role1);
			ur1.setRoleRestriction(rr1);
			ur1.setUser(user1);
			
			// User is root for userrole
			user1.userRoles.add(ur1);
			user1=_UserRepository.save(user1);
			 System.out.println("hihi");
	   }, 5, TimeUnit.SECONDS);
   }
*/
	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
		
		logger.Log("init db...");
		  System.out.println("hihi");
		   var role1=new Role();
		  	role1.setName("role1");
		  	var role2=new Role();
		  	role2.setName("role2");
		  	role1=_RoleRepository.save(role1);
		  	role2=_RoleRepository.save(role2);
			
			var user1=new User();
			user1.setName("Mohammad");
			var user2=new User();
			user2.setName("Zaher");
			user1=_UserRepository.save(user1);
			user2=_UserRepository.save(user2);
			
			var rr1=new RoleRestriction(); 
			rr1.setName("prj1");
			var rr2=new RoleRestriction(); 
			rr2.setName("prj2");
			rr1=_RoleRestrictionRepository.save(rr1);
			rr2=_RoleRestrictionRepository.save(rr2);
			
			var ur1=new UserRole();
			ur1.setRole(role1);
			ur1.setRoleRestriction(rr1);
			ur1.setUser(user1);
			
			// User is root for userrole
			user1.userRoles.add(ur1);
			user1=_UserRepository.save(user1);
	}
}
