package io.egen.api.controller;

import io.egen.api.service.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.egen.api.entity.*;

@RestController
@RequestMapping(value="rating")
public class RatingController {
	@Autowired
	private RatingService service;
	
	@RequestMapping(method=RequestMethod.GET, value="{id}")
	@ApiOperation(value = "Get Rating By MovieID", notes = "Retrieves average rating recieved by a particular movie by specifying movieID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),@ApiResponse(code = 404, message = "NotFound"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public float getmovierating(@PathVariable("id") String id){
		return service.getmovierating(id);
	}
	@RequestMapping(method=RequestMethod.POST)
	@ApiOperation(value = "Insert Rating", notes = "Stores the rating of a movie by a user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Rating insertrating(@RequestBody Rating rtg){
		return service.insertrating(rtg);
	}
}
