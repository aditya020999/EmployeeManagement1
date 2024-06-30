package com.employee.management1.service;

import java.sql.CallableStatement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.management1.entity.Department;
import com.employee.management1.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Department addDepartment(Department department) {
		
		return  departmentRepository.save(department);
	}

	@Override
	@Transactional
	public double getDepartmentSalary(Long departmentId) {
		String call="{CALL GetDepartmentSalary(?,?)}";
		Double totalSalary=jdbcTemplate.execute(call,(CallableStatement cs)->{
			cs.setLong(1,departmentId);
			cs.registerOutParameter(2,java.sql.Types.DOUBLE);
			cs.execute();
			return cs.getDouble(2);
		});
		return totalSalary!=null?totalSalary:0.0;
	}
	
}
