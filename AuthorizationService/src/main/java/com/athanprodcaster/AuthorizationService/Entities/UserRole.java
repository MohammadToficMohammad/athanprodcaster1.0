package com.athanprodcaster.AuthorizationService.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@IdClass(UserRoleId.class)
@Table(indexes = {
		  @Index(name = "userId_index", columnList = "USER_ID"),
		  @Index(name = "userId_RoleRestriction_index", columnList = "USER_ID, ROLE_RESTRICTION_ID"),
		 // @Index(name = "uniqueIndex", columnList = "firstName", unique = true),
		 // @Index(name = "uniqueMulitIndex", columnList = "firstName, lastName", unique = true)
		})
public class UserRole
{
	@Id
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	@Id
	@ManyToOne
	@JoinColumn(name="ROLE_ID")
	private Role role;
	
	@Id
	@ManyToOne
	@JoinColumn(name="ROLE_RESTRICTION_ID")
	private RoleRestriction roleRestriction;
}