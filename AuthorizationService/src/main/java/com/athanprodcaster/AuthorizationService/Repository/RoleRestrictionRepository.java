package com.athanprodcaster.AuthorizationService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.athanprodcaster.AuthorizationService.Entities.RoleRestriction;



@Repository
public interface RoleRestrictionRepository extends JpaRepository<RoleRestriction, Long>{

}