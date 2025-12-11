package com.management.weight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.weight.model.Person;
import com.management.weight.service.WeightManagementService;
import com.management.weight.utils.WeightManagementContants;

@RestController
@RefreshScope
@RequestMapping(WeightManagementContants.WEIGHT_MGMT)
public class WeightManagementController {

	@Autowired
	private WeightManagementService service;

	@Value("${app.message}")
	private String message;

	@GetMapping(WeightManagementContants.MESSAGES)
	public ResponseEntity<String> showMessage() {
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@GetMapping(WeightManagementContants.GREETINGS)
	public ResponseEntity<String> greet() {
		return new ResponseEntity<>(WeightManagementContants.MSG_WELCOME, HttpStatus.OK);
	}

	@PostMapping(WeightManagementContants.DETAILS)
	public ResponseEntity<Person> getDetails(@RequestBody Person person) throws Exception {
		person = service.getDetails(person);
		return new ResponseEntity<>(person, HttpStatus.OK);
	}
}