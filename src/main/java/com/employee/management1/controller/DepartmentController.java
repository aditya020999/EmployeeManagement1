package com.employee.management1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management1.entity.Department;
import com.employee.management1.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    
	@Autowired
	private DepartmentService departmentService;
	
	
	@PostMapping
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }
	
	@GetMapping("/{id}/salary")
	public double getDepartmentSalary(@PathVariable Long id) {
		return departmentService.getDepartmentSalary(id);
	}
	
}
