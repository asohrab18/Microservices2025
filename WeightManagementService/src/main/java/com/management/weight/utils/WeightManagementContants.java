package com.management.weight.utils;

public final class WeightManagementContants {
	
	private WeightManagementContants() {
	}
	
	/** Numbers */
	public static final int ZERO = 0;
	public static final float ONE = 1f;
	public static final int TWELVE = 12;
	public static final int TWENTY_FOUR = 24;
	public static final int THIRTY = 30;
	public static final int SIXTY = 60;
	public static final float CALORIES_EQUIVALENT_TO_ONE_KG = 7700f;
	
	/** Messages */
	public static final String MSG_CURRENT_WT_LT_DESIRED_WT = "currentWeightInKg cannot be less than desiredWeightInKg.";
	public static final String MSG_WELCOME = "Welcome to the world of weight-management!";
	public static final String MSG_ZERO_CAL_LOSS_PER_DAY = "caloriesLossPerDay cannot be zero.";
	public static final String MSG_ZERO_CURRENT_WT = "currentWeightInKg cannot be zero.";
	public static final String MSG_ZERO_DESIRED_WT = "desiredWeightInKg cannot be zero.";
	public static final String MSG_SUCCESSFUL = "sucessfully completed.";
	
	/** OTHERS */
	public static final String DATE_PATTERN = "dd-MMM-yyyy";
	public static final String DETAILS = "details";
	public static final String GREETINGS = "greetings";
	public static final String MESSAGES = "messages";
	public static final String WEIGHT_MGMT = "weight-management";
}