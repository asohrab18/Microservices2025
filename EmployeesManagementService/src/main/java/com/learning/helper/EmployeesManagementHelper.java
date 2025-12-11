package com.learning.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learning.exception.MissingRequiredDataException;
import com.learning.exception.UnprocessableException;
import com.learning.model.Employee;
import com.learning.model.EmployeesInfo;
import com.learning.repository.EmployeeRepo;
import com.learning.repository.EmployeesManagementCustomRepo;
import com.learning.utils.EmployeesManagementContants;



@Component
public class EmployeesManagementHelper {
	private static final Logger LOG = LoggerFactory.getLogger(EmployeesManagementHelper.class);

	@Autowired
	private EmployeeRepo repo;

	@Autowired
	private EmployeesManagementCustomRepo customRepo;

	public String deleteEmployees() throws Exception {
		long count = repo.count();
		if (count == EmployeesManagementContants.ZERO) {
			LOG.info(EmployeesManagementContants.DATA_ABSENT);
			throw new UnprocessableException(EmployeesManagementContants.DATA_ABSENT);
		}
		repo.deleteAll();
		LOG.info(EmployeesManagementContants.MSG_SUCCESSFUL);
		return EmployeesManagementContants.DATA_DELETED;
	}

	public Employee createEmployee(Employee employee) throws Exception {
		if (employee == null) {
			LOG.info(EmployeesManagementContants.DATA_REQUIRED);
			throw new MissingRequiredDataException(EmployeesManagementContants.DATA_REQUIRED);
		}
		employee = repo.save(employee);
		LOG.info(EmployeesManagementContants.MSG_SUCCESSFUL);
		return employee;
	}

	public EmployeesInfo getEmployeesV1(Employee emp) throws Exception {
		int id = 0;
		double salary = 0;
		String name = null;
		String city = null;
		String state = null;
		String country = null;
		if (emp != null) {
			id = emp.getId();
			salary = emp.getSalary();
			name = emp.getName();
			city = emp.getCity();
			state = emp.getState();
			country = emp.getCountry();
		}
		EmployeesInfo employeesInfo = new EmployeesInfo();
		List<Employee> employees = null;
		if (id == 0 && salary == 0 && StringUtils.isBlank(name) && StringUtils.isBlank(city)
				&& StringUtils.isBlank(state) && StringUtils.isBlank(country)) {

			employees = repo.findAll();

		} else if (id == 0 && salary == 0 && StringUtils.isNotBlank(name) && StringUtils.isBlank(city)
				&& StringUtils.isBlank(state) && StringUtils.isBlank(country)) {

			employees = repo.findByName(name);
		} else if (id == 0 && salary == 0 && StringUtils.isBlank(name) && StringUtils.isNotBlank(city)
				&& StringUtils.isBlank(state) && StringUtils.isBlank(country)) {

			employees = repo.findByCity(city);
		} else if (id == 0 && salary == 0 && StringUtils.isBlank(name) && StringUtils.isBlank(city)
				&& StringUtils.isNotBlank(state) && StringUtils.isBlank(country)) {

			employees = repo.findByState(state);
		} else if (id == 0 && salary == 0 && StringUtils.isBlank(name) && StringUtils.isBlank(city)
				&& StringUtils.isBlank(state) && StringUtils.isNotBlank(country)) {

			employees = repo.findByCountry(country);
		} else if (id == 0 && salary == 0 && StringUtils.isNotBlank(name) && StringUtils.isNotBlank(city)
				&& StringUtils.isBlank(state) && StringUtils.isBlank(country)) {

			employees = repo.findByNameAndCity(name, city);
		} else if (id == 0 && salary == 0 && StringUtils.isBlank(name) && StringUtils.isNotBlank(city)
				&& StringUtils.isNotBlank(state) && StringUtils.isBlank(country)) {

			employees = repo.findByCityAndState(city, state);
		} else if (id == 0 && salary == 0 && StringUtils.isBlank(name) && StringUtils.isBlank(city)
				&& StringUtils.isNotBlank(state) && StringUtils.isNotBlank(country)) {

			employees = repo.findByStateAndCountry(state, country);
		}
		Optional<List<Employee>> opt = Optional.ofNullable(employees);
		if (!opt.isPresent() || opt.get().isEmpty()) {
			employeesInfo.setEmployees(new ArrayList<Employee>());
			employeesInfo.setTotalEmployees(EmployeesManagementContants.ZERO);
			LOG.info(EmployeesManagementContants.MSG_SUCCESSFUL);
			return employeesInfo;
		}
		employeesInfo.setEmployees(employees);
		employeesInfo.setTotalEmployees(employees.size());
		LOG.info(EmployeesManagementContants.MSG_SUCCESSFUL);
		return employeesInfo;
	}

	public EmployeesInfo getEmployeesV2(Employee emp, String sortBy, String sortType) throws Exception {
		List<Employee> employees = customRepo.getEmployeesV2(emp, sortBy, sortType);

		EmployeesInfo employeesInfo = new EmployeesInfo();
		Optional<List<Employee>> opt = Optional.ofNullable(employees);
		if (!opt.isPresent() || opt.get().isEmpty()) {
			employeesInfo.setEmployees(new ArrayList<Employee>());
			employeesInfo.setTotalEmployees(EmployeesManagementContants.ZERO);
			LOG.info(EmployeesManagementContants.MSG_SUCCESSFUL);
			return employeesInfo;
		}
		employeesInfo.setEmployees(employees);
		employeesInfo.setTotalEmployees(employees.size());
		LOG.info(EmployeesManagementContants.MSG_SUCCESSFUL);
		return employeesInfo;
	}

	public EmployeesInfo getEmployeesV3(Employee emp) throws Exception {
		int id = 0;
		double salary = 0;
		String name = null;
		String city = null;
		String state = null;
		String country = null;
		if (emp != null) {
			id = emp.getId();
			salary = emp.getSalary();
			name = emp.getName();
			city = emp.getCity();
			state = emp.getState();
			country = emp.getCountry();
		}
		Integer idw = null;
		Double salaryw = null;
		if (id != 0) {
			idw = id;
		}
		if (salary != 0) {
			salaryw = salary;
		}
		List<Object[]> objArrList = repo.findEmployees(idw, salaryw, name, city, state, country);
		Optional<List<Object[]>> opt = Optional.ofNullable(objArrList);

		EmployeesInfo employeesInfo = new EmployeesInfo();
		List<Employee> employees = new ArrayList<Employee>();
		if (!opt.isPresent() || opt.get().isEmpty()) {
			employeesInfo.setEmployees(employees);
			employeesInfo.setTotalEmployees(EmployeesManagementContants.ZERO);
			LOG.info(EmployeesManagementContants.MSG_SUCCESSFUL);
			return employeesInfo;
		}
		Employee employee = null;
		for (Object[] objArray : objArrList) {
			id = (int) objArray[0];
			salary = (double) objArray[1];
			name = (String) objArray[2];
			city = (String) objArray[3];
			state = (String) objArray[4];
			country = (String) objArray[5];

			employee = new Employee();
			employee.setId(id);
			employee.setSalary(salary);
			employee.setName(name);
			employee.setCity(city);
			employee.setState(state);
			employee.setCountry(country);
			employees.add(employee);
		}
		employeesInfo.setEmployees(employees);
		employeesInfo.setTotalEmployees(employees.size());
		LOG.info(EmployeesManagementContants.MSG_SUCCESSFUL);
		return employeesInfo;
	}

	public String updateEmployee(Employee emp) throws Exception {
		if (emp == null) {
			LOG.info(EmployeesManagementContants.DATA_REQUIRED);
			throw new MissingRequiredDataException(EmployeesManagementContants.DATA_REQUIRED);
		}
		String message = customRepo.updateEmployee(emp);
		LOG.info(EmployeesManagementContants.MSG_SUCCESSFUL);
		return message;
	}

	public String deleteEmployee(int id) throws Exception {
		if (id == EmployeesManagementContants.ZERO) {
			LOG.info(EmployeesManagementContants.ID_GREATER_THAN_ZERO);
			throw new MissingRequiredDataException(EmployeesManagementContants.ID_GREATER_THAN_ZERO);
		}
		Optional<Employee> employee = repo.findById(id);
		if (!employee.isPresent()) {
			LOG.info(EmployeesManagementContants.DATA_ABSENT);
			throw new UnprocessableException(EmployeesManagementContants.DATA_ABSENT);
		}
		repo.delete(employee.get());
		LOG.info(EmployeesManagementContants.MSG_SUCCESSFUL);
		return EmployeesManagementContants.DATA_DELETED;
	}
}
