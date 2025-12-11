package com.learning.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learning.exception.MissingRequiredDataException;
import com.learning.exception.UnprocessableException;
import com.learning.model.Movie;
import com.learning.model.MoviesInfo;
import com.learning.repository.MoviesInfoCustomRepo;
import com.learning.repository.MoviesInfoRepo;
import com.learning.utils.MoviesInfoContants;

@Component
public class MoviesInfoHelper {
	private static final Logger LOG = LoggerFactory.getLogger(MoviesInfoHelper.class);

	@Autowired
	private MoviesInfoRepo repo;

	@Autowired
	private MoviesInfoCustomRepo customRepo;

	public Movie createMovie(Movie movie) throws Exception {
		if (movie == null) {
			LOG.info(MoviesInfoContants.DATA_REQUIRED);
			throw new MissingRequiredDataException(MoviesInfoContants.DATA_REQUIRED);
		}
		String movieId = movie.getMovieId();
		String name = movie.getName();
		String description = movie.getDescription();
		if (StringUtils.isBlank(movieId) || StringUtils.isBlank(name) || StringUtils.isBlank(description)) {
			LOG.info(MoviesInfoContants.DATA_REQUIRED);
			throw new MissingRequiredDataException(MoviesInfoContants.DATA_REQUIRED);
		}
		movie = repo.save(movie);
		LOG.info(MoviesInfoContants.MSG_SUCCESSFUL);
		return movie;
	}

	public MoviesInfo getMovies() throws Exception {
		MoviesInfo moviesInfo = new MoviesInfo();
		List<Movie> movies = repo.findAll();
		Optional<List<Movie>> opt = Optional.ofNullable(movies);
		if (!opt.isPresent() || opt.get().isEmpty()) {
			moviesInfo.setMovies(new ArrayList<Movie>());
			moviesInfo.setTotalMovies(MoviesInfoContants.ZERO);
			LOG.info(MoviesInfoContants.MSG_SUCCESSFUL);
			return moviesInfo;
		}
		moviesInfo.setMovies(movies);
		moviesInfo.setTotalMovies(movies.size());
		LOG.info(MoviesInfoContants.MSG_SUCCESSFUL);
		return moviesInfo;
	}

	public MoviesInfo getMoviesV2() throws Exception {
		MoviesInfo moviesInfo = new MoviesInfo();
		List<Movie> moviesData = new ArrayList<Movie>();
		List<Movie> movies = repo.findAll();
		Optional<List<Movie>> opt = Optional.ofNullable(movies);
		if (!opt.isPresent() || opt.get().isEmpty()) {
			Movie defaultMovie = new Movie(MoviesInfoContants.ZERO, MoviesInfoContants.DEFAULT,
					MoviesInfoContants.DEFAULT, MoviesInfoContants.DEFAULT);
			moviesData.add(defaultMovie);
			moviesInfo.setMovies(moviesData);
			moviesInfo.setTotalMovies(moviesData.size());
			LOG.info(MoviesInfoContants.MSG_SUCCESSFUL);
			return moviesInfo;
		}
		moviesData = movies;
		moviesInfo.setMovies(moviesData);
		moviesInfo.setTotalMovies(moviesData.size());
		LOG.info(MoviesInfoContants.MSG_SUCCESSFUL);
		return moviesInfo;
	}

	public Movie getMovie(String movieId) throws Exception {
		if (StringUtils.isBlank(movieId)) {
			LOG.info(MoviesInfoContants.DATA_REQUIRED);
			throw new MissingRequiredDataException(MoviesInfoContants.DATA_REQUIRED);
		}
		Movie movie = repo.findMovieByMovieId(movieId);
		Optional<Movie> opt = Optional.ofNullable(movie);
		if (!opt.isPresent()) {
			LOG.info(MoviesInfoContants.DATA_ABSENT);
			return new Movie(MoviesInfoContants.ZERO, MoviesInfoContants.DEFAULT, MoviesInfoContants.DEFAULT,
					MoviesInfoContants.DEFAULT);
		}
		LOG.info(MoviesInfoContants.MSG_SUCCESSFUL);
		return movie;
	}

	public String updateMovie(Movie movie) throws Exception {
		if (movie == null) {
			LOG.info(MoviesInfoContants.DATA_REQUIRED);
			throw new MissingRequiredDataException(MoviesInfoContants.DATA_REQUIRED);
		}
		int id = movie.getId();
		if (id <= MoviesInfoContants.ZERO) {
			LOG.info(MoviesInfoContants.ID_GREATER_THAN_ZERO);
			throw new MissingRequiredDataException(MoviesInfoContants.ID_GREATER_THAN_ZERO);
		}
		String movieId = movie.getMovieId();
		String name = movie.getName();
		String description = movie.getDescription();
		if (StringUtils.isBlank(movieId) && StringUtils.isBlank(name) && StringUtils.isBlank(description)) {
			LOG.info(MoviesInfoContants.DATA_REQUIRED);
			throw new MissingRequiredDataException(MoviesInfoContants.DATA_REQUIRED);
		}
		String message = customRepo.update(movie);
		LOG.info(MoviesInfoContants.MSG_SUCCESSFUL);
		return message;
	}

	public String deleteMovie(int id) throws Exception {
		if (id <= MoviesInfoContants.ZERO) {
			LOG.info(MoviesInfoContants.ID_GREATER_THAN_ZERO);
			throw new MissingRequiredDataException(MoviesInfoContants.ID_GREATER_THAN_ZERO);
		}
		Optional<Movie> movie = repo.findById(id);
		if (!movie.isPresent()) {
			LOG.info(MoviesInfoContants.DATA_ABSENT);
			throw new UnprocessableException(MoviesInfoContants.DATA_ABSENT);
		}
		repo.delete(movie.get());
		LOG.info(MoviesInfoContants.MSG_SUCCESSFUL);
		return MoviesInfoContants.DATA_DELETED;
	}
}
