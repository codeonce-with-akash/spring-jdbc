package com.codeonce.jdbc.service;

import com.codeonce.jdbc.dto.DeptDto;

public interface IDeptService {
	public DeptDto getDeptDetailsByDeptNo(Integer deptNo);
}
