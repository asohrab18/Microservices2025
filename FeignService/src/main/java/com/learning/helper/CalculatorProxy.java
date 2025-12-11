package com.learning.helper;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.learning.utils.FeignContants;

@FeignClient(name = FeignContants.CALCULATOR_SERVICE)
public interface CalculatorProxy {

	@GetMapping(FeignContants.URL_CALC_FACTORIAL)
	public ResponseEntity<Double> getFactorial(@PathVariable Double num) throws Exception;
}
