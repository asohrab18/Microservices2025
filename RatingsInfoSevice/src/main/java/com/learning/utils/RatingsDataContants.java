package com.learning.utils;

public final class RatingsDataContants {
	
	private RatingsDataContants() {
	}
	
	/** Numbers */
	public static final int ZERO = 0;

	/** Messages */
	public static final String DATA_REQUIRED = "Request data is required.";
	public static final String MSG_SUCCESSFUL = "sucessfully completed.";

	/** OTHERS */
	public static final String DEFAULT = "default";
	public static final String PATH_VARIABLE_USER_ID = "{userId}";
	public static final String RATINGS = "ratings";
	public static final String SLASH = "/";
	public static final String USER_ID = "userId";
	public static final String V2 = "v2";
	public static final String SLASH_V2 = SLASH + V2;
	public static final String SLASH_USER_ID = SLASH + USER_ID + SLASH;
	public static final String URL_USER_ID_PATH = SLASH_USER_ID + PATH_VARIABLE_USER_ID;
}