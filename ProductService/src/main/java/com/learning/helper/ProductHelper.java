package com.learning.helper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.learning.exception.MissingRequiredDataException;
import com.learning.model.Product;
import com.learning.model.ProductInfo;
import com.learning.utils.ProductUtils;

@Component
public class ProductHelper {

	static List<Product> products = null;;

	static Map<Integer, Product> productsMap = null;

	static {
		Product p1 = new Product(ProductUtils.ONE, "Horlicks", 540d);
		Product p2 = new Product(ProductUtils.TWO, "Lipton Tea", 456d);
		Product p3 = new Product(ProductUtils.THREE, "Usha Fan", 1500d);

		products = Arrays.asList(p1, p2, p3);

		productsMap = new HashMap<>();
		productsMap.put(ProductUtils.ONE, p1);
		productsMap.put(ProductUtils.TWO, p2);
		productsMap.put(ProductUtils.THREE, p3);
	}

	public Product findProduct(int id) throws Exception {
		if (id <= ProductUtils.ZERO) {
			throw new MissingRequiredDataException(ProductUtils.DATA_REQUIRED);
		}
		return productsMap.get(id);
	}

	public ProductInfo findProducts() {
		ProductInfo pi = new ProductInfo();
		pi.setTotalCount(products.size());
		pi.setProducts(products);
		return pi;
	}
}
