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

import com.hibernate.employeeManagement.Entities.ProjectEntity;
import com.hibernate.employeeManagement.Services.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController 
{
  @Autowired
  ProjectService projectService;

  @PostMapping("/add-project")
  public ResponseEntity<String> addProject(@RequestBody ProjectEntity project)
  {
    return projectService.addProject(project);
  }

  @GetMapping("/get-all-projects")
  public ResponseEntity<List<ProjectEntity>> getAllProjects()
  {
    return projectService.getAllProjects();
  }

  @PutMapping("/update-by-id/{id}")
  public ResponseEntity<String> updateById(@PathVariable("id") Long id, @RequestBody ProjectEntity updatedProject)
  {
    return projectService.updateById(id, updatedProject);
  }

  @DeleteMapping("delete-by-id/{id}")
  public ResponseEntity<String> deleteById(@PathVariable("id") Long id)
  {
    return projectService.deleteById(id);
  }
}
