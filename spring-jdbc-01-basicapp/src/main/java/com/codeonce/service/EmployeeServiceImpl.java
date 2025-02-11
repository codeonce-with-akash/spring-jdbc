package com.codeonce.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.codeonce.dao.IEmployeeDao;

@Service("employee-service")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao employeeDao;
	
	@Override
	public int getEmployeesCount() {
		int employeesCount = employeeDao.getEmployeesCount();
		return employeesCount;
	}
	
	@Override
	public float getEmployeeSalByEno(int eno) {
		float empSal = employeeDao.getEmployeeSalByEno(eno);
		return empSal;
	}
	
	@Override
	public Map<String, Object> getEmployeeDetailsByEno(int eno) {
		Map<String, Object> map = employeeDao.getEmployeeDetailsByEno(eno);
		return map;
	}
	
	@Override
	public List<Map<String, Object>> getEmployeeDetailsByDesg(String desg1, String desg2, String desg3) {
		List<Map<String, Object>> employeesList = employeeDao.getEmployeeDetailsByDesgs(desg1, desg2, desg3);
		return employeesList;
	}

	@Override
	public SqlRowSet getEmployeeDetailsBySalRange(Float startSal, Float endSal) {
		SqlRowSet sqlRowSet = employeeDao.getEmployeeDetailsBySalaryRange(startSal, endSal);
		return sqlRowSet;
	}
}
