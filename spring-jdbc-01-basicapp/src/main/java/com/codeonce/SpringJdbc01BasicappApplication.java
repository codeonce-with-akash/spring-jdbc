package com.codeonce;

import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.codeonce.service.IEmployeeService;

@SpringBootApplication
public class SpringJdbc01BasicappApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringJdbc01BasicappApplication.class, args);
		IEmployeeService employeeService = context.getBean(IEmployeeService.class);

		// 1. fetch employees count
		int employeesCount = 0;
		try {
			employeesCount = employeeService.getEmployeesCount();
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("No. of employees are: " + employeesCount);

		System.out.println("-----------------------------------------");

		// 2. fetch employee salary by empNo.
		float empSal = 0;
		try {
			employeeService.getEmployeeSalByEno(7499);
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("Sal of 7499 : " + empSal);
		System.out.println("-----------------------------------------");

		// 3. fetch employee details by empNo.
		Map<String, Object> map = null;
		try {
			map = employeeService.getEmployeeDetailsByEno(7499);
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("Employee details of empNo 7499 is: ");
		map.entrySet().forEach(row -> {
			System.out.println(row.getKey() + " : " + row.getValue());
		});
		System.out.println("-----------------------------------------");

		// 4. fetch employees by jobs
		List<Map<String, Object>> getEmployeeDetailsByJobs = null;
		try {
			getEmployeeDetailsByJobs = employeeService.getEmployeeDetailsByDesg("CLERK", "SALESMAN", "MANAGER");
			System.out.println(getEmployeeDetailsByJobs);
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("-----------------------------------------");

		// 5. fetch employees details by salary range using SqlRowSet
		SqlRowSet sqlRowSet = null;
		try {
			sqlRowSet = employeeService.getEmployeeDetailsBySalRange(1000.0f, 1500.0f);
			System.out.println("Data from SqlRowSet ");
			while (sqlRowSet.next()) {
				System.out.println(sqlRowSet.getInt(1) + " " + sqlRowSet.getString(2) + " " + sqlRowSet.getString(3)
						+ " " + sqlRowSet.getFloat(4) + " " + sqlRowSet.getInt(5));
			}
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("-----------------------------------------");

		// 6. insert employee details
		/*String msg = null;
		try {
			msg = employeeService.insertEmployee("YASH", "QA", 17000.0f);
			System.out.println(msg);
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		// 7. update employee details
		String msgUpdate = null;
		try {
			msgUpdate = employeeService.updateEmloyeeSalByEmpNo(1);
			System.out.println(msgUpdate);
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		*/
		
		// 8. delete employee details
		String msgUpdate = null;
		try {
			msgUpdate = employeeService.deleteEmloyeeByEmpNo(5);
			
			System.out.println(msgUpdate);
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
	}

}
