package com.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.helper.MoviesInfoHelper;
import com.learning.model.Movie;
import com.learning.model.MoviesInfo;

@Service
public class MoviesInfoServiceImpl implements MoviesInfoService {
	
	@Autowired
	private MoviesInfoHelper helper;

	@Override
	public Movie createMovie(Movie movie) throws Exception {
		return helper.createMovie(movie);
	}

	@Override
	public MoviesInfo getMovies() throws Exception {
		return helper.getMovies();
	}

	@Override
	public Movie getMovie(String movieId) throws Exception {
		return helper.getMovie(movieId);
	}

	@Override
	public String deleteMovie(int id) throws Exception {
		return helper.deleteMovie(id);
	}

	@Override
	public String updateMovie(Movie movie) throws Exception {
		return helper.updateMovie(movie);
	}

	@Override
	public MoviesInfo getMoviesV2() throws Exception {
		return helper.getMoviesV2();
	}
}