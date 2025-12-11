package com.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learning.helper.FeignHelper;

@Service
public class FeignServiceImpl implements FeignService {

	@Autowired
	private FeignHelper helper;

	@Override
	public Double getFactorial(Double num) throws Exception {
		return helper.getFactorial(num);
	}
}
