package com.learning.service;

import com.learning.model.Movie;
import com.learning.model.MoviesInfo;

public interface MoviesInfoService {

	Movie createMovie(Movie movie) throws Exception;

	MoviesInfo getMovies() throws Exception;
	
	MoviesInfo getMoviesV2() throws Exception;

	Movie getMovie(String movieId) throws Exception;

	String updateMovie(Movie movie) throws Exception;
	
	String deleteMovie(int id) throws Exception;
}
