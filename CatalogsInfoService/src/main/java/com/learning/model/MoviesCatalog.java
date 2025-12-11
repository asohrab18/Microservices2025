package com.learning.model;

import java.util.List;

public class MoviesCatalog {
	private int totalItems;
	private List<MovieRating> movieRatings;

	public MoviesCatalog() {
	}

	public MoviesCatalog(int totalItems, List<MovieRating> movieRatings) {
		super();
		this.totalItems = totalItems;
		this.movieRatings = movieRatings;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public List<MovieRating> getMovieRatings() {
		return movieRatings;
	}

	public void setMovieRatings(List<MovieRating> movieRatings) {
		this.movieRatings = movieRatings;
	}

	@Override
	public String toString() {
		return "MoviesCatalog [totalItems=" + totalItems + ", movieRatings=" + movieRatings + "]";
	}

}