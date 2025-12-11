package com.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learning.helper.CalculatorHelper;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Autowired
	private CalculatorHelper helper;

	@Override
	public Double getFactorial(Double num) throws Exception {
		return helper.getFactorial(num);
	}
}
