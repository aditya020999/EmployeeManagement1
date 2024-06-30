package com.employee.management1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management1.entity.Department;
import com.employee.management1.entity.Employee;
import com.employee.management1.repository.DepartmentRepository;
import com.employee.management1.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        // Ensure the department exists
        Department department = departmentRepository.findById(employee.getDepartment().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid department ID"));
        employee.setDepartment(department);
        return employeeService.addEmployee(employee);
    }
}
