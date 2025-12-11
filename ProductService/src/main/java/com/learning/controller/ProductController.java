package com.learning.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learning.model.Product;
import com.learning.model.ProductInfo;
import com.learning.service.ProductService;
import com.learning.utils.ProductUtils;

@RestController
@RequestMapping(ProductUtils.PRODUCTS)
public class ProductController {
	private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService service;

	@GetMapping(ProductUtils.SLASH)
	public ProductInfo getProducts() throws Exception {
		LOG.info(ProductUtils.MSG_SUCCESSFUL);
		return service.findProducts();
	}

	@GetMapping(ProductUtils.ID_PATH)
	public Product getProduct(@PathVariable(required = true) Integer id) throws Exception {
		LOG.info(ProductUtils.MSG_SUCCESSFUL);
		return service.findProduct(id);
	}
}