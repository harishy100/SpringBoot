package io.egen.api.repository;

import java.util.List;

import org.springframework.data.repository.Repository;


import io.egen.api.entity.Movie;
import io.egen.api.entity.User;
import io.egen.api.entity.Rating;

public interface RatingRepository extends Repository<Rating, String>{
	public List<Rating> findByMveId(String id);
	public Rating save(Rating rtg);
	public Rating findByMveAndUsr(Movie movie, User user);
}