package io.egen.api.service;

import io.egen.api.entity.Rating;

public interface RatingService {
	public float getmovierating(String id);
	public Rating insertrating(Rating rtg);
}
