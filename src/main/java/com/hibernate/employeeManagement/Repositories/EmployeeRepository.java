package com.hibernate.employeeManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.employeeManagement.Entities.EmployeeEntity;

/**
 * Repository interface for Employee Entity
 */

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>
{
  
}
