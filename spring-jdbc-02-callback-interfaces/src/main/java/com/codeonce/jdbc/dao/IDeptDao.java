package com.codeonce.jdbc.dao;

import com.codeonce.jdbc.bo.DeptBO;

public interface IDeptDao {
	public DeptBO getDepartmentDetailsByDeptNo(Integer deptNo);
}
