package com.codeonce.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.codeonce.jdbc.dto.DeptDto;
import com.codeonce.jdbc.service.IDeptService;

@SpringBootApplication
public class SpringJdbc02CallbackInterfacesApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringJdbc02CallbackInterfacesApplication.class, args);
		IDeptService deptService = applicationContext.getBean(IDeptService.class);
		DeptDto deptDto = deptService.getDeptDetailsByDeptNo(10);
		System.out.println("Department details are: ");
		System.out.println("Dept No: " + deptDto.getDeptNum() + " | Dept Name: " + deptDto.getDeptName() + " | Dept Loc: " + deptDto.getDeptLoc());
	}

}
