package com.codeonce.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.codeonce.constants.AppConstants;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int getEmployeesCount() {
		Integer employeesCount = jdbcTemplate.queryForObject(AppConstants.GET_EMP_COUNT, Integer.class);
		return employeesCount;
	}
	
	@Override
	public float getEmployeeSalByEno(int eno) {
		Float sal = jdbcTemplate.queryForObject(AppConstants.GET_EMP_SAL_BY_ENO, Float.class, eno);
		return sal;
	}
	
	@Override
	public Map<String, Object> getEmployeeDetailsByEno(int eno) {
		Map<String, Object> map = jdbcTemplate.queryForMap(AppConstants.GET_EMP_DETAILS_BY_ENO, eno);
		return map;
	}
	
	@Override
	public List<Map<String, Object>> getEmployeeDetailsByDesgs(String desg1, String desg2, String desg3) {
		List<Map<String,Object>> list = jdbcTemplate.queryForList(AppConstants.GET_EMP_DETAILS_BY_DESGS, desg1, desg2, desg3);
		return list;
	}
	
	@Override
	public SqlRowSet getEmployeeDetailsBySalaryRange(float startSal, float endSalary) {
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(AppConstants.GET_EMP_DETAILS_BY_SAL_RANGE, startSal, endSalary);
		return rowSet;
	}
	
	@Override
	public int insertEmployee(String name, String desg, float sal) {
		int count = jdbcTemplate.update(AppConstants.INSERT_EMP_DETAILS, name,desg,sal);  
		return count;
	}
	
	@Override
	public int updateEmpSalByEno(int eno, float sal) {
		int count = jdbcTemplate.update(AppConstants.UPDATE_EMP_SAL, sal, eno);
		return count;
	}
	
	@Override
	public int deleteEmployeeByEno(int eno) {
		int count = jdbcTemplate.update(AppConstants.DELETE_EMP_BY_EMPNO, eno);
		return count;
	}

}





