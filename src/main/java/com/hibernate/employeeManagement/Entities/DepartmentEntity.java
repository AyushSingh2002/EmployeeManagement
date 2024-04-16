package com.hibernate.employeeManagement.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity Class for Department Entity
 */

@Entity
@Table(name = "departments")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DepartmentEntity 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long departmentId;

  @Column(name = "deptName")
  private String departmentName;

  @Column(name = "technology")
  private String technology;

  @Column(name = "contactNumber")
  private Long contact;

  @Column(name = "address")
  private String address;

  @OneToMany(mappedBy = "department")
  private List<EmployeeEntity> employees;
}
