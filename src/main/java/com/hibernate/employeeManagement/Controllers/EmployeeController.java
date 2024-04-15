package com.hibernate.employeeManagement.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.hibernate.employeeManagement.Services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
  @Autowired
  EmployeeService employeeService;
  
  @PostMapping("/add-employee")
  public ResponseEntity<String> addEmployee(@RequestBody EmployeeEntity employee)
  {
    return employeeService.addEmployee(employee);
  }

  @GetMapping("/get-all-employees")
  public ResponseEntity<List<EmployeeEntity>> getAllEmployees()
  {
    return employeeService.getAllEmployees();
  }

  @PutMapping("/update-by-id/{id}")
  public ResponseEntity<String> updateById(@PathVariable("id") Long id, @RequestBody EmployeeEntity updatedEmployee)
  {
    return employeeService.updateById(id, updatedEmployee);
  }

  @DeleteMapping("/delete-by-id/{id}")
  public ResponseEntity<String> deleteById(@PathVariable("id") Long id)
  {
    return employeeService.deleteById(id);
  }
}
