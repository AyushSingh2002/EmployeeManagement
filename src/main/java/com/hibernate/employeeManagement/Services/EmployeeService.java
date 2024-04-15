package com.hibernate.employeeManagement.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hibernate.employeeManagement.Entities.EmployeeEntity;
import com.hibernate.employeeManagement.Repositories.EmployeeRepository;

@Service
public class EmployeeService 
{
  @Autowired
  EmployeeRepository empRepo;

  public ResponseEntity<String> addEmployee(EmployeeEntity employee)
  {
    empRepo.save(employee);
    return new ResponseEntity<>("Employee details added to database!", HttpStatus.OK);
  }

  public ResponseEntity<List<EmployeeEntity>> getAllEmployees()
  {
    List<EmployeeEntity> employees = empRepo.findAll();
    return new ResponseEntity<>(employees, HttpStatus.OK);
  }

  public ResponseEntity<String> updateById(Long id, EmployeeEntity updatedEmployee)
  {
    Optional<EmployeeEntity> optionalEmployee = empRepo.findById(id);
    if(optionalEmployee.isPresent())
    {
      EmployeeEntity employee = optionalEmployee.get();
      employee.setName(updatedEmployee.getName());
      employee.setDateOfBirth(updatedEmployee.getDateOfBirth());
      employee.setSalary(updatedEmployee.getSalary());
      employee.setContactNumber(updatedEmployee.getContactNumber());
      employee.setEmail(updatedEmployee.getEmail());
      employee.setAddress(updatedEmployee.getAddress());
      employee.setDepartment(updatedEmployee.getDepartment());
      empRepo.save(employee);
      return new ResponseEntity<>("Employee details updated in database!", HttpStatus.OK);
    }
    else
    {
      return new ResponseEntity<>("Requested details not found! Employee Id : " + id, HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<String> deleteById(Long id)
  {
    Optional<EmployeeEntity> optionalEmployee = empRepo.findById(id);
    if(optionalEmployee.isPresent())
    {
      empRepo.deleteById(id);
      return new ResponseEntity<>("Employee details removed from database!", HttpStatus.OK);
    }
    else
    {
      return new ResponseEntity<>("Requested details not found! Employee Id : " + id, HttpStatus.NOT_FOUND);
    }
  }  
}
