package com.athanprodcaster.AuthorizationService.Service;

import java.util.List;

import com.athanprodcaster.AuthorizationService.Entities.Role;
import com.athanprodcaster.AuthorizationService.Entities.RoleRestriction;
import com.athanprodcaster.AuthorizationService.Entities.User;

public interface IAuthService {
	
	public User getUserById(long userId);
	public List<Role> getUserRolesOnRestriction(long userId,long roleRestrictionId);
	public List<Role> getUserAllRoles(long userId);
	public Role createRole(Role role);
	public void deleteRole(long roleId);
	public Role createRoleRestriction(RoleRestriction roleRestriction);
	public void deleteRoleRestriction(long roleRestrictionId);
	public User createUser(User user);
	public void deleteUser(long userId);
	public void addRoleToUser(long userId,long roleId,long roleRestrictionId);
	public void removeRoleFromUser(long userId,long roleId,long roleRestrictionId);

}
