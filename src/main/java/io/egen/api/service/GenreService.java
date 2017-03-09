package io.egen.api.service;

import java.util.Optional;

import io.egen.api.entity.Actor;
import io.egen.api.entity.Genre;

public interface GenreService {
	public Optional<Genre> findByGenreName(String genrename);
	public Genre createGenre(Genre genre);
}
