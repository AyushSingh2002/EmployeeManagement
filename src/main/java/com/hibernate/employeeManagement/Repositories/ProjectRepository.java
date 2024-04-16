package com.hibernate.employeeManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.employeeManagement.Entities.ProjectEntity;

/**
 * Repository Interface for Project Entity
 */

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long>
{
  
}
