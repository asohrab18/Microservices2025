package com.learning.utils;

public final class CatalogContants {

	private CatalogContants() {
	}

	/** Numbers */
	public static final int ZERO = 0;
	public static final int ONE = 1;
	public static final double DEFAULT_RATING = 3.5d;

	/** Messages */
	public static final String CIRCUIT_BREAKER_MOVIES = "CircuitBreakerMovies";
	public static final String CIRCUIT_BREAKER_RATINGS = "CircuitBreakerRatings";
	public static final String DATA_ABSENT = "data is not present.";
	public static final String DATA_REQUIRED = "Request data is required.";
	public static final String MSG_SUCCESSFUL = "sucessfully completed.";

	/** OTHERS */
	public static final String DEFAULT = "default";
	public static final String USER_ID = "userId";
	public static final String CATALOGS = "catalogs";
	public static final String PATH_VARIABLE_USER_ID = "{userId}";
	public static final String SLASH = "/";
	public static final String SLASH_USER_ID = SLASH + USER_ID + SLASH;
	public static final String URL_USER_ID_PATH = SLASH_USER_ID + PATH_VARIABLE_USER_ID;

	/** SERVICE URLs */
	// public static final String MOVIES_SERVICE_URL = "http://localhost:7001/movies";
	// public static final String RATINGS_SERVICE_URL = "http://localhost:7002/ratings";

	/**
	 * Both Capital & small letters are allowed after using @LoadBalanced on
	 * RestTemplate bean.
	 */
	// public static final String MOVIES_SERVICE_URL = "http://movies-info-service/movies";
	// public static final String RATINGS_SERVICE_URL = "http://ratings-info-service/ratings";
	// public static final String MOVIES_SERVICE_URL = "http://MOVIES-INFO-SERVICE/v2/movies";
	// public static final String RATINGS_SERVICE_URL = "http://RATINGS-INFO-SERVICE/ratings";

	/** Using API Gateway and removing @LoadBalanced from RestTemplate bean. */
	public static final String API_GATEWAY_URL = "http://localhost:8765" + SLASH;
	public static final String MOVIES_SERVICE_URL = API_GATEWAY_URL + "movies-info-service/movies/v2";
	public static final String RATINGS_SERVICE_URL = API_GATEWAY_URL + "ratings-info-service/ratings" + SLASH;
	public static final String RATINGS_SERVICE_USER_ID_URL = RATINGS_SERVICE_URL + USER_ID + SLASH;
}