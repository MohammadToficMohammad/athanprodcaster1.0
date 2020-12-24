package com.athanprodcaster.ProjectService.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long projectId;

	@Column
	private String name;
	
	@Column
	private String note;
	
	@OneToMany(mappedBy = "project",cascade =CascadeType.ALL,fetch = FetchType.EAGER)
	public List<Mosque> mosques = new ArrayList<>();
	
	@Column
	private RoleRestrictionIdVo  roleRestrictionId;
}

 
