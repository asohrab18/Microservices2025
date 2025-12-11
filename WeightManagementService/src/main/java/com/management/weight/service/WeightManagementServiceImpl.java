package com.management.weight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.weight.helper.WeightManagementHelper;
import com.management.weight.model.Person;

@Service
public class WeightManagementServiceImpl implements WeightManagementService {
	@Autowired
	private WeightManagementHelper helper;

	@Override
	public Person getDetails(Person person) throws Exception {
		return helper.getDetails(person);
	}
}
