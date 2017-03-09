package io.egen.api.service.Impl;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.entity.Genre;
import io.egen.api.repository.GenreRepository;
import io.egen.api.service.GenreService;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

	@Autowired
	GenreRepository repository;
	@Override
	public Optional<Genre> findByGenreName(String Genrename) {
		Optional<Genre> Genre= repository.findByGenreName(Genrename);
		return Genre;
		
	}

	@Override
	public Genre createGenre(Genre Genre) {

		return repository.save(Genre);
	}

}
