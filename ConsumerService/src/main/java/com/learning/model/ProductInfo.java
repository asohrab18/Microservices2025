package com.learning.model;

import java.util.List;

public class ProductInfo {

	private int totalCount;
	private List<Product> products;

	public ProductInfo() {
	}

	public ProductInfo(int totalCount, List<Product> products) {
		this.totalCount = totalCount;
		this.products = products;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "ProductInfo [totalCount=" + totalCount + ", products=" + products + "]";
	}
}
