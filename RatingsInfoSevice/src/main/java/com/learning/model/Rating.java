package com.learning.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rating {
	/**
	 * If we use both @Id and @GeneratedValue annotations then it creates primary
	 * key (NOT NULL & UNIQUE) with Auto-Increment
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String userId;
	private String movieId;
	private double rating;

	public Rating() {
	}

	public Rating(int id, String userId, String movieId, double rating) {
		this.id = id;
		this.userId = userId;
		this.movieId = movieId;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", userId=" + userId + ", movieId=" + movieId + ", rating=" + rating + "]";
	}

}