package com.codeonce.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeonce.jdbc.bo.DeptBO;
import com.codeonce.jdbc.dao.IDeptDao;
import com.codeonce.jdbc.dto.DeptDto;

@Service
public class DeptServiceImpl implements IDeptService {

	@Autowired
	private IDeptDao deptDao;
	
	@Override
	public DeptDto getDeptDetailsByDeptNo(Integer deptNo) {
		DeptBO bo = deptDao.getDepartmentDetailsByDeptNo(deptNo);
		return DeptDto.builder().deptNum(bo.getDeptNum()).deptName(bo.getDeptName()).deptLoc(bo.getDeptLoc()).build();
	}

}
