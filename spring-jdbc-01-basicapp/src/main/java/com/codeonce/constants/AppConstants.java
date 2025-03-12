package com.codeonce.constants;

public class AppConstants {
	public final static String GET_EMP_COUNT = "SELECT COUNT(*) FROM EMP";
	public final static String GET_EMP_SAL_BY_ENO = "SELECT SAL FROM EMP WHERE EMPNO=?";
	public final static String GET_EMP_DETAILS_BY_ENO = "SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE EMPNO=?";
	public final static String GET_EMP_DETAILS_BY_DESGS = "SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP WHERE JOB IN(?, ?, ?) ORDER BY JOB";
	public final static String GET_EMP_DETAILS_BY_SAL_RANGE = "SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP WHERE SAL>=? AND SAL<=?";
	public final static String INSERT_EMP_DETAILS="INSERT INTO EMP(EMPNO, ENAME, JOB, SAL) VALUES(EMPNUM_SEQ.NEXTVAL, ?, ?, ?)";
	public final static String UPDATE_EMP_SAL="UPDATE EMP SET SAL=? WHERE EMPNO=?";
	public final static String DELETE_EMP_BY_EMPNO="DELETE FROM EMP WHERE EMPNO=?";
}
