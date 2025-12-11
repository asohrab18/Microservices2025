package com.learning.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.exception.MissingRequiredDataException;
import com.learning.model.Person;
import com.learning.model.PersonInfo;
import com.learning.service.PersonService;
import com.learning.utils.PersonUtils;

@RestController
@RequestMapping(PersonUtils.PERSONS)
public class PersonController {
	private static final Logger LOG = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonService service;

	@GetMapping(PersonUtils.GREETINGS)
	public String greet(@RequestParam(required = false) Integer num) {
		if (num != null && num < PersonUtils.ZERO) {
			LOG.info(PersonUtils.MSG_FAILED);
			throw new MissingRequiredDataException(PersonUtils.MSG_FAILED);
		}
		LOG.info(PersonUtils.MSG_SUCCESSFUL);
		return PersonUtils.MSG_GREET;
	}

	@GetMapping(PersonUtils.SLASH)
	public PersonInfo getPersons() throws Exception {
		LOG.info(PersonUtils.MSG_SUCCESSFUL);
		return service.findPersons();
	}

	@GetMapping(PersonUtils.ID_PATH)
	public Person getPerson(@PathVariable(required = true) Integer id) throws Exception {
		LOG.info(PersonUtils.MSG_SUCCESSFUL);
		return service.findPerson(id);
	}
}