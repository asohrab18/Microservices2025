package com.learning.service;

import com.learning.model.Person;
import com.learning.model.PersonInfo;

public interface PersonService {

	Person findPerson(int id) throws Exception;

	PersonInfo findPersons() throws Exception;
}
