package com.learning.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.learning.utils.FeignContants;

@Component
public class FeignHelper {
	private static final Logger LOG = LoggerFactory.getLogger(FeignHelper.class);

	@Autowired
	private CalculatorProxy proxy;

	public Double getFactorial(Double num) throws Exception {
		ResponseEntity<Double> factResponse = proxy.getFactorial(num);
		LOG.info(FeignContants.MSG_SUCCESSFUL);
		return factResponse.getBody();
	}
}
