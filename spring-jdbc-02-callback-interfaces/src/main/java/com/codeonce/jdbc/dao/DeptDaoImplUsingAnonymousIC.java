package com.codeonce.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.codeonce.jdbc.bo.DeptBO;
import com.codeonce.jdbc.constants.SqlQueryConstants;

@Repository(value = "deptDaoImplUsingAnonymousIC")
public class DeptDaoImplUsingAnonymousIC implements IDeptDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public DeptDaoImplUsingAnonymousIC() {
		System.out.println("DeptDaoImplUsingAnonymousIC :: 0-PARAM CONSTRUCTOR");
	}
	
	@Override
	public DeptBO getDepartmentDetailsByDeptNo(Integer deptNo) {
		System.out.println("DeptDaoImplUsingAnonymousIC.getDepartmentDetailsByDeptNo() method executed");
		return jdbcTemplate.queryForObject(SqlQueryConstants.GET_DEPT_DETAILS_BY_DEPTNO,
									// HERE WE ARE USING ANONYMOUS INNER CLASS BCOZ WE NEED THIS ROWMAPPER METHOD LOGIC
									// INSIDE ONLY ONE METHOD.
									new RowMapper<DeptBO>() {
										@Override
										public DeptBO mapRow(ResultSet rs, int rowNum) throws SQLException {
											DeptBO deptBo = new DeptBO();
											deptBo.setDeptno(rs.getInt(1));
											deptBo.setDname(rs.getString(2));
											deptBo.setLoc(rs.getString(3));
											return deptBo;
										}
									},	//close anonymous inner class 
									deptNo);
	}

}
