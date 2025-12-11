package com.learning.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.learning.model.Movie;
import com.learning.model.MoviesInfo;
import com.learning.utils.CatalogContants;

@Component
public class MoviesHelper {
	private static final Logger LOG = LoggerFactory.getLogger(MoviesHelper.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CircuitBreakerFactory<?, ?> cbFactory;

	public Map<String, Movie> getMovies() throws Exception {
		Map<String, Movie> moviesMap = new HashMap<>();
		MoviesInfo moviesInfo = findMoviesInfo();
		Optional<MoviesInfo> moviesInfoOpt = Optional.ofNullable(moviesInfo);
		if (!moviesInfoOpt.isPresent()) {
			LOG.info(CatalogContants.DATA_ABSENT);
			return moviesMap;
		}
		List<Movie> movies = moviesInfo.getMovies();
		Optional<List<Movie>> moviesOpt = Optional.ofNullable(movies);
		if (!moviesOpt.isPresent() || moviesOpt.get().isEmpty()) {
			LOG.info(CatalogContants.DATA_ABSENT);
			return moviesMap;
		}
		for (Movie movie : movies) {
			if (movie != null) {
				String movieId = (movie.getMovieId() == null ? movie.getMovieId() : movie.getMovieId().trim());
				moviesMap.put(movieId, movie);
			}
		}
		LOG.info(CatalogContants.MSG_SUCCESSFUL);
		return moviesMap;
	}

	private MoviesInfo findMoviesInfo() {
		CircuitBreaker cb = cbFactory.create(CatalogContants.CIRCUIT_BREAKER_MOVIES);
		
		return cb.run(() -> restTemplate.getForObject(CatalogContants.MOVIES_SERVICE_URL, MoviesInfo.class),
				throwable -> fallbackMoviesInfo(throwable));
	}

	private MoviesInfo fallbackMoviesInfo(Throwable t) {
		MoviesInfo mi = new MoviesInfo();
		mi.setTotalMovies(CatalogContants.ONE);
		
		mi.setMovies(List.of(new Movie(CatalogContants.ONE, CatalogContants.DEFAULT, CatalogContants.DEFAULT,
				CatalogContants.DEFAULT, CatalogContants.DEFAULT_RATING)));

		return mi;
	}
}