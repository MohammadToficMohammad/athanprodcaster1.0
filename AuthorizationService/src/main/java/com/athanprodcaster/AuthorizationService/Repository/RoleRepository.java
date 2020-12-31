package com.athanprodcaster.AuthorizationService.Repository;

import java.util.List;

import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.athanprodcaster.AuthorizationService.Entities.Role;
import com.athanprodcaster.AuthorizationServiceRpcClient.Dtos.UserRoleDto;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	@Transient
	@Query("SELECT r FROM Role r INNER JOIN UserRole ur ON r.roleId=ur.role.id AND ur.user.userId = :userId AND ur.roleRestriction.roleRestrictionId = :roleRestrictionId ")
	public List<Role> getUserRolesOnRestriction(long userId,long roleRestrictionId);
	
	@Transient
	@Query("SELECT r FROM Role r INNER JOIN UserRole ur ON r.roleId=ur.role.id AND ur.user.userId = :userId")
	public List<Role> getUserAllRolesAsRoles(long userId);
	
	@Transient
	@Query("SELECT new com.athanprodcaster.AuthorizationServiceRpcClient.Dtos.UserRoleDto(r.roleId,r.name,ur.roleRestriction.roleRestrictionId) FROM Role r INNER JOIN UserRole ur ON r.roleId=ur.role.id AND ur.user.userId = :userId")
	public List<UserRoleDto> getUserAllRolesAsUserRoleDtos(long userId);
	
	
}