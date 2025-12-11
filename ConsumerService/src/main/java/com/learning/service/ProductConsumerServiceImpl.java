package com.learning.service;

import org.springframework.stereotype.Service;

import com.learning.helper.ProductHelper;
import com.learning.model.Product;
import com.learning.model.ProductInfo;

@Service
public class ProductConsumerServiceImpl implements ProductConsumerService {
	private final ProductHelper helper;

	public ProductConsumerServiceImpl(ProductHelper helper) {
		this.helper = helper;
	}

	@Override
	public ProductInfo getProducts() {
		return helper.getProducts();
	}

	@Override
	public Product getProduct(int id) {
		return helper.getProduct(id);
	}
}