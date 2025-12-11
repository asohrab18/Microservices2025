package com.learning.service;

import com.learning.model.CatalogInfo;
import com.learning.model.MoviesCatalog;

public interface CatalogService {

	CatalogInfo getMoviesCatalog(String userId) throws Exception;
	
	MoviesCatalog getMoviesCatalog() throws Exception;
}
