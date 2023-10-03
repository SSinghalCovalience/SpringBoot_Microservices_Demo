package com.example.departmentservice.controller;

import com.example.departmentservice.client.EmployeeClient;
import com.example.departmentservice.model.BaseResponse;
import com.example.departmentservice.model.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * DepartmentController - DepartmentController Class
 */
@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

  @Autowired
  DepartmentRepository repository;

  @Autowired
  EmployeeClient employeeClient;

  /**
   * add - add function
   *
   * @return department object
   */
  @PostMapping("/")
  public BaseResponse<Department> add(@RequestBody Department department) {
    log.info("Department add: {}", department);

    return new BaseResponse<>(true, 200, "Success", repository.addDepartment(department));
  }

  /**
   * findAll - findAll function
   *
   * @return List of department object
   */
  @GetMapping("/")
  public BaseResponse<List<Department>> findAll() {
    log.info("Department find All");
    return new BaseResponse<>(true, 200, "Success", repository.findAll());
  }

  /**
   * findById - findById function
   *
   * @return department object
   */
  @GetMapping("/{id}")
  public BaseResponse<Department> findById(@PathVariable Long id) {
    log.info("Department find: id={}", id);
    return new BaseResponse<>(true, 200, "Success", repository.findById(id));
  }

  /**
   * findAllWithEmployees - findAllWithEmployees function
   *
   * @return department object
   */
  @GetMapping("/with-employees")
  public BaseResponse<List<Department>> findAllWithEmployees() {
    log.info("Department find All");
    List<Department> departments
          = repository.findAll();
    departments.forEach(department ->
          department.setEmployees(
                employeeClient.findByDepartment(department.getId())));
    return new BaseResponse<>(true, 200, "Success", departments);
  }
}
