package io.egen.api.service;

import io.egen.api.entity.Movie;
import java.util.*;

public interface MovieService {
	public List<Movie> findallMovies();
	public List<Movie> findallTv();
	public List<Movie> findtopmovie();
	public List<Movie> findtoptv();
	public Movie createmovie(Movie mve);
	public Movie updatemovie(Movie mve);
	public void deletemovie(String id);
	public Optional<Movie> findByTitle(String title);
	public Movie findmovie(String id);
	public List<Movie> filterbyattribute(String type, String genre, String year, String sort);
	public String findimdbid(String id);
}