package com.learning.utils;

public final class CalculatorContants {

	private CalculatorContants() {
	}

	/** Numbers */
	public static final double ZERO_D = 0d;
	public static final double ONE_D = 1d;

	/** Messages */
	public static final String DATA_REQUIRED = "Request data is required.";
	public static final String MSG_SUCCESSFUL = "sucessfully completed.";
	public static final String NO_FACTORIAL = "Factorial is not defined for negative numbers.";

	/** Others */
	public static final String CALCULATOR = "calculator";
	public static final String FACTORIAL = "factorial";
	public static final String PATH_VARIABLE_NUM = "{num}";
	public static final String SLASH = "/";
	public static final String URL_FACTORIAL = FACTORIAL + SLASH + PATH_VARIABLE_NUM;
}