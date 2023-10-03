package com.covalience.departmentservice.repository;


import com.covalience.departmentservice.model.Department;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * DepartmentRepository - DepartmentRepository Class
 */
@Repository
public class DepartmentRepository {
  private List<Department> departments
        = new ArrayList<>();

  /**
   * addDepartment - addDepartment function
   *
   * @return department object
   */
  public Department addDepartment(Department department) {
    departments.add(department);
    return department;
  }

  /**
   * findById - findById function
   *
   * @return department object
   */
  public Department findById(Long id) {
    return departments.stream()
          .filter(department ->
                department.getId().equals(id))
          .findFirst()
          .orElseThrow();
  }

  /**
   * findAll - findAll function
   *
   * @return list of department object
   */
  public List<Department> findAll() {
    return departments;
  }
}
