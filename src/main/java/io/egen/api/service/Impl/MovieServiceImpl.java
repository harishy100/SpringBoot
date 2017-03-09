package io.egen.api.service.Impl;

import java.util.List;

import java.util.Map;

import io.egen.api.exceptions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

import io.egen.api.entity.Actor;
import io.egen.api.entity.Genre;
import io.egen.api.entity.Movie;
import io.egen.api.repository.*;
import io.egen.api.service.MovieService;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repository;

	@Override
	public List<Movie> findtopmovie() {
		Movie m;
		return repository.findByTypeOrderByImdbRatingDesc("Movie");
	}

	@Override
	public List<Movie> findtoptv() {

		return repository.findByTypeOrderByImdbRatingDesc("tv");
	}

	@Override
	public Movie createmovie(Movie mve) {
		return repository.save(mve);
		
	}

	@Override
	public Movie updatemovie(Movie mve) {

		Movie mve1 = repository.findById(mve.getid()).orElseThrow(() -> new BadRequestException("Movie doesnt exist"));

		return repository.save(mve);
	}

	@Override
	public void deletemovie(String id) {

		Movie mve1 = repository.findById(id).orElseThrow(() -> new BadRequestException("Movie doesnt exist"));
		repository.delete(mve1);
	}

	@Override
	public List<Movie> findallMovies() {
		return repository.findByType("Movie");
	}

	@Override
	public Movie findmovie(String id) {
		Movie m = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Movie doesnt exist"));

		return m;
	}

	@Override
	public List<Movie> findallTv() {
		return repository.findByType("tv");
	}
	@Override
	public Optional<Movie> findByTitle(String title){
		return repository.findByTitle(title);
	}

	@Override
	public List<Movie> filterbyattribute(String type, String genre, String year, String sortattr){
		
		if(type!=null && year==null&& genre==null &&sortattr==null){
			return repository.findByType(type);
		}
		else if(type==null && year!=null && genre==null && sortattr==null ){
			return repository.findByYear(year);
		}
		else if(type==null && year==null && genre!=null && sortattr==null){
			
			return repository.findByGenresGenreName(genre);
		}
		else if(type==null && year==null && genre==null && sortattr!=null){
			return repository.findAll(new Sort(Sort.Direction.DESC,sortattr));
		}
		else if(type!=null && year!=null && genre==null && sortattr==null){
			return repository.findByTypeAndYear(type,year);
		}
		else if(type!=null && year==null && genre!=null && sortattr==null){
			System.err.println(type+genre);
			return repository.findByTypeAndGenresGenreName(type,genre);
		}
		else if(type!=null && year==null && genre==null && sortattr!=null){
			return repository.findByType(type,new Sort(Sort.Direction.DESC,sortattr));
		}
		else if(type==null && year!=null && genre!=null && sortattr==null){
			return repository.findByYearAndGenresGenreName(year,genre);
		}
		else if(type==null && year!=null && genre==null && sortattr!=null){
			return repository.findByYear(year,new Sort(Sort.Direction.DESC,sortattr));
		}
		else if(type==null && year==null && genre!=null && sortattr!=null){
			return repository.findByGenresGenreName(genre,new Sort(Sort.Direction.DESC,sortattr));
		}
		else if(type!=null && year!=null && genre!=null && sortattr==null){
			return repository.findByTypeAndYearAndGenresGenreName(type,year,genre);
		}
		else if(type!=null && year!=null && genre==null && sortattr!=null){
			return repository.findByTypeAndYear(type,year,new Sort(Sort.Direction.DESC,sortattr));
		}
		else if(type!=null && year==null && genre!=null && sortattr!=null){
			return repository.findByTypeAndGenresGenreName(type,genre,new Sort(Sort.Direction.DESC,sortattr));
		}
		else if(type==null && year!=null && genre!=null && sortattr!=null){
			return repository.findByYearAndGenresGenreName(year,genre,new Sort(Sort.Direction.DESC,sortattr));
		}
		else if(type!=null && year!=null && genre!=null && sortattr!=null){
			return repository.findByTypeAndYearAndGenresGenreName(type,year,genre,new Sort(Sort.Direction.DESC,sortattr));
		}
		if(type==null && year==null && genre==null && sortattr==null){
			throw new BadRequestException("NoFilter attribute given");
		}
		return null;
	}

	@Override
	public String findimdbid(String id) {

		Movie m = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("imdb title doesnt exist"));

		return m.getImdbid();

	}

}
