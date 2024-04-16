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

import com.hibernate.employeeManagement.Entities.DepartmentEntity;
import com.hibernate.employeeManagement.Services.DepartmentService;

/**
 * Controller for Handling Department Entities
 */

@RestController
@RequestMapping("/department")
public class DepartmentController 
{
  @Autowired
  DepartmentService deptService;

  @PostMapping("/add-department")
  /**
     * Method for adding Department record in database
     * @param department
     * @return ResponseEntity<String>
  */
  public ResponseEntity<String> addDepartment(@RequestBody DepartmentEntity department)
  {
    return deptService.addDepartment(department);
  }

  @GetMapping("/get-all-departments")
  /**
   * Method to fetch all Department records from database
   * @return ResponseEntity<List<DepartmentEntity>>
   */
  public ResponseEntity<List<DepartmentEntity>> getAllDepartments()
  {
    return deptService.getAllDepartments();
  }

  @PutMapping("/update-by-id/{id}")
  /**
   * Method to update existing department record in database
   * @param id
   * @param updatedDepartment
   * @return ResponseEntity<String>
   */
  public ResponseEntity<String> updateById(@PathVariable("id") Long id, @RequestBody DepartmentEntity updatedDepartment)
  {
    return deptService.updateById(id, updatedDepartment);
  }

  @DeleteMapping("/delete-by-id/{id}")
  /**
   * Method for deleting existing record from database
   * @param id
   * @return ResponseEntity<String>
   */
  public ResponseEntity<String> deleteById(@PathVariable("id") Long id)
  {
    return deptService.deleteById(id);
  }
}
