package com.learning.helper;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.learning.model.Person;
import com.learning.model.PersonInfo;
import com.learning.utils.ConsumerUtils;

@Component
public class PersonHelper {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CircuitBreakerFactory<?, ?> cbFactory;
	
	public String greet(Integer num) {
		CircuitBreaker cb = cbFactory.create(ConsumerUtils.CIRCUIT_BREAKER_PERSON);
		return cb.run(() -> restTemplate.getForObject(ConsumerUtils.URL_PERSONS_GREETINGS + num, String.class),
				throwable -> fallbackGreet(num, throwable));
	}

	public PersonInfo getPersons() {
		CircuitBreaker cb = cbFactory.create(ConsumerUtils.CIRCUIT_BREAKER_PERSON);
		return cb.run(() -> restTemplate.getForObject(ConsumerUtils.URL_PERSONS, PersonInfo.class),
				throwable -> fallbackPersons(throwable));
	}

	public Person getPerson(int id) {
		CircuitBreaker cb = cbFactory.create(ConsumerUtils.CIRCUIT_BREAKER_PERSON);
		return cb.run(() -> restTemplate.getForObject(ConsumerUtils.URL_PERSONS_ID + id, Person.class),
				throwable -> fallbackPerson(id, throwable));
	}

	private String fallbackGreet(Integer num, Throwable t) {
		return ConsumerUtils.FALLBACK_PERSON_SERVICE;
	}

	private PersonInfo fallbackPersons(Throwable t) {
		PersonInfo pi = new PersonInfo();
		pi.setTotalCount(ConsumerUtils.ONE);
		pi.setPersons(List.of(new Person(ConsumerUtils.ONE, ConsumerUtils.FALLBACK_PERSON_NAME, ConsumerUtils.ONE)));
		return pi;
	}

	private Person fallbackPerson(int id, Throwable t) {
		return new Person(id, ConsumerUtils.FALLBACK_PERSON_NAME, ConsumerUtils.ONE);
	}
}
