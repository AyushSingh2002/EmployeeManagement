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

/**
 * Controller for handling Project Entities
 */

@RestController
@RequestMapping("/project")
public class ProjectController 
{
  @Autowired
  ProjectService projectService;

  @PostMapping("/add-project")
  /**
   * Method for adding Project Record in database
   * @param project
   * @return ResponseEntity<String>
   */
  public ResponseEntity<String> addProject(@RequestBody ProjectEntity project)
  {
    return projectService.addProject(project);
  }

  @GetMapping("/get-all-projects")
  /**
   * Method to fetch all Project Records from datbase
   * @return ReponseEntity<List<ProjectEntity>>
   */
  public ResponseEntity<List<ProjectEntity>> getAllProjects()
  {
    return projectService.getAllProjects();
  }

  @PutMapping("/update-by-id/{id}")
  /**
   * Method to update existing project records in database
   * @param projectId
   * @param updatedProject
   * @return ResponseEntity<String>
   */
  public ResponseEntity<String> updateById(@PathVariable("id") Long id, @RequestBody ProjectEntity updatedProject)
  {
    return projectService.updateById(id, updatedProject);
  }

  @DeleteMapping("delete-by-id/{id}")
  /**
   * Method to delete existing record from database
   * @param id
   * @return ResponseEntity<String>
   */
  public ResponseEntity<String> deleteById(@PathVariable("id") Long id)
  {
    return projectService.deleteById(id);
  }
}
