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

/**
 * Controller for Handling Employee Entities
 */

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
  @Autowired
  EmployeeService employeeService;
  
  @PostMapping("/add-employee")
  /**
   * Method for adding Employee Record in database
   * @param employee
   * @return ResponseEntity<String>
   */
  public ResponseEntity<String> addEmployee(@RequestBody EmployeeEntity employee)
  {
    return employeeService.addEmployee(employee);
  }

  @GetMapping("/get-all-employees")
  /**
   * Method to fetch all Employee Records from database
   * @return ResponseEntity<List<EmployeeEntity>>
   */
  public ResponseEntity<List<EmployeeEntity>> getAllEmployees()
  {
    return employeeService.getAllEmployees();
  }

  @PutMapping("/update-by-id/{id}")
  /**
   * Method to update existing Employee record in database
   * @param id
   * @param updatedEmployee
   * @return ResponseEntity<String>
   */
  public ResponseEntity<String> updateById(@PathVariable("id") Long id, @RequestBody EmployeeEntity updatedEmployee)
  {
    return employeeService.updateById(id, updatedEmployee);
  }

  @DeleteMapping("/delete-by-id/{id}")
  /**
   * Method for removing existing Employee Record from database
   * @param id
   * @return ResponseEntity<String>
   */
  public ResponseEntity<String> deleteById(@PathVariable("id") Long id)
  {
    return employeeService.deleteById(id);
  }
}
