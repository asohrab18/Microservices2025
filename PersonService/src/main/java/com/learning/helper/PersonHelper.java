package com.learning.helper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.learning.exception.MissingRequiredDataException;
import com.learning.model.Person;
import com.learning.model.PersonInfo;
import com.learning.utils.PersonUtils;

@Component
public class PersonHelper {

	static List<Person> persons = null;;

	static Map<Integer, Person> personsMap = null;

	static {
		Person p1 = new Person(PersonUtils.ONE, "Ali", 21);
		Person p2 = new Person(PersonUtils.TWO, "Baby", 11);
		Person p3 = new Person(PersonUtils.THREE, "Celina", 35);

		persons = Arrays.asList(p1, p2, p3);

		personsMap = new HashMap<>();
		personsMap.put(PersonUtils.ONE, p1);
		personsMap.put(PersonUtils.TWO, p2);
		personsMap.put(PersonUtils.THREE, p3);
	}

	public Person findPerson(int id) throws Exception {
		if (id <= PersonUtils.ZERO) {
			throw new MissingRequiredDataException(PersonUtils.DATA_REQUIRED);
		}
		return personsMap.get(id);
	}

	public PersonInfo findPersons() {
		PersonInfo pi = new PersonInfo();
		pi.setTotalCount(persons.size());
		pi.setPersons(persons);
		return pi;
	}
}
