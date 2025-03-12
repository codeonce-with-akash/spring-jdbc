package com.codeonce.jdbc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeptDto {
	private Integer deptNum;
	private String deptName;
	private String deptLoc;
}
