package com.hibernate.employeeManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.employeeManagement.Entities.DepartmentEntity;

/**
 * Repository Interface for Department Entity
 */

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> 
{
  
}
