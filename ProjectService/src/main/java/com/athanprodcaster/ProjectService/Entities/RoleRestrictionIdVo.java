package com.athanprodcaster.ProjectService.Entities;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class RoleRestrictionIdVo 
{
	private long  roleRestrictionId;
}
