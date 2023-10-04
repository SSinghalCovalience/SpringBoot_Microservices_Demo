package com.covalience.departmentservice;

import com.covalience.departmentservice.client.EmployeeClient;
import com.covalience.departmentservice.controller.DepartmentController;
import com.covalience.departmentservice.model.BaseResponse;
import com.covalience.departmentservice.model.Department;
import com.covalience.departmentservice.model.Employee;
import com.covalience.departmentservice.repository.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class DepartmentServiceApplicationTests {

	@Mock
	EmployeeClient employeeClient;

	@Mock
	DepartmentRepository repository;

	@InjectMocks
	DepartmentController departmentController;

	@Test
	void contextLoads() {
	}

	@Test
	public void test_add(){
		Department department = new Department(1L, "ABC");
		when(repository.addDepartment(department)).thenReturn(department);
		assertEquals(1L, departmentController.add(department).getData().getId());
	}

	@Test
	public void test_findAll(){
		List<Department> departmentList = new ArrayList<>();
		departmentList.add(new Department(1L, "ABC"));
		departmentList.add(new Department(2L, "DEF"));
		when(repository.findAll()).thenReturn(departmentList);
		assertEquals(2, departmentController.findAll().getData().size());
	}

	@Test
	public void test_findById(){
		Department department = new Department(1L, "ABC");
		when(repository.findById(1L)).thenReturn(department);
		assertEquals(1L, departmentController.findById(1L).getData().getId());
	}

	@Test
	public void test_findAllWithEmployees(){
		List<Department> departmentList = new ArrayList<>();
		departmentList.add(new Department(1L, "ABC"));
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(1L, 1L, "Sukant Singhal", 26, "Software Engineer"));
		employeeList.add(new Employee(2L, 1L, "Sukant Singhal", 26, "Software Engineer"));
		when(repository.findAll()).thenReturn(departmentList);
		when(employeeClient.findByDepartment(departmentList.get(0).getId())).thenReturn(new BaseResponse<>(true, 200, "Success",employeeList));
		assertEquals(2, departmentController.findAllWithEmployees().getData().get(0).getEmployees().size());
	}



}
