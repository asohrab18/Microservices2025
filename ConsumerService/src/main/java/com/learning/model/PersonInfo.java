package com.learning.model;

import java.util.List;

public class PersonInfo {
	private int totalCount;
	private List<Person> persons;

	public PersonInfo() {
	}

	public PersonInfo(int totalCount, List<Person> persons) {
		super();
		this.totalCount = totalCount;
		this.persons = persons;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "PersonInfo [totalCount=" + totalCount + ", persons=" + persons + "]";
	}

}
