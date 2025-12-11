package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.learning.model.Employee;
import com.learning.model.EmployeesInfo;
import com.learning.service.EmployeesManagementService;
import com.learning.utils.EmployeesManagementContants;

@RestController
@RequestMapping(EmployeesManagementContants.EMPLOYEES)
public class EmployeesManagementController {

	@Autowired
	private EmployeesManagementService service;

	@GetMapping(EmployeesManagementContants.SLASH_V1)
	public ResponseEntity<EmployeesInfo> getEmployeesV1(@RequestBody(required = false) Employee employee) throws Exception {
		EmployeesInfo employeesInfo = service.getEmployeesV1(employee);
		return new ResponseEntity<>(employeesInfo, HttpStatus.OK);
	}

	@GetMapping(EmployeesManagementContants.SLASH_V2)
	public ResponseEntity<EmployeesInfo> getEmployeesV2(@RequestBody(required = false) Employee employee,
			@RequestParam(required = false) String sortBy, @RequestParam(required = false) String sortType) throws Exception {

		EmployeesInfo employeesInfo = service.getEmployeesV2(employee, sortBy, sortType);
		return new ResponseEntity<>(employeesInfo, HttpStatus.OK);
	}

	@GetMapping(EmployeesManagementContants.SLASH_V3)
	public ResponseEntity<EmployeesInfo> getEmployeesV3(@RequestBody(required = false) Employee employee) throws Exception {
		EmployeesInfo employeesInfo = service.getEmployeesV3(employee);
		return new ResponseEntity<>(employeesInfo, HttpStatus.OK);
	}

	@DeleteMapping(EmployeesManagementContants.SLASH)
	public ResponseEntity<String> deleteEmployees() throws Exception {
		String deleteMessage = service.deleteEmployees();
		return new ResponseEntity<>(deleteMessage, HttpStatus.OK);
	}

	@PostMapping(EmployeesManagementContants.SLASH)
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) throws Exception {
		employee = service.createEmployee(employee);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}

	@PutMapping(EmployeesManagementContants.SLASH)
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) throws Exception {
		String updateMessage = service.updateEmployee(employee);
		return new ResponseEntity<>(updateMessage, HttpStatus.OK);
	}

	@DeleteMapping(EmployeesManagementContants.URL_ID_PATH)
	public ResponseEntity<String> deleteStudent(@PathVariable int id) throws Exception {
		String deleteMessage = service.deleteEmployee(id);
		return new ResponseEntity<>(deleteMessage, HttpStatus.OK);
	}
}