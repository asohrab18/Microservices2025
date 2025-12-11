package com.learning.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.learning.exception.MissingRequiredDataException;
import com.learning.exception.UnprocessableException;
import com.learning.utils.CalculatorContants;

@Component
public class CalculatorHelper {
	private static final Logger LOG = LoggerFactory.getLogger(CalculatorHelper.class);

	public Double getFactorial(Double num) throws Exception {
		if (num == null) {
			throw new MissingRequiredDataException(CalculatorContants.DATA_REQUIRED);
		}
		if (num < CalculatorContants.ZERO_D) {
			throw new UnprocessableException(CalculatorContants.NO_FACTORIAL);
		}
		if (num == CalculatorContants.ZERO_D) {
			return CalculatorContants.ONE_D;
		}
		double fact = CalculatorContants.ONE_D;
		for (double i = num; i > CalculatorContants.ZERO_D; i--) {
			fact = fact * i;
		}
		LOG.info(CalculatorContants.MSG_SUCCESSFUL);
		return fact;
	}
}
