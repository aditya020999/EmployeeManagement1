package com.employee.management1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.management1.entity.Employee;
import com.employee.management1.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
