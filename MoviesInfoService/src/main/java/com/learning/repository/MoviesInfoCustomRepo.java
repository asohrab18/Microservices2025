package com.learning.repository;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.learning.exception.MissingRequiredDataException;
import com.learning.exception.NotFoundException;
import com.learning.model.Movie;
import com.learning.utils.MoviesInfoContants;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
@Transactional
public class MoviesInfoCustomRepo {
	private static final Logger LOG = LoggerFactory.getLogger(MoviesInfoCustomRepo.class);

	@PersistenceContext
	private EntityManager entityManager;

	public String update(Movie movie) throws Exception {
		if (movie == null) {
			LOG.info(MoviesInfoContants.DATA_REQUIRED);
			throw new MissingRequiredDataException(MoviesInfoContants.DATA_REQUIRED);
		}
		int id = movie.getId();
		if (id <= MoviesInfoContants.ZERO) {
			LOG.info(MoviesInfoContants.ID_GREATER_THAN_ZERO);
			throw new MissingRequiredDataException(MoviesInfoContants.ID_GREATER_THAN_ZERO);
		}
		String movieId = movie.getMovieId();
		String name = movie.getName();
		String description = movie.getDescription();
		if (StringUtils.isBlank(movieId) && StringUtils.isBlank(name) && StringUtils.isBlank(description)) {
			LOG.info(MoviesInfoContants.DATA_REQUIRED);
			throw new MissingRequiredDataException(MoviesInfoContants.DATA_REQUIRED);
		}
		String result = null;
		StringBuilder sbd = new StringBuilder();
		sbd.append("UPDATE Movie e SET e.id = :id");

		if (StringUtils.isNotBlank(movieId)) {
			sbd.append(", e.movieId = :movieId");
		}
		if (StringUtils.isNotBlank(name)) {
			sbd.append(", e.name = :name");
		}
		if (StringUtils.isNotBlank(description)) {
			sbd.append(", e.description = :description");
		}
		sbd.append(" WHERE e.id = :id");
		String hql = sbd.toString();
		Query query = entityManager.createQuery(hql);

		query.setParameter("id", id);

		if (StringUtils.isNotBlank(movieId)) {
			movieId = movieId.trim();
			query.setParameter("movieId", movieId);
		}
		if (StringUtils.isNotBlank(name)) {
			name = name.trim();
			query.setParameter("name", name);
		}
		if (StringUtils.isNotBlank(description)) {
			description = description.trim();
			query.setParameter("description", description);
		}
		int count = query.executeUpdate();
		if (count > MoviesInfoContants.ZERO) {
			result = MoviesInfoContants.DATA_UPDATED;
		} else {
			LOG.info(MoviesInfoContants.DATA_NOT_UPDATED);
			throw new NotFoundException(MoviesInfoContants.DATA_NOT_UPDATED);
		}
		LOG.info(MoviesInfoContants.MSG_SUCCESSFUL);
		return result;
	}

}