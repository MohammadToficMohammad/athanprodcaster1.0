package com.athanprodcaster.AuthorizationService.Entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//composite key
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleId implements Serializable
{
	private User user;
	private Role role;
	private RoleRestriction roleRestriction;
}
