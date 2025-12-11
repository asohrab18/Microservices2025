package com.learning.model;

import java.util.List;

public class MoviesInfo {
	private int totalMovies;
	private List<Movie> movies;

	public MoviesInfo() {
	}

	public MoviesInfo(int totalMovies, List<Movie> movies) {
		this.totalMovies = totalMovies;
		this.movies = movies;
	}

	public int getTotalMovies() {
		return totalMovies;
	}

	public void setTotalMovies(int totalMovies) {
		this.totalMovies = totalMovies;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "MoviesInfo [totalMovies=" + totalMovies + ", movies=" + movies + "]";
	}

}
