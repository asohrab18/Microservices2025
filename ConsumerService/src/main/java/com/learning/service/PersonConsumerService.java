package com.learning.service;

import com.learning.model.Person;
import com.learning.model.PersonInfo;

public interface PersonConsumerService {

	public String greet(Integer num);

	public PersonInfo getPersons();

	public Person getPerson(int id);
}
