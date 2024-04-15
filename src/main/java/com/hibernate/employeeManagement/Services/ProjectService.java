package com.hibernate.employeeManagement.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hibernate.employeeManagement.Entities.ProjectEntity;
import com.hibernate.employeeManagement.Repositories.ProjectRepository;

@Service
public class ProjectService 
{
  @Autowired
  ProjectRepository projectRepo;

  public ResponseEntity<String> addProject(ProjectEntity project)
  {
    projectRepo.save(project);
    return new ResponseEntity<>("Project added to database!", HttpStatus.OK);
  }

  public ResponseEntity<List<ProjectEntity>> getAllProjects()
  {
    List<ProjectEntity> projects = projectRepo.findAll();
    return new ResponseEntity<>(projects, HttpStatus.OK);
  }

  public ResponseEntity<String> updateById(Long id, ProjectEntity updatedProject)
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

  public ResponseEntity<String> deleteById(Long id)
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
