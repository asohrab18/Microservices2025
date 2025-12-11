package com.management.weight.model;

public class Person {
	private String name;
	private String today;
	private int caloriesLossPerDay;
	private float currentWeightInKg;
	private float desiredWeightInKg;
	private float requiredWeightLossInKg;
	private float daysToLossOnekgWeight;
	private float daysToLossRequiredWeight;
	private float monthsToLossRequiredWeight;
	private float yearsToLossRequiredWeight;
	private String achievementDay;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public int getCaloriesLossPerDay() {
		return caloriesLossPerDay;
	}

	public void setCaloriesLossPerDay(int caloriesLossPerDay) {
		this.caloriesLossPerDay = caloriesLossPerDay;
	}

	public float getCurrentWeightInKg() {
		return currentWeightInKg;
	}

	public void setCurrentWeightInKg(float currentWeightInKg) {
		this.currentWeightInKg = currentWeightInKg;
	}

	public float getDesiredWeightInKg() {
		return desiredWeightInKg;
	}

	public void setDesiredWeightInKg(float desiredWeightInKg) {
		this.desiredWeightInKg = desiredWeightInKg;
	}

	public float getRequiredWeightLossInKg() {
		return requiredWeightLossInKg;
	}

	public void setRequiredWeightLossInKg(float requiredWeightLossInKg) {
		this.requiredWeightLossInKg = requiredWeightLossInKg;
	}

	public float getDaysToLossOnekgWeight() {
		return daysToLossOnekgWeight;
	}

	public void setDaysToLossOnekgWeight(float daysToLossOnekgWeight) {
		this.daysToLossOnekgWeight = daysToLossOnekgWeight;
	}

	public float getDaysToLossRequiredWeight() {
		return daysToLossRequiredWeight;
	}

	public void setDaysToLossRequiredWeight(float daysToLossRequiredWeight) {
		this.daysToLossRequiredWeight = daysToLossRequiredWeight;
	}

	public float getMonthsToLossRequiredWeight() {
		return monthsToLossRequiredWeight;
	}

	public void setMonthsToLossRequiredWeight(float monthsToLossRequiredWeight) {
		this.monthsToLossRequiredWeight = monthsToLossRequiredWeight;
	}

	public float getYearsToLossRequiredWeight() {
		return yearsToLossRequiredWeight;
	}

	public void setYearsToLossRequiredWeight(float yearsToLossRequiredWeight) {
		this.yearsToLossRequiredWeight = yearsToLossRequiredWeight;
	}

	public String getAchievementDay() {
		return achievementDay;
	}

	public void setAchievementDay(String achievementDay) {
		this.achievementDay = achievementDay;
	}
}
