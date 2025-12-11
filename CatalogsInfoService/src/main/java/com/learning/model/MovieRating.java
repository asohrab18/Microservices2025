package com.learning.model;

public class MovieRating {

	private String userId;
	private String movieId;
	private String movieName;
	private String description;
	private double rating;

	public MovieRating() {
	}

	public MovieRating(String userId, String movieId, String movieName, String description, double rating) {
		this.userId = userId;
		this.movieId = movieId;
		this.movieName = movieName;
		this.description = description;
		this.rating = rating;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "MovieRating [userId=" + userId + ", movieId=" + movieId + ", movieName=" + movieName + ", description="
				+ description + ", rating=" + rating + "]";
	}

}
