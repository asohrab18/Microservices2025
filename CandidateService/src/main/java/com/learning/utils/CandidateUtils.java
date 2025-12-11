package com.learning.utils;

public final class CandidateUtils {

	private CandidateUtils() {
	}

	/** Numbers */
	public static final int ZERO = 0;
	public static final int ONE = 1;
	public static final int TWO = 2;
	public static final int THREE = 3;

	/** Messages */
	public static final String DATA_REQUIRED = "Request data is required.";
	public static final String MSG_FAILED = "Candidate Service failed!";
	public static final String MSG_SUCCESSFUL = "sucessfully completed.";

	/** OTHERS */
	public static final String CANDIDATES = "candidates";
	public static final String ID = "id";
	public static final String SLASH = "/";
	public static final String ID_PARAM = "{id}";
	public static final String ID_PATH = SLASH + ID + SLASH + ID_PARAM;
}
