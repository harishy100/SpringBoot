package io.egen.api.controller;

import io.egen.api.entity.*;

import io.egen.api.service.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiParam;
import io.egen.api.service.*;

@RestController
@CrossOrigin("http://localhost:4000")
public class MovieController {
	@Autowired
	private MovieService service;
	@Autowired private MovieServiceFacade facadeservice;
	
	
	@RequestMapping(method=RequestMethod.GET,value= "movies")
	@ApiOperation(value = "Find all Movies", notes = "Returns all the movies")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<Movie> findallMovies(){
		return service.findallMovies();
	}
	
	@RequestMapping(method=RequestMethod.GET,value= "tv")
	@ApiOperation(value = "Find all Tv series", notes = "Returns all the tv series")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<Movie> findallTv(){
		return service.findallTv();
	}
	
	@RequestMapping(method=RequestMethod.GET,value= "movies/toprated")
	@ApiOperation(value = "Find all topRated Movies", notes = "Returns all the toprated movies")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<Movie> findtopmovie(){
		return service.findtopmovie();
	}
	
	@RequestMapping(method=RequestMethod.GET,value= "tv/toprated")
	@ApiOperation(value = "Find all toprated Tv", notes = "Returns all the toprated tv series")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<Movie> findtoptv(){
		return service.findtoptv();
	}
	
	@RequestMapping(method=RequestMethod.POST,value= "admin/createmovie")
	@ApiOperation(value = "Create Movie", notes = "Creates a movie in the app with all the details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Movie createmovie(@RequestBody Movie mve){
		return facadeservice.createMovie(mve); 
	}
	
	@RequestMapping(method=RequestMethod.PUT,value= "admin/updatemovie")
	@ApiOperation(value = "Update Movie", notes = "Update a movie in the application")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Movie updatemovie(@RequestBody Movie mve){
		return service.updatemovie(mve);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value= "admin/deletemovie/{id}")
	@ApiOperation(value = "Delete Movie", notes = "Deletes a movie in the application given the Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "NotFound"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public void deletemovie(@PathVariable("id") String id){
		service.deletemovie(id);
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value= "movies/{id}")
	@ApiOperation(value = "Get Movie By ID", notes = "Retrieves a movie by specifying movieID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),@ApiResponse(code = 404, message = "NotFound"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Movie findmovie(@PathVariable("id") String id){
		return service.findmovie(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="sort/{attribute}")
	@ApiOperation(value = "Sort movies", notes = "Sort the movies by given attribute"+"   Example :localhost:8080/project1/api/sort/imdbVotes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<Movie> sortbyattribute(@ApiParam(name = "Sortattribute", value = "Sort attribute", defaultValue = "") @RequestParam
            ("sort") String sort){
			String type="";String genre="";String year="";
		return service.filterbyattribute(type, genre,year,sort);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="filter")
	@ApiOperation(value = "Filter movies", notes = "Sort the movies by given filters   Example : localhost:8080/api/filter?year=1956   "
			+ "  Example: localhost:8080/api/filter?type=movie&year=1956&genre=mystery&sort=imdbRating      ")
	
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<Movie> filterbyattribute(@ApiParam(name = "type", value = "type", defaultValue = "") @RequestParam
            (value="type", required=false) String type,@ApiParam(name = "genre", value = "genre", defaultValue = "") @RequestParam
            (value="genre",required=false) String genre, @ApiParam(name = "year", value = "year", defaultValue = "") @RequestParam
            (value="year",required=false) String year, @ApiParam(name = "sort", value = "sort", defaultValue = "") @RequestParam
            (value="sort",required=false) String sort){		
		return service.filterbyattribute(type, genre,year,sort);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="imdb/{id}")
	@ApiOperation(value = "Get IMDB ID OF A Movie", notes = "Find the IMDB ID of the movie by the given movie ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "NotFound"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public String findimdbid(@PathVariable("id") String id){
		return service.findimdbid(id);
	}
}
