package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learning.model.Movie;
import com.learning.model.MoviesInfo;
import com.learning.service.MoviesInfoService;
import com.learning.utils.MoviesInfoContants;

@RestController
@RequestMapping(MoviesInfoContants.MOVIES)
public class MoviesInfoController {

	@Autowired
	private MoviesInfoService service;

	@PostMapping(MoviesInfoContants.SLASH)
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) throws Exception {
		movie = service.createMovie(movie);
		return new ResponseEntity<>(movie, HttpStatus.CREATED);
	}
	
	@GetMapping(MoviesInfoContants.SLASH)
	public ResponseEntity<MoviesInfo> getMovies() throws Exception {
		MoviesInfo moviesInfo = service.getMovies();
		return new ResponseEntity<>(moviesInfo, HttpStatus.OK);
	}
	
	@GetMapping(MoviesInfoContants.SLASH_V2)
	public ResponseEntity<MoviesInfo> getMoviesV2() throws Exception {
		MoviesInfo moviesInfo = service.getMoviesV2();
		return new ResponseEntity<>(moviesInfo, HttpStatus.OK);
	}
	
	@GetMapping(MoviesInfoContants.URL_MOVIE_ID_PATH)
	public ResponseEntity<Movie> getMovie(@PathVariable String movieId) throws Exception {
		Movie movie = service.getMovie(movieId);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	
	
	@PutMapping(MoviesInfoContants.SLASH)
	public ResponseEntity<String> updateMovie(@RequestBody Movie movie) throws Exception {
		String updateMessage = service.updateMovie(movie);
		return new ResponseEntity<>(updateMessage, HttpStatus.OK);
	}

	@DeleteMapping(MoviesInfoContants.URL_ID_PATH)
	public ResponseEntity<String> deleteMovie(@PathVariable int id) throws Exception {
		String deleteMessage = service.deleteMovie(id);
		return new ResponseEntity<>(deleteMessage, HttpStatus.OK);
	}
}