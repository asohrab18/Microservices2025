package com.learning.utils;

public final class ConsumerUtils {

	private ConsumerUtils() {
	}

	/** Numbers */
	public static final int ZERO = 0;
	public static final int ONE = 1;
	public static final double ONE_D = 1d;

	/** Messages */
	public static final String MSG_SUCCESSFUL = "sucessfully completed.";

	/** OTHERS */
	public static final String CANDIDATES = "candidates";
	public static final String CIRCUIT_BREAKER_CANDIDATE = "circuitBreakerCandidate";
	public static final String CIRCUIT_BREAKER_PERSON = "circuitBreakerPerson";
	public static final String CIRCUIT_BREAKER_PRODUCT = "circuitBreakerProduct";
	public static final String CONSUMERS = "consumers";
	public static final String FALLBACK_PERSON_NAME = "fallbackPersonName";
	public static final String FALLBACK_PRODUCT_NAME = "fallbackProductName";
	public static final String FALLBACK_PERSON_SERVICE = "Fallback response: Person Service is unavailable. Please try later.";
	public static final String GREETINGS = "greetings";
	public static final String ID = "id";
	public static final String ID_PARAM = "{id}";
	public static final String SLASH = "/";
	public static final String ID_PATH = SLASH + ID + SLASH + ID_PARAM;
	public static final String CANDIDATES_ID_PATH = CANDIDATES + ID_PATH;
	public static final String CANDIDATE_SERVICE = "candidate-service";
	public static final String DEFAULT = "default";
	
	public static final String PERSONS = "persons";
	public static final String PERSONS_ID_PATH = PERSONS + ID_PATH;
	public static final String PERSON_SERVICE = "person-service";
	public static final String PRODUCTS = "products";
	public static final String PRODUCTS_ID_PATH = PRODUCTS + ID_PATH;
	public static final String PRODUCT_SERVICE = "product-service";

	public static final String URL_API_GATEWAY = "http://localhost:8765";
	public static final String URL_PERSONS_GREETINGS = URL_API_GATEWAY + SLASH + PERSON_SERVICE + SLASH + PERSONS + SLASH + GREETINGS + "?num=";
	public static final String URL_PERSONS = URL_API_GATEWAY + SLASH + PERSON_SERVICE + SLASH + PERSONS + SLASH;
	public static final String URL_PERSONS_ID = URL_API_GATEWAY + SLASH + PERSON_SERVICE + SLASH + PERSONS + SLASH + ID + SLASH;

	public static final String URL_CANDIDATES = URL_API_GATEWAY + SLASH + CANDIDATE_SERVICE + SLASH + CANDIDATES + SLASH;
	public static final String URL_CANDIDATES_ID = URL_API_GATEWAY + SLASH + CANDIDATE_SERVICE + SLASH + CANDIDATES + SLASH + ID + SLASH;
	
	public static final String URL_PRODUCTS = URL_API_GATEWAY + SLASH + PRODUCT_SERVICE + SLASH + PRODUCTS + SLASH;
	public static final String URL_PRODUCTS_ID = URL_API_GATEWAY + SLASH + PRODUCT_SERVICE + SLASH + PRODUCTS + SLASH + ID + SLASH;
}
