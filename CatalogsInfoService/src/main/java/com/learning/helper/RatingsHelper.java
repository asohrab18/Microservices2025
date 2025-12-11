package com.learning.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.learning.model.Rating;
import com.learning.model.Ratings;
import com.learning.model.RatingsByUserId;
import com.learning.model.RatingsData;
import com.learning.utils.CatalogContants;

@Component
public class RatingsHelper {
	private static final Logger LOG = LoggerFactory.getLogger(RatingsHelper.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CircuitBreakerFactory<?, ?> cbFactory;

	public List<Ratings> getRatings(String userId) throws Exception {
		List<Ratings> ratings = new ArrayList<>();
		RatingsByUserId ratingsByUserId = findRatingsByUserId(userId);
		Optional<RatingsByUserId> ratingsByUserIdOpt = Optional.ofNullable(ratingsByUserId);
		if (!ratingsByUserIdOpt.isPresent()) {
			LOG.info(CatalogContants.DATA_ABSENT);
			return ratings;
		}
		List<Ratings> ratingsFromService = ratingsByUserId.getRatings();
		Optional<List<Ratings>> ratingsOpt = Optional.ofNullable(ratingsFromService);
		if (!ratingsOpt.isPresent() || ratingsOpt.get().isEmpty()) {
			LOG.info(CatalogContants.DATA_ABSENT);
			return ratings;
		}
		LOG.info(CatalogContants.MSG_SUCCESSFUL);
		ratings = ratingsFromService;
		return ratings;
	}

	private RatingsByUserId findRatingsByUserId(String userId) {
		CircuitBreaker cb = cbFactory.create(CatalogContants.CIRCUIT_BREAKER_RATINGS);

		return cb.run(() -> restTemplate.getForObject(CatalogContants.RATINGS_SERVICE_USER_ID_URL + userId,
				RatingsByUserId.class), throwable -> fallbackRatingsByUserId(userId, throwable));
	}

	private RatingsByUserId fallbackRatingsByUserId(String userId, Throwable t) {
		RatingsByUserId rd = new RatingsByUserId();
		rd.setUserId(userId);

		rd.setRatings(List.of(new Ratings(CatalogContants.ONE, CatalogContants.DEFAULT, CatalogContants.DEFAULT_RATING)));

		return rd;
	}

	public List<Rating> getRatings() throws Exception {
		List<Rating> ratings = new ArrayList<>();
		RatingsData ratingsData = findRatingsData();
		Optional<RatingsData> ratingsDataOpt = Optional.ofNullable(ratingsData);
		if (!ratingsDataOpt.isPresent()) {
			LOG.info(CatalogContants.DATA_ABSENT);
			return ratings;
		}
		List<Rating> ratingsFromService = ratingsData.getRatings();
		Optional<List<Rating>> ratingsOpt = Optional.ofNullable(ratingsFromService);
		if (!ratingsOpt.isPresent() || ratingsOpt.get().isEmpty()) {
			LOG.info(CatalogContants.DATA_ABSENT);
			return ratings;
		}
		LOG.info(CatalogContants.MSG_SUCCESSFUL);
		ratings = ratingsFromService;
		return ratings;
	}

	private RatingsData findRatingsData() {
		CircuitBreaker cb = cbFactory.create(CatalogContants.CIRCUIT_BREAKER_RATINGS);

		return cb.run(() -> restTemplate.getForObject(CatalogContants.RATINGS_SERVICE_URL, RatingsData.class),
				throwable -> fallbackRatingsData(throwable));
	}

	private RatingsData fallbackRatingsData(Throwable t) {
		RatingsData rd = new RatingsData();
		rd.setTotalRatings(CatalogContants.ONE);

		rd.setRatings(List.of(new Rating(CatalogContants.ONE, CatalogContants.DEFAULT, CatalogContants.DEFAULT, CatalogContants.DEFAULT_RATING)));

		return rd;
	}
}
