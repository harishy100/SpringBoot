package io.egen.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.entity.Movie;


public interface MovieServiceFacade {
	public Movie createMovie(Movie movie);
}
