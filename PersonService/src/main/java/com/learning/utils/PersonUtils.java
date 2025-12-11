package com.learning.utils;

public final class PersonUtils {

	private PersonUtils() {
	}

	/** Numbers */
	public static final int ZERO = 0;
	public static final int ONE = 1;
	public static final int TWO = 2;
	public static final int THREE = 3;

	/** Messages */
	public static final String DATA_REQUIRED = "Request data is required.";
	public static final String MSG_FAILED = "Provider Service failed!";
	public static final String MSG_GREET = "Hello from Provider Service!";
	public static final String MSG_SUCCESSFUL = "sucessfully completed.";

	/** OTHERS */
	public static final String GREETINGS = "greetings";
	public static final String PERSONS = "persons";

	public static final String ID = "id";
	public static final String SLASH = "/";
	public static final String ID_PARAM = "{id}";
	public static final String ID_PATH = SLASH + ID + SLASH + ID_PARAM;
}
