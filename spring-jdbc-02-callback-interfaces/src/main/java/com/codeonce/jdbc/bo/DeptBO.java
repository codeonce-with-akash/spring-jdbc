package com.codeonce.jdbc.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptBO {
	private Integer deptNum;
	private String deptName;
	private String deptLoc;
}
