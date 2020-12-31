package com.athanprodcaster.AuthorizationService.Entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//composite key
@Getter //data causes problems because of tostring https://stackoverflow.com/questions/54570757/stack-overflow-on-hibernate-caused-by-one-to-many-relationship
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleId implements Serializable
{
	private User user;
	private Role role;
	private RoleRestriction roleRestriction;
}
