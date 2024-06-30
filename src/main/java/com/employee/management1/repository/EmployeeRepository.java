package com.employee.management1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.management1.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
        
}
