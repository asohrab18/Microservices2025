package com.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learning.helper.EmployeesManagementHelper;
import com.learning.model.Employee;
import com.learning.model.EmployeesInfo;

@Service
public class EmployeesManagementServiceImpl implements EmployeesManagementService {

	@Autowired
	private EmployeesManagementHelper helper;

	@Override
	public Employee createEmployee(Employee employee) throws Exception {
		return helper.createEmployee(employee);
	}

	@Override
	public String deleteEmployees() throws Exception {
		return helper.deleteEmployees();
	}

	@Override
	public EmployeesInfo getEmployeesV1(Employee employee) throws Exception {
		return helper.getEmployeesV1(employee);
	}
	
	@Override
	public EmployeesInfo getEmployeesV2(Employee employee, String sortBy, String sortType) throws Exception {
		return helper.getEmployeesV2(employee, sortBy, sortType);
	}
	
	@Override
	public EmployeesInfo getEmployeesV3(Employee employee) throws Exception {
		return helper.getEmployeesV3(employee);
	}

	@Override
	public String updateEmployee(Employee emp) throws Exception {
		return helper.updateEmployee(emp);
	}
	
	@Override
	public String deleteEmployee(int id) throws Exception {
		return helper.deleteEmployee(id);
	}
}
