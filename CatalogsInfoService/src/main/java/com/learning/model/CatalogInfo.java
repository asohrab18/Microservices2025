package com.learning.model;

import java.util.List;

public class CatalogInfo {
	private String userId;
	private List<Movie> movies;

	public CatalogInfo() {
	}

	public CatalogInfo(String userId, List<Movie> movies) {
		super();
		this.userId = userId;
		this.movies = movies;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Catalog [userId=" + userId + ", movies=" + movies + "]";
	}
}