package io.egen.api.repository;

import java.util.Optional;

import org.springframework.data.repository.Repository;
import io.egen.api.entity.Genre;

public interface GenreRepository extends Repository<Genre,String> {
	public Genre save(Genre genre);
	public Optional<Genre> findByGenreName(String genrename);
}