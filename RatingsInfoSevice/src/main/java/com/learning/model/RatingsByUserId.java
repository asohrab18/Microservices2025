package com.learning.model;

import java.util.List;

public class RatingsByUserId {

	private String userId;
	private List<Ratings> ratings;

	public RatingsByUserId() {
	}

	public RatingsByUserId(String userId, List<Ratings> ratings) {
		this.userId = userId;
		this.ratings = ratings;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Ratings> getRatings() {
		return ratings;
	}

	public void setRatings(List<Ratings> ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "RatingsByUserId [userId=" + userId + ", ratings=" + ratings + "]";
	}

}
