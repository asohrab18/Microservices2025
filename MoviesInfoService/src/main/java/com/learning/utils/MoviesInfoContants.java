package com.learning.utils;

public final class MoviesInfoContants {
	
	private MoviesInfoContants() {
	}
	
	/** Numbers */
	public static final int ZERO = 0;

	/** Messages */
	public static final String DATA_ABSENT = "data is not present.";
	public static final String DATA_DELETED = "data deleted successfully.";
	public static final String DATA_NOT_UPDATED = "data not updated.";
	public static final String DATA_REQUIRED = "Request data is required.";
	public static final String DATA_UPDATED = "data updated successfully.";
	public static final String ID_GREATER_THAN_ZERO = "Id greater than zero is required.";
	public static final String MSG_SUCCESSFUL = "sucessfully completed.";

	/** OTHERS */
	public static final String DEFAULT = "default";
	public static final String ID = "id";
	public static final String MOVIE_ID = "movieId";
	public static final String MOVIES = "movies";
	public static final String SLASH = "/";
	public static final String V2 = "v2";
	public static final String SLASH_V2 = SLASH + V2;
	public static final String PATH_VARIABLE_ID = "{id}";
	public static final String PATH_VARIABLE_MOVIE_ID = "{movieId}";
	public static final String SLASH_ID = SLASH + ID + SLASH;
	public static final String SLASH_MOVIE_ID = SLASH + MOVIE_ID + SLASH;
	public static final String URL_ID_PATH = SLASH_ID + PATH_VARIABLE_ID;
	public static final String URL_MOVIE_ID_PATH = SLASH_MOVIE_ID + PATH_VARIABLE_MOVIE_ID;
}