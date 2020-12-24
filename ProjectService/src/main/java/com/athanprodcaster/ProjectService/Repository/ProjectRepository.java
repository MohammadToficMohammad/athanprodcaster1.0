package com.athanprodcaster.ProjectService.Repository;

import java.util.List;

import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.athanprodcaster.ProjectService.Entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

	
}