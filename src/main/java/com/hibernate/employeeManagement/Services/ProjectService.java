package com.hibernate.employeeManagement.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hibernate.employeeManagement.Entities.ProjectEntity;
import com.hibernate.employeeManagement.Repositories.ProjectRepository;

/**
 * Service Class for ProjectController
 */

@Service
public class ProjectService 
{
  @Autowired
  ProjectRepository projectRepo;

  /**
   * Method to add project into Project Repository
   * @param project The project entity to be added
   * @return ResponseEntity - A response indicating the status of operation
   */
  public ResponseEntity<String> addProject(ProjectEntity project)
  {
    projectRepo.save(project);
    return new ResponseEntity<>("Project added to database!", HttpStatus.OK);
  }

  /**
   * Method to fetch all projects from Project Repository
   * @return ResponseEntity - A response containing List of Project Entities in the response body
   */
  public ResponseEntity<List<ProjectEntity>> getAllProjects()
  {
    List<ProjectEntity> projects = projectRepo.findAll();
    return new ResponseEntity<>(projects, HttpStatus.OK);
  }

  /**
   * Method to update existing project in Project Repository
   * @param id The id of the project to be updated
   * @param updatedProject The updated project body
   * @return ResponseEntity - A reponse indicating the status of operation
   */
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

  /**
   * Method to delete existing project from Project Repository
   * @param id The id of project to be deleted
   * @return ResponseEntity - A response indicating the status of operation
   */
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
