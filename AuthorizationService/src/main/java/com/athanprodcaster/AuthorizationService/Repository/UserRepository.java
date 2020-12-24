package com.athanprodcaster.AuthorizationService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.athanprodcaster.AuthorizationService.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
