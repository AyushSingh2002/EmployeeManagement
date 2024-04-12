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

import com.hibernate.employeeManagement.Entities.EmployeeEntity;
import com.hibernate.employeeManagement.Repositories.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
  @Autowired
  EmployeeRepository empRepo;
  
  @PostMapping("/add-employee")
  public ResponseEntity<String> addEmployee(@RequestBody EmployeeEntity employee)
  {
    empRepo.save(employee);
    return new ResponseEntity<>("Employee details added to database!", HttpStatus.OK);
  }

  @GetMapping("/get-all-employees")
  public ResponseEntity<List<EmployeeEntity>> getAllEmployees()
  {
    List<EmployeeEntity> employees = empRepo.findAll();
    return new ResponseEntity<>(employees, HttpStatus.OK);
  }

  @PutMapping("/update-by-id/{id}")
  public ResponseEntity<String> updateById(@PathVariable("id") Long id, @RequestBody EmployeeEntity updatedEmployee)
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

  @DeleteMapping("/delete-by-id/{id}")
  public ResponseEntity<String> deleteById(@PathVariable("id") Long id)
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
