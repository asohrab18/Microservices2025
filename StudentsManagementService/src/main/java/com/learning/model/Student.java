package com.learning.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

	/** [1] If we use @Id annotation alone then it creates 
	 * only primary key (NOT NULL & UNIQUE) but not Auto-Increment. 
	 * [2] If we use both @Id and @GeneratedValue annotations then it creates 
	 * primary key (NOT NULL & UNIQUE) with Auto-Increment */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}