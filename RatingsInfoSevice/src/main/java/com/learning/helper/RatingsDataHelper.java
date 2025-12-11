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
import com.learning.model.Rating;
import com.learning.model.Ratings;
import com.learning.model.RatingsByUserId;
import com.learning.model.RatingsData;
import com.learning.repository.RatingsDataRepo;
import com.learning.utils.RatingsDataContants;

@Component
public class RatingsDataHelper {
	private static final Logger LOG = LoggerFactory.getLogger(RatingsDataHelper.class);

	@Autowired
	private RatingsDataRepo repo;

	public Rating createRating(Rating rating) throws Exception {
		if (rating == null) {
			LOG.info(RatingsDataContants.DATA_REQUIRED);
			throw new MissingRequiredDataException(RatingsDataContants.DATA_REQUIRED);
		}
		String userId = rating.getUserId();
		String movieId = rating.getMovieId();
		double rate = rating.getRating();
		if (StringUtils.isBlank(userId) || StringUtils.isBlank(movieId) || rate <= RatingsDataContants.ZERO) {
			LOG.info(RatingsDataContants.DATA_REQUIRED);
			throw new MissingRequiredDataException(RatingsDataContants.DATA_REQUIRED);
		}
		rating = repo.save(rating);
		LOG.info(RatingsDataContants.MSG_SUCCESSFUL);
		return rating;
	}

	public RatingsData getRatings() throws Exception {
		RatingsData ratingsData = new RatingsData();
		List<Rating> ratings = repo.findAll();
		Optional<List<Rating>> opt = Optional.ofNullable(ratings);
		if (!opt.isPresent() || opt.get().isEmpty()) {
			ratingsData.setRatings(new ArrayList<Rating>());
			ratingsData.setTotalRatings(RatingsDataContants.ZERO);
			LOG.info(RatingsDataContants.MSG_SUCCESSFUL);
			return ratingsData;
		}
		ratingsData.setRatings(ratings);
		ratingsData.setTotalRatings(ratings.size());
		LOG.info(RatingsDataContants.MSG_SUCCESSFUL);
		return ratingsData;
	}
	
	public RatingsData getRatingsV2() throws Exception {
		RatingsData ratingsData = new RatingsData();
		List<Rating> ratingsInfo = new ArrayList<Rating>();
		List<Rating> ratings = repo.findAll();
		Optional<List<Rating>> opt = Optional.ofNullable(ratings);
		if (!opt.isPresent() || opt.get().isEmpty()) {
			Rating defaultRating = new Rating(RatingsDataContants.ZERO, RatingsDataContants.DEFAULT,
					RatingsDataContants.DEFAULT, RatingsDataContants.ZERO);
			ratingsInfo.add(defaultRating);
			ratingsData.setRatings(ratingsInfo);
			ratingsData.setTotalRatings(ratingsInfo.size());
			LOG.info(RatingsDataContants.MSG_SUCCESSFUL);
			return ratingsData;
		}
		ratingsInfo = ratings;
		ratingsData.setRatings(ratingsInfo);
		ratingsData.setTotalRatings(ratingsInfo.size());
		LOG.info(RatingsDataContants.MSG_SUCCESSFUL);
		return ratingsData;
	}

	public RatingsByUserId getRatings(String userId) throws Exception {
		RatingsByUserId ratingsByUserId = new RatingsByUserId();
		if (StringUtils.isBlank(userId)) {
			LOG.info(RatingsDataContants.DATA_REQUIRED);
			throw new MissingRequiredDataException(RatingsDataContants.DATA_REQUIRED);
		}
		ratingsByUserId.setUserId(userId);
		List<Ratings> ratingsData = new ArrayList<Ratings>();
		
		List<Rating> ratings = repo.findRatingByUserId(userId);
		Optional<List<Rating>> opt = Optional.ofNullable(ratings);
		if (!opt.isPresent() || opt.get().isEmpty()) {
			Ratings defRatings = new Ratings();
			defRatings.setId(RatingsDataContants.ZERO);
			defRatings.setMovieId(RatingsDataContants.DEFAULT);
			defRatings.setRating(RatingsDataContants.ZERO);
			ratingsData.add(defRatings);
			ratingsByUserId.setRatings(ratingsData);
			LOG.info(RatingsDataContants.MSG_SUCCESSFUL);
			return ratingsByUserId;
		}
		Ratings ratingsObj = null;
		for (Rating rating : ratings) {
			int id = rating.getId();
			String movieId = rating.getMovieId() == null ? RatingsDataContants.DEFAULT : rating.getMovieId().trim();
			double rate = rating.getRating();
			ratingsObj = new Ratings();
			ratingsObj.setId(id);
			ratingsObj.setMovieId(movieId);
			ratingsObj.setRating(rate);
			ratingsData.add(ratingsObj);
		}
		ratingsByUserId.setRatings(ratingsData);
		LOG.info(RatingsDataContants.MSG_SUCCESSFUL);
		return ratingsByUserId;
	}
}
