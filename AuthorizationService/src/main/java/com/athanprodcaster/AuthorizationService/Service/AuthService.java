package com.athanprodcaster.AuthorizationService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athanprodcaster.AuthorizationService.Entities.Role;
import com.athanprodcaster.AuthorizationService.Entities.RoleRestriction;
import com.athanprodcaster.AuthorizationService.Entities.User;
import com.athanprodcaster.AuthorizationService.Repository.RoleRepository;
import com.athanprodcaster.AuthorizationService.Repository.RoleRestrictionRepository;
import com.athanprodcaster.AuthorizationService.Repository.UserRepository;

@Service
public class AuthService implements IAuthService {


	private RoleRepository _RoleRepository;

	private UserRepository _UserRepository;

	private RoleRestrictionRepository _RoleRestrictionRepo;
	

	@Autowired
	public AuthService(RoleRepository roleRepository,
			UserRepository userRepository,
			RoleRestrictionRepository roleRestrictionRepo) 
	{
		_RoleRepository=roleRepository;
		_UserRepository=userRepository;
		_RoleRestrictionRepo=roleRestrictionRepo;
		
	}
	
	@Override
	public User getUserById(long userId)
	{
		return _UserRepository.findById(userId).get();
	}

	@Override
	public List<Role> getUserRolesOnRestriction(long userId, long roleRestrictionId)
	{
		return _RoleRepository.getUserRolesOnRestriction(userId,roleRestrictionId);
	}

	@Override
	public List<Role> getUserAllRoles(long userId) 
	{
	   return _RoleRepository.getUserAllRoles(userId);
	}

	@Override
	public Role createRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRole(long roleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role createRoleRestriction(RoleRestriction roleRestriction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRoleRestriction(long roleRestrictionId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(long userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRoleToUser(long userId, long roleId, long roleRestrictionId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeRoleFromUser(long userId, long roleId, long roleRestrictionId) {
		// TODO Auto-generated method stub
		
	}

}
