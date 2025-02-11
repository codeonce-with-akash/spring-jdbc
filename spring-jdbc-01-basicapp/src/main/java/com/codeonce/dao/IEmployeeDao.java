package com.codeonce.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public interface IEmployeeDao {
	public int getEmployeesCount();
	public float getEmployeeSalByEno(int eno);
	public Map<String, Object> getEmployeeDetailsByEno(int eno);
	public List<Map<String, Object>> getEmployeeDetailsByDesgs(String desg1, String desg2, String desg3);
	public SqlRowSet getEmployeeDetailsBySalaryRange(float startSal, float endSalary);
}
