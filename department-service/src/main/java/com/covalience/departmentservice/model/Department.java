package com.covalience.departmentservice.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * Department - Department class.
 */
@Data
public class Department {
  private Long id;
  private String name;
  private List<Employee> employees = new ArrayList<>();

  public Department(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
