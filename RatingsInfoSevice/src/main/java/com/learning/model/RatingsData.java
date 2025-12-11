package com.learning.model;

import java.util.List;

public class RatingsData {
	private int totalRatings;
	private List<Rating> ratings;

	public RatingsData() {
	}

	public RatingsData(int totalRatings, List<Rating> ratings) {
		this.totalRatings = totalRatings;
		this.ratings = ratings;
	}

	public int getTotalRatings() {
		return totalRatings;
	}

	public void setTotalRatings(int totalRatings) {
		this.totalRatings = totalRatings;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "RatingsData [totalRatings=" + totalRatings + ", ratings=" + ratings + "]";
	}
}
