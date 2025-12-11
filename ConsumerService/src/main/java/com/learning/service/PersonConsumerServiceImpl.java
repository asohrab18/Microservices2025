package com.learning.service;

import org.springframework.stereotype.Service;
import com.learning.helper.PersonHelper;
import com.learning.model.Person;
import com.learning.model.PersonInfo;

@Service
public class PersonConsumerServiceImpl implements PersonConsumerService{

	private final PersonHelper personHelper;

	public PersonConsumerServiceImpl(PersonHelper personHelper) {
		this.personHelper = personHelper;
	}

	public String greet(Integer num) {
		return personHelper.greet(num);
	}

	public PersonInfo getPersons() {
		return personHelper.getPersons();
	}

	public Person getPerson(int id) {
		return personHelper.getPerson(id);
	}
}