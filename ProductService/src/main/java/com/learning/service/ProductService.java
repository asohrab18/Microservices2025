package com.learning.service;

import com.learning.model.Product;
import com.learning.model.ProductInfo;

public interface ProductService {

	Product findProduct(int id) throws Exception;

	ProductInfo findProducts() throws Exception;
}
