package com.learning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.learning.model.Rating;

@Transactional
public interface RatingsDataRepo extends JpaRepository<Rating, Integer> {

	List<Rating> findRatingByUserId(String userId);

}
