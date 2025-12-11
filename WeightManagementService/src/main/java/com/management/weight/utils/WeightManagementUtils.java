package com.management.weight.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeightManagementUtils {
	private static final Logger LOG = LoggerFactory.getLogger(WeightManagementUtils.class);

	public static LocalDateTime getLocalDateTime(long seconds) {
		LocalDateTime today = LocalDateTime.now();
		return today.plusSeconds(seconds);
	}

	public static String formatLocalDateTime(LocalDateTime dateInput) {
		if(dateInput == null) {
			LOG.info("Date Input id required.");
			return "Date Input id required.";
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(WeightManagementContants.DATE_PATTERN);
		String formattedLocalDateTime = dateInput.format(formatter);
		return formattedLocalDateTime;
	}

	public static float getDaysToLossRequiredWeight(int caloriesLossPerDay, float requiredWeightLossInKg) {
		float days = WeightManagementContants.CALORIES_EQUIVALENT_TO_ONE_KG / caloriesLossPerDay;
		return days * requiredWeightLossInKg;
	}

	public static float getWeightDifference(float firstWeight, float secondWeight) {
		float difference = Math.abs(firstWeight - secondWeight);
		return difference;
	}

	public static long getSeconds(float days) {
		float seconds = days * WeightManagementContants.TWENTY_FOUR * WeightManagementContants.SIXTY * WeightManagementContants.SIXTY;
		long secondsLong = (long) seconds;
		return secondsLong;
	}

	public static float getMonths(float days) {
		return days / WeightManagementContants.THIRTY;
	}

	public static float getYears(float month) {
		return month / WeightManagementContants.TWELVE;
	}
}