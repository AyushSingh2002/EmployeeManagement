package com.hibernate.employeeManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.employeeManagement.Entities.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long>
{
  
}
