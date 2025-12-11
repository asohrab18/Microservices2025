package com.learning.service;

import com.learning.model.Rating;
import com.learning.model.RatingsByUserId;
import com.learning.model.RatingsData;

public interface RatingsDataService {

	Rating createRating(Rating rating) throws Exception;

	RatingsData getRatings() throws Exception;
	
	RatingsData getRatingsV2() throws Exception;

	RatingsByUserId getRatings(String userId) throws Exception;
}
