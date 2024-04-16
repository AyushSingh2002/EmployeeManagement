package com.hibernate.employeeManagement.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hibernate.employeeManagement.Entities.DepartmentEntity;
import com.hibernate.employeeManagement.Repositories.DepartmentRepository;

/**
 * Service Class for Department Controller
 */

@Service
public class DepartmentService 
{
  @Autowired
  DepartmentRepository departmentRepo;

  /**
   * Method to add department entity into department repository
   * @param department
   * @return ResponseEntity<String>
   */
  public ResponseEntity<String> addDepartment(DepartmentEntity department)
  {
    departmentRepo.save(department);
    return new ResponseEntity<>("Department added to database!", HttpStatus.OK);
  }

  /**
   * Method to fetch all departments from department repository
   * @return ResponseEntity<List<DepartmentEntity>>
   */
  public ResponseEntity<List<DepartmentEntity>> getAllDepartments()
  {
    List<DepartmentEntity> departments = departmentRepo.findAll();
    return new ResponseEntity<>(departments, HttpStatus.OK);
  }

  /**
   * Method to update existing department in department repository
   * @param id
   * @param updatedDepartment
   * @return ResponseEntity<String>
   */
  public ResponseEntity<String> updateById(Long id, DepartmentEntity updatedDepartment)
  {
    Optional<DepartmentEntity> optionalDept = departmentRepo.findById(id);
    if(optionalDept.isPresent())
    {
      DepartmentEntity department = optionalDept.get();
      department.setDepartmentName(updatedDepartment.getDepartmentName());
      department.setTechnology(updatedDepartment.getTechnology());
      department.setContact(updatedDepartment.getContact());
      department.setAddress(updatedDepartment.getAddress());
      departmentRepo.save(department);
      return new ResponseEntity<>("Department details updated successfully!", HttpStatus.OK);
    }
    else
    {
      return new ResponseEntity<>("Requested details not found! Department ID : " + id, HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Method to delete existing department from department repository
   * @param id
   * @return
   */
  public ResponseEntity<String> deleteById(Long id)
  {
    Optional<DepartmentEntity> optionalDepartment = departmentRepo.findById(id);
    if(optionalDepartment.isPresent())
    {
      departmentRepo.deleteById(id);
      return new ResponseEntity<>("Department details removed from database!", HttpStatus.OK);
    }
    else
    {
      return new ResponseEntity<>("Requested details not found! Department Id : " + id, HttpStatus.NOT_FOUND);
    }
  }
}
