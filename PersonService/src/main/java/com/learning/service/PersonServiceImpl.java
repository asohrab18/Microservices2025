package com.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.helper.PersonHelper;
import com.learning.model.Person;
import com.learning.model.PersonInfo;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonHelper helper;

	@Override
	public Person findPerson(int id) throws Exception {
		return helper.findPerson(id);
	}

	@Override
	public PersonInfo findPersons() throws Exception {
		return helper.findPersons();
	}
}