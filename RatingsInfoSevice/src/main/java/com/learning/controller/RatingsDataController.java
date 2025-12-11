package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learning.model.Rating;
import com.learning.model.RatingsByUserId;
import com.learning.model.RatingsData;
import com.learning.service.RatingsDataService;
import com.learning.utils.RatingsDataContants;

@RestController
@RequestMapping(RatingsDataContants.RATINGS)
public class RatingsDataController {
	@Autowired
	private RatingsDataService service;

	@PostMapping(RatingsDataContants.SLASH)
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) throws Exception {
		rating = service.createRating(rating);
		return new ResponseEntity<>(rating, HttpStatus.CREATED);
	}

	@GetMapping(RatingsDataContants.SLASH)
	public ResponseEntity<RatingsData> getRatings() throws Exception {
		RatingsData ratings = service.getRatings();
		return new ResponseEntity<>(ratings, HttpStatus.OK);
	}

	@GetMapping(RatingsDataContants.SLASH_V2)
	public ResponseEntity<RatingsData> getRatingsV2() throws Exception {
		RatingsData ratings = service.getRatingsV2();
		return new ResponseEntity<>(ratings, HttpStatus.OK);
	}
	
	@GetMapping(RatingsDataContants.URL_USER_ID_PATH)
	public ResponseEntity<RatingsByUserId> getRatings(@PathVariable String userId) throws Exception {
		RatingsByUserId ratingsByUserId = service.getRatings(userId);
		return new ResponseEntity<>(ratingsByUserId, HttpStatus.OK);
	}
}