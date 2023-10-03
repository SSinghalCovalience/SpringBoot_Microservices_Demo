package com.example.employeeservice.controller;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repository.BaseResponse;
import com.example.employeeservice.repository.EmployeeRepository;
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
 * EmployeeController - EmployeeController class
 */
@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {
  @Autowired
  EmployeeRepository repository;

  @PostMapping("/")
  public BaseResponse<Employee> add(@RequestBody Employee employee) {
    log.info("Employee add: {}", employee);
    return new BaseResponse<>(true, 200, "Success", repository.add(employee));
  }

  @GetMapping("/")
  public BaseResponse<List<Employee>> findAll() {
    log.info("Employee find All");
    return new BaseResponse<>(true, 200, "Success", repository.findAll());
  }

  @GetMapping("/{id}")
  public BaseResponse<Employee> findById(@PathVariable("id") Long id) {
    log.info("Employee find: id={}", id);
    return new BaseResponse<>(true, 200, "Success", repository.findById(id));
  }

  @GetMapping("/department/{departmentId}")
  public BaseResponse<List<Employee>> findByDepartment(@PathVariable("departmentId") Long departmentId) {
    log.info("Employee find: departmentId={}", departmentId);
    return new BaseResponse<>(true, 200, "Success", repository.findByDepartment(departmentId));
  }
}
