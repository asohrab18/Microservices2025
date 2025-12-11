package com.learning.utils;

public final class FeignContants {
	
	private FeignContants() {
	}
	
	/** Messages */
	public static final String MSG_SUCCESSFUL = "sucessfully completed.";

	/** Others */
	public static final String CALCULATOR = "calculator";
	public static final String CALCULATOR_SERVICE = "calculator-service";
	public static final String FACTORIAL = "factorial";
	public static final String FEIGN = "feign";
	public static final String PATH_VARIABLE_NUM = "{num}";
	public static final String SLASH = "/";
	public static final String URL_FACTORIAL = FACTORIAL + SLASH + PATH_VARIABLE_NUM;
	public static final String URL_CALC_FACTORIAL = CALCULATOR + SLASH + URL_FACTORIAL;
}