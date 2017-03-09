package io.egen.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import io.egen.api.entity.Genre;
import io.egen.api.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie,String>{
	public List<Movie> findByType(String type);
	public List<Movie> findByTypeOrderByImdbRatingDesc(String type);
	public Movie save(Movie mve);
	public void delete(Movie mve);
	public Optional<Movie> findByTitle(String s);
	public Optional<Movie> findById(String id);
	
	//Methods for filtering and sorting the movies according to attribute type, Genres, year, sort
	public List<Movie> findByYear(String value);
	public List<Movie> findByGenresGenreName(String value);
	public List<Movie> findAll(Sort sort);
	public List<Movie> findByTypeAndYear(String value,String value1);
	public List<Movie> findByTypeAndGenresGenreName(String value,String value1);
	public List<Movie> findByType(String value,Sort sort);
	public List<Movie> findByYearAndGenresGenreName(String value,String value1);
	public List<Movie> findByYear(String value,Sort sort);
	public List<Movie> findByGenresGenreName(String value,Sort sort);
	public List<Movie> findByTypeAndYearAndGenresGenreName(String value,String value1,String value2);
	public List<Movie> findByTypeAndYear(String value,String value1,Sort sort);
	public List<Movie> findByTypeAndGenresGenreName(String value,String value1,Sort sort);
	public List<Movie> findByYearAndGenresGenreName(String value,String value1,Sort sort);
	public List<Movie> findByTypeAndYearAndGenresGenreName(String value,String value1,String value2,Sort sort);
}
