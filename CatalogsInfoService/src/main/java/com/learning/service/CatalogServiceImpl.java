package com.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.helper.CatalogHelper;
import com.learning.model.CatalogInfo;
import com.learning.model.MoviesCatalog;

@Service
public class CatalogServiceImpl implements CatalogService {
	@Autowired
	private CatalogHelper helper;

	@Override
	public CatalogInfo getMoviesCatalog(String userId) throws Exception {
		return helper.getMoviesCatalog(userId);
	}

	@Override
	public MoviesCatalog getMoviesCatalog() throws Exception {
		return helper.getMoviesCatalog();
	}
}