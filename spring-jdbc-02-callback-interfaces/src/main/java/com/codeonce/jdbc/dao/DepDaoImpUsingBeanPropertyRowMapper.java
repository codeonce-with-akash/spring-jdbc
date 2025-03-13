package com.codeonce.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.codeonce.jdbc.bo.DeptBO;
import com.codeonce.jdbc.constants.SqlQueryConstants;

@Repository(value = "depDaoImpUsingBeanPropertyRowMapper")
@Primary
public class DepDaoImpUsingBeanPropertyRowMapper implements IDeptDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public DepDaoImpUsingBeanPropertyRowMapper() {
		System.out.println("DepDaoImpUsingBeanPropertyRowMapper :: 0-PARAM CONSTRUCTOR");
	}

	@Override
	public DeptBO getDepartmentDetailsByDeptNo(Integer deptNo) {
		System.out.println("DepDaoImpUsingBeanPropertyRowMapper.getDepartmentDetailsByDeptNo() method executed!");
		//BeanPropertyRowMapper is pre-defined implementation class of RowMapper interface
		//using which we can copied result-set object values to bo class
		//remember: bo class field name and database table col names are must be same.
		return jdbcTemplate.queryForObject(SqlQueryConstants.GET_DEPT_DETAILS_BY_DEPTNO, 
									new BeanPropertyRowMapper<>(DeptBO.class), 
									deptNo);
	}
}
