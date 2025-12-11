package com.learning.helper;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.learning.model.Product;
import com.learning.model.ProductInfo;
import com.learning.utils.ConsumerUtils;

@Component
public class ProductHelper {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CircuitBreakerFactory<?, ?> cbFactory;

	public ProductInfo getProducts() {
		CircuitBreaker cb = cbFactory.create(ConsumerUtils.CIRCUIT_BREAKER_PRODUCT);
		return cb.run(
				() -> restTemplate.getForObject(ConsumerUtils.URL_PRODUCTS, ProductInfo.class),
				throwable -> fallbackProducts(throwable));
	}

	private ProductInfo fallbackProducts(Throwable t) {
		ProductInfo pi = new ProductInfo();
		pi.setTotalCount(ConsumerUtils.ONE);
		pi.setProducts(
				List.of(new Product(ConsumerUtils.ONE, ConsumerUtils.FALLBACK_PRODUCT_NAME, ConsumerUtils.ONE_D)));
		return pi;
	}

	public Product getProduct(int id) {
		CircuitBreaker cb = cbFactory.create(ConsumerUtils.CIRCUIT_BREAKER_PRODUCT);
		return cb.run(() -> restTemplate.getForObject(ConsumerUtils.URL_PRODUCTS_ID + id,
				Product.class), throwable -> fallbackProduct(id, throwable));
	}

	private Product fallbackProduct(int id, Throwable t) {
		return new Product(id, ConsumerUtils.FALLBACK_PRODUCT_NAME, ConsumerUtils.ONE_D);
	}
}
