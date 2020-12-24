package com.athanprodcaster.AuthorizationService.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;

	@Column
	private String name;

	@Column
	private String email="NotSet";
	

	@Column
	private String note="NotSet";


	@OneToMany(mappedBy = "user",cascade =CascadeType.ALL)
    public List<UserRole> userRoles=new ArrayList<UserRole>();
    //public Set<UserRole> userRoles=new HashSet<UserRole>();//lombok has bug


}
