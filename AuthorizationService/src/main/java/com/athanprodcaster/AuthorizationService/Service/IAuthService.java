package com.athanprodcaster.AuthorizationService.Service;

import java.util.List;
import java.util.Optional;

import com.athanprodcaster.AuthorizationService.Entities.Role;
import com.athanprodcaster.AuthorizationService.Entities.RoleRestriction;
import com.athanprodcaster.AuthorizationService.Entities.User;
import com.athanprodcaster.AuthorizationServiceRpcClient.Dtos.UserRoleDto;


public interface IAuthService {
	
	public Optional<User> getUserById(long userId);
	public Optional<User> getUserByEmail(String email);
	public List<Role> getUserRolesOnRestriction(long userId,long roleRestrictionId);
	public List<Role> getUserAllRoles(long userId);
	public List<UserRoleDto> getAllUserRoleDtos(long userId) ;
	public Role createRole(Role role);
	public void deleteRole(long roleId);
	public Role createRoleRestriction(RoleRestriction roleRestriction);
	public void deleteRoleRestriction(long roleRestrictionId);
	public User createUser(User user);
	public void deleteUser(long userId);
	public void addRoleToUser(long userId,long roleId,long roleRestrictionId);
	public void removeRoleFromUser(long userId,long roleId,long roleRestrictionId);
	
}
