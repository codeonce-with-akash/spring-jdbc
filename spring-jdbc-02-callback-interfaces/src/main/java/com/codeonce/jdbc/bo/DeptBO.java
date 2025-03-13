package com.codeonce.jdbc.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptBO {
	private Integer deptno;
	private String dname;
	private String loc;
}
