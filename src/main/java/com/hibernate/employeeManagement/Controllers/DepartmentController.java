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

@RestController
@RequestMapping("/department")
public class DepartmentController 
{
  @Autowired
  DepartmentService deptService;

  @PostMapping("/add-department")
  public ResponseEntity<String> addDepartment(@RequestBody DepartmentEntity department)
  {
    return deptService.addDepartment(department);
  }

  @GetMapping("/get-all-departments")
  public ResponseEntity<List<DepartmentEntity>> getAllDepartments()
  {
    return deptService.getAllDepartments();
  }

  @PutMapping("/update-by-id/{id}")
  public ResponseEntity<String> updateById(@PathVariable("id") Long id, @RequestBody DepartmentEntity updatedDepartment)
  {
    return deptService.updateById(id, updatedDepartment);
  }

  @DeleteMapping("/delete-by-id/{id}")
  public ResponseEntity<String> deleteById(@PathVariable("id") Long id)
  {
    return deptService.deleteById(id);
  }
}
