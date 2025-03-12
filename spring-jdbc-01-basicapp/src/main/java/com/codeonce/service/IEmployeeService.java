package com.codeonce.service;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public interface IEmployeeService {
	public int getEmployeesCount();
	public float getEmployeeSalByEno(int eno);
	public Map<String, Object> getEmployeeDetailsByEno(int eno);
	public List<Map<String, Object>> getEmployeeDetailsByDesg(String desg1, String desg2, String desg3);
	public SqlRowSet getEmployeeDetailsBySalRange(Float startSal, Float endSal);
	public String insertEmployee(String name, String desg, float job);
	public String updateEmloyeeSalByEmpNo(int empNo);
	public String deleteEmloyeeByEmpNo(int empNo);
	
}
