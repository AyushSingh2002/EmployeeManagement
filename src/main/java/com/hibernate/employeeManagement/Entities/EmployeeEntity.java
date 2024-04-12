package com.hibernate.employeeManagement.Entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeEntity 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long employeeId;

  @Column(name = "name")
  private String name;

  @Column(name = "dob")
  private Date dateOfBirth;

  @Column(name = "salary")
  private Double salary;

  @Column(name = "contact")
  private Long contactNumber;

  @Column(name = "email")
  private String email;

  @Column(name = "address")
  private String address;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "department_department_id")
  @JsonIgnore
  private DepartmentEntity department;
}
