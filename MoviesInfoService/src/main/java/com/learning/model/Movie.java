package com.learning.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
	/**
	 * If we use both @Id and @GeneratedValue annotations then it creates primary
	 * key (NOT NULL & UNIQUE) with Auto-Increment
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true)
	private String movieId;

	private String name;
	private String description;

	public Movie() {
	}

	public Movie(int id, String movieId, String name, String description) {
		this.id = id;
		this.movieId = movieId;
		this.name = name;
		this.description = description;
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

	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieId=" + movieId + ", name=" + name + ", description=" + description + "]";
	}
}