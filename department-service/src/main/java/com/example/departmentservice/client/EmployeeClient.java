package com.example.departmentservice.client;

import com.example.departmentservice.model.BaseResponse;
import com.example.departmentservice.model.Employee;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

/**
 * EmployeeClient - EmployeeClient Class
 */
@HttpExchange
public interface EmployeeClient {

  @GetExchange("/employees/department/{departmentId}")
  public BaseResponse<List<Employee>> findByDepartment(@PathVariable("departmentId") Long departmentId);

}
