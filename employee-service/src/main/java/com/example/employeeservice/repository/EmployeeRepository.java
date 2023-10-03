package com.example.employeeservice.repository;


import com.example.employeeservice.model.Employee;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * EmployeeRepository - employee Repository class
 */
@Repository
public class EmployeeRepository {

  /**
   * employees - employee Repository Function
   */
  private List<Employee> employees
        = new ArrayList<>();

  /**
   * add - add employee Repository Function
   */
  public Employee add(Employee employee) {
    employees.add(employee);
    return employee;
  }

  /**
   * findById - findById Repository Function
   */
  public Employee findById(Long id) {
    return employees.stream()
          .filter(a -> a.id().equals(id))
          .findFirst()
          .orElseThrow();
  }

  /**
   * findAll - findAll Repository Function
   */
  public List<Employee> findAll() {
    return employees;
  }

  /**
   * findByDepartment - findByDepartment Repository Function
   */
  public List<Employee> findByDepartment(Long departmentId) {
    return employees.stream()
          .filter(a -> a.departmentId().equals(departmentId))
          .toList();
  }
}
