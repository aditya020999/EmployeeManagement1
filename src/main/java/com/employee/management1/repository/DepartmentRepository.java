package com.employee.management1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.management1.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
