package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learning.model.CatalogInfo;
import com.learning.model.MoviesCatalog;
import com.learning.service.CatalogService;
import com.learning.utils.CatalogContants;

@RestController
@RequestMapping(CatalogContants.CATALOGS)
public class CatalogController {

	@Autowired
	private CatalogService service;

	@GetMapping(CatalogContants.URL_USER_ID_PATH)
	public ResponseEntity<CatalogInfo> getMoviesCatalog(@PathVariable String userId) throws Exception {
		CatalogInfo catalog = service.getMoviesCatalog(userId);
		return new ResponseEntity<>(catalog, HttpStatus.OK);
	}

	@GetMapping(CatalogContants.SLASH)
	public ResponseEntity<MoviesCatalog> getMoviesCatalog() throws Exception {
		MoviesCatalog moviesCatalog = service.getMoviesCatalog();
		return new ResponseEntity<>(moviesCatalog, HttpStatus.OK);
	}
}