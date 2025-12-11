package com.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.helper.RatingsDataHelper;
import com.learning.model.Rating;
import com.learning.model.RatingsByUserId;
import com.learning.model.RatingsData;

@Service
public class RatingsDataServiceImpl implements RatingsDataService {
	@Autowired
	private RatingsDataHelper helper;

	@Override
	public Rating createRating(Rating rating) throws Exception {
		return helper.createRating(rating);
	}

	@Override
	public RatingsData getRatings() throws Exception {
		return helper.getRatings();
	}

	@Override
	public RatingsByUserId getRatings(String userId) throws Exception {
		return helper.getRatings(userId);
	}

	@Override
	public RatingsData getRatingsV2() throws Exception {
		return helper.getRatingsV2();
	}
}