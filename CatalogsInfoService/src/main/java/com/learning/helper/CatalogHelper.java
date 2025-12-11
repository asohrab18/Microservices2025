package com.learning.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learning.exception.MissingRequiredDataException;
import com.learning.model.CatalogInfo;
import com.learning.model.Movie;
import com.learning.model.MovieRating;
import com.learning.model.MoviesCatalog;
import com.learning.model.Rating;
import com.learning.model.Ratings;
import com.learning.utils.CatalogContants;

@Component
public class CatalogHelper {
	private static final Logger LOG = LoggerFactory.getLogger(CatalogHelper.class);

	@Autowired
	private RatingsHelper ratingsHelper;

	@Autowired
	private MoviesHelper moviesHelper;

	public CatalogInfo getMoviesCatalog(String userId) throws Exception {
		if (StringUtils.isBlank(userId)) {
			LOG.info(CatalogContants.DATA_REQUIRED);
			throw new MissingRequiredDataException(CatalogContants.DATA_REQUIRED);
		}
		CatalogInfo catalog = new CatalogInfo();
		catalog.setUserId(userId);

		List<Movie> movies = new ArrayList<>();
		Movie movie = null;

		List<Ratings> ratings = ratingsHelper.getRatings(userId);
		Optional<List<Ratings>> ratingsOpt = Optional.ofNullable(ratings);
		if (!ratingsOpt.isPresent() || ratingsOpt.get().isEmpty()) {
			LOG.info(CatalogContants.DATA_ABSENT);
			movie = new Movie(CatalogContants.ONE, CatalogContants.DEFAULT, CatalogContants.DEFAULT, CatalogContants.DEFAULT, CatalogContants.DEFAULT_RATING);
			movies.add(movie);
			catalog.setMovies(movies);
			return catalog;
		}
		Map<String, Movie> moviesMap = moviesHelper.getMovies();
		for (Ratings rating : ratings) {
			double rate = rating.getRating();
			String movieId = (rating.getMovieId() == null ? CatalogContants.DEFAULT : rating.getMovieId().trim());
			int id = CatalogContants.ZERO;
			String name = CatalogContants.DEFAULT;
			String description = CatalogContants.DEFAULT;
			if (moviesMap.containsKey(movieId)) {
				Movie movieVal = moviesMap.get(movieId);
				if (movieVal != null) {
					id = movieVal.getId();
					name = (movieVal.getName() == null ? CatalogContants.DEFAULT : movieVal.getName().trim());
					description = (movieVal.getDescription() == null ? CatalogContants.DEFAULT : movieVal.getDescription().trim());
				}
			}
			movie = new Movie();
			movie.setRating(rate);
			movie.setMovieId(movieId);
			movie.setId(id);
			movie.setName(name);
			movie.setDescription(description);
			movies.add(movie);
		}
		catalog.setMovies(movies);
		return catalog;
	}

	public MoviesCatalog getMoviesCatalog() throws Exception {
		MoviesCatalog moviesCatalog = new MoviesCatalog();
		List<MovieRating> movieRatings = new ArrayList<MovieRating>();
		List<Rating> ratings = ratingsHelper.getRatings();
		Optional<List<Rating>> ratingsOpt = Optional.ofNullable(ratings);
		if (!ratingsOpt.isPresent() || ratingsOpt.get().isEmpty()) {
			LOG.info(CatalogContants.DATA_ABSENT);
			MovieRating defaultMovieRating = new MovieRating(CatalogContants.DEFAULT, CatalogContants.DEFAULT, CatalogContants.DEFAULT, CatalogContants.DEFAULT, CatalogContants.DEFAULT_RATING);
			movieRatings.add(defaultMovieRating);
			moviesCatalog.setTotalItems(movieRatings.size());
			moviesCatalog.setMovieRatings(movieRatings);
			return moviesCatalog;
		}
		Map<String, Movie> moviesMap = moviesHelper.getMovies();
		MovieRating movieRating = null;
		for (Rating rating : ratings) {
			String description = CatalogContants.DEFAULT;
			String movieId = (rating.getMovieId() == null ? CatalogContants.DEFAULT : rating.getMovieId().trim());
			String movieName = CatalogContants.DEFAULT;
			double rate = rating.getRating();
			String userId = (rating.getUserId() == null ? CatalogContants.DEFAULT : rating.getUserId().trim());
			if (moviesMap.containsKey(movieId)) {
				Movie movieVal = moviesMap.get(movieId);
				if (movieVal != null) {
					movieName = (movieVal.getName() == null ? CatalogContants.DEFAULT : movieVal.getName().trim());
					description = (movieVal.getDescription() == null ? CatalogContants.DEFAULT : movieVal.getDescription().trim());
				}
			}
			movieRating = new MovieRating();
			movieRating.setDescription(description);
			movieRating.setMovieId(movieId);
			movieRating.setMovieName(movieName);
			movieRating.setRating(rate);
			movieRating.setUserId(userId);
			movieRatings.add(movieRating);
		}
		moviesCatalog.setTotalItems(movieRatings.size());
		moviesCatalog.setMovieRatings(movieRatings);
		return moviesCatalog;
	}
}
