package com.learning.service;

import com.learning.model.Employee;
import com.learning.model.EmployeesInfo;

public interface EmployeesManagementService {

	Employee createEmployee(Employee employee) throws Exception;
	
	EmployeesInfo getEmployeesV1(Employee employee) throws Exception;
	
	EmployeesInfo getEmployeesV2(Employee employee, String sortBy, String sortType) throws Exception;
	
	EmployeesInfo getEmployeesV3(Employee employee) throws Exception;
	
	String deleteEmployees() throws Exception;
	
	String deleteEmployee(int id) throws Exception;
	
	String updateEmployee(Employee emp) throws Exception;
}
