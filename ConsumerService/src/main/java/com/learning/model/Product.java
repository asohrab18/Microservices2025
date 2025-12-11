package com.learning.model;

public class Product {
	
	private int id;
	private String name;
	private Double rate;

	public Product() {
	}

	public Product(int id, String name, Double rate) {
		this.id = id;
		this.name = name;
		this.rate = rate;
	}

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

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", rate=" + rate + "]";
	}
}
