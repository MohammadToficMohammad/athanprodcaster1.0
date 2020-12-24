package com.athanprodcaster.ProjectService.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mosque {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long mosqueId;

	@Column
	private String name;
	
	@Column
	private String note;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	private Project  project;
	
	@Column
	private RoleRestrictionIdVo  roleRestrictionId;
}