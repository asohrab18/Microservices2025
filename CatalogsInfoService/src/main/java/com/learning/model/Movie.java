package com.learning.model;

public class Movie {
	
	private int id;
	private String movieId;
	private String name;
	private String description;
	private double rating;

	public Movie() {
	}

	public Movie(int id, String movieId, String name, String description, double rating) {
		super();
		this.id = id;
		this.movieId = movieId;
		this.name = name;
		this.description = description;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Movie [id=" + id + ", movieId=" + movieId + ", name=" + name + ", description=" + description
				+ ", rating=" + rating + "]";
	}

}