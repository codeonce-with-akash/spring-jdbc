package com.codeonce.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.codeonce.jdbc.bo.DeptBO;
import com.codeonce.jdbc.constants.SqlQueryConstants;

@Repository(value = "deptDaoImpl")
public class DeptDaoImpl implements IDeptDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public DeptDaoImpl() {
		System.out.println("DeptDaoImpl :: 0-PARAM CONSTRUCTOR");
	}
	
	@Override
	public DeptBO getDepartmentDetailsByDeptNo(Integer deptNo) {
		System.out.println("DeptDaoImpl.getDepartmentDetailsByDeptNo() method executed");
		DeptBO deptBO = jdbcTemplate.queryForObject(SqlQueryConstants.GET_DEPT_DETAILS_BY_DEPTNO, new DeptRowMapper(), deptNo);
		return deptBO;
	}
	
	
	public static class DeptRowMapper implements RowMapper<DeptBO>{

		@Override
		public DeptBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			DeptBO bo = new DeptBO();
			bo.setDeptno(rs.getInt(1));
			bo.setDname(rs.getString(2));
			bo.setLoc(rs.getString(3));
			return bo;
		}
		
	}

}
