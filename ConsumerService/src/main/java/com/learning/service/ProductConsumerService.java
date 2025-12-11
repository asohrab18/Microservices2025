package com.learning.service;

import com.learning.model.Product;
import com.learning.model.ProductInfo;

public interface ProductConsumerService {

	public ProductInfo getProducts();
	
	public Product getProduct(int id);
}
