package com.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.learning.model.Movie;

@Transactional
public interface MoviesInfoRepo extends JpaRepository<Movie, Integer> {

	Movie findMovieByMovieId(String movieId);

}
