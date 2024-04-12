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

import com.hibernate.employeeManagement.Entities.ProjectEntity;
import com.hibernate.employeeManagement.Repositories.ProjectRepository;

@RestController
@RequestMapping("/project")
public class ProjectController 
{
  @Autowired
  ProjectRepository projectRepo;

  @PostMapping("/add-project")
  public ResponseEntity<String> addProject(@RequestBody ProjectEntity project)
  {
    projectRepo.save(project);
    return new ResponseEntity<>("Project added to database!", HttpStatus.OK);
  }

  @GetMapping("/get-all-projects")
  public ResponseEntity<List<ProjectEntity>> getAllProjects()
  {
    List<ProjectEntity> projects = projectRepo.findAll();
    return new ResponseEntity<>(projects, HttpStatus.OK);
  }

  @PutMapping("/update-by-id/{id}")
  public ResponseEntity<String> updateById(@PathVariable("id") Long id, @RequestBody ProjectEntity updatedProject)
  {
    Optional<ProjectEntity> optionalProject = projectRepo.findById(id);
    if(optionalProject.isPresent())
    {
      ProjectEntity project = optionalProject.get();
      project.setTitle(updatedProject.getTitle());
      project.setDescription(updatedProject.getDescription());
      project.setStartDate(updatedProject.getStartDate());
      project.setEndDate(updatedProject.getEndDate());
      projectRepo.save(project);
      return new ResponseEntity<>("Project details updated!", HttpStatus.OK);
    }
    else
    {
      return new ResponseEntity<>("Requested details not found! Project Id : " + id, HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("delete-by-id/{id}")
  public ResponseEntity<String> deleteById(@PathVariable("id") Long id)
  {
    Optional<ProjectEntity> optionalProject = projectRepo.findById(id);
    if(optionalProject.isPresent())
    {
      projectRepo.deleteById(id);
      return new ResponseEntity<>("Project removed from database!", HttpStatus.OK);
    }
    else
    {
      return new ResponseEntity<>("Requested details not found! Project Id : " + id, HttpStatus.NOT_FOUND);
    }
  }
}
