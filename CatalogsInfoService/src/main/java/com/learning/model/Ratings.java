package com.learning.model;

public class Ratings {
	private int id;
	private String movieId;
	private double rating;

	public Ratings() {
	}

	public Ratings(int id, String movieId, double rating) {
		this.id = id;
		this.movieId = movieId;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Ratings [id=" + id + ", movieId=" + movieId + ", rating=" + rating + "]";
	}

}