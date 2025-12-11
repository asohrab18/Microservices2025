package com.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learning.helper.ProductHelper;
import com.learning.model.Product;
import com.learning.model.ProductInfo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductHelper helper;

	@Override
	public Product findProduct(int id) throws Exception {
		return helper.findProduct(id);
	}

	@Override
	public ProductInfo findProducts() throws Exception {
		return helper.findProducts();
	}
}