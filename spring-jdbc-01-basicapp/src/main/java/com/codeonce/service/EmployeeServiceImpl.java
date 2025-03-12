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
	
	@Override
	public String insertEmployee(String name, String desg, float sal) {
		int count = employeeDao.insertEmployee(name, desg, sal);
		return count > 0 ? "EMPLOYEE CREATED SUCCESSFULLY" : "EMPLOYEE CREATION FAILED";
	}
	
	@Override
	public String updateEmloyeeSalByEmpNo(int empNo) {
		float empSal = getEmployeeSalByEno(empNo);
		int count = employeeDao.updateEmpSalByEno(empNo, (empSal+1500.0f));
		return count > 0 ? "EMPLOYEE '"+empNo+"' UPDATED SUCCESSFULLY!" : "EMPLOYEE NOT UPDATED!";
	}
	
	@Override
	public String deleteEmloyeeByEmpNo(int empNo) {
		int count = employeeDao.deleteEmployeeByEno(empNo);
		return count > 0 ? "EMPLOYEE DELETED SUCCESSFULLY!" : "EMPLOYEE NOT DELETED!";
	}
}
