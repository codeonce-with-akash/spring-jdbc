package com.codeonce.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.codeonce.jdbc.bo.DeptBO;
import com.codeonce.jdbc.constants.SqlQueryConstants;

@Repository(value = "deptDaoImplUsingLambdaBasedAIC")
public class DeptDaoImplUsingLambdaBasedAIC implements IDeptDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public DeptDaoImplUsingLambdaBasedAIC() {
		System.out.println("DeptDaoImplUsingLambdaBasedAIC :: 0-PARAM CONSTRUCTOR");
	}
	
	@Override
	public DeptBO getDepartmentDetailsByDeptNo(Integer deptNo) {
		System.out.println("DeptDaoImplUsingLambdaBasedAIC.getDepartmentDetailsByDeptNo() method executed");
		return jdbcTemplate.queryForObject(SqlQueryConstants.GET_DEPT_DETAILS_BY_DEPTNO, 
									//Anonymous based inner class 
									(rs, rowNum) -> {
										DeptBO deptBo = new DeptBO();
										deptBo.setDeptno(rs.getInt(1));
										deptBo.setDname(rs.getString(2));
										deptBo.setLoc(rs.getString(3));
										return deptBo;
									}, 
									deptNo);
	}

}
