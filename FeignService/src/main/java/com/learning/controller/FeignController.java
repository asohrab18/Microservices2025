package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learning.service.FeignService;
import com.learning.utils.FeignContants;

@RestController
@RequestMapping(FeignContants.FEIGN)
public class FeignController {

	@Autowired
	private FeignService service;

	@GetMapping(FeignContants.URL_FACTORIAL)
	public ResponseEntity<Double> getFactorial(@PathVariable Double num) throws Exception {
		Double fact = service.getFactorial(num);
		return new ResponseEntity<>(fact, HttpStatus.OK);
	}

}