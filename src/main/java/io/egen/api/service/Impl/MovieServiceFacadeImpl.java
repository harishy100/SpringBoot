package io.egen.api.service.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.entity.Actor;
import io.egen.api.entity.Genre;
import io.egen.api.entity.Movie;
import io.egen.api.exceptions.BadRequestException;
import io.egen.api.service.ActorService;
import io.egen.api.service.GenreService;
import io.egen.api.service.MovieService;
import io.egen.api.service.MovieServiceFacade;

@Service
@Transactional
public class MovieServiceFacadeImpl implements MovieServiceFacade {

	@Autowired
	ActorService actservice;
	@Autowired
	GenreService gnrservice;
	@Autowired
	MovieService mveservice;
	
	
	
	@Override
	public Movie createMovie(Movie movie) {
		Optional<Movie> mve1 = mveservice.findByTitle(movie.getTitle());
		
		if (!mve1.isPresent()) {
			List<Actor> actors=movie.getActors();
			for(Actor actor :actors){
				if(!actservice.findByActorName(actor.getActorname()).isPresent()){
					actservice.createActor(actor);
				}
			}
			List<Genre> genres=movie.getGenres();
			for(Genre genre :genres){
				if(!gnrservice.findByGenreName(genre.getGenrename()).isPresent()){
					gnrservice.createGenre(genre);
				}
			}
			return mveservice.createmovie(movie);
		}
		else{
		throw new BadRequestException("Movie Already exists");
		}
		
	}

}
