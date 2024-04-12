package com.hibernate.employeeManagement.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.employeeManagement.Entities.DepartmentEntity;
import com.hibernate.employeeManagement.Repositories.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController 
{
  @Autowired
  DepartmentRepository departmentRepo;

  @PostMapping("/add-department")
  public ResponseEntity<String> addDepartment(@RequestBody DepartmentEntity department)
  {
    departmentRepo.save(department);
    return new ResponseEntity<>("Department added to database!", HttpStatus.OK);
  }

  @GetMapping("/get-all-departments")
  public ResponseEntity<List<DepartmentEntity>> getAllDepartments()
  {
    List<DepartmentEntity> departements = departmentRepo.findAll();
    return new ResponseEntity<>(departements, HttpStatus.OK);
  }

  @PutMapping("/update-by-id/{id}")
  public ResponseEntity<String> updateById(@PathVariable("id") Long id, @RequestBody DepartmentEntity updatedDepartment)
  {
    Optional<DepartmentEntity> optionalDepartment = departmentRepo.findById(id);
    if(optionalDepartment.isPresent())
    {
      DepartmentEntity department = optionalDepartment.get();
      department.setDepartmentName(updatedDepartment.getDepartmentName());
      department.setTechnology(updatedDepartment.getTechnology());
      department.setContact(updatedDepartment.getContact());
      department.setAddress(updatedDepartment.getAddress());
      departmentRepo.save(department);
      return new ResponseEntity<>("Department details updated!", HttpStatus.OK);
    }
    else
    {
      return new ResponseEntity<>("Requested details not found! Department Id : " + id, HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/delete-by-id/{id}")
  public ResponseEntity<String> deleteById(@PathVariable("id") Long id)
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
