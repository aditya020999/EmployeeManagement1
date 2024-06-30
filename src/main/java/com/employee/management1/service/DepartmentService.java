package com.employee.management1.service;

import com.employee.management1.entity.Department;

public interface DepartmentService {
      
	double getDepartmentSalary(Long departmentId);

	Department addDepartment(Department department);
}
