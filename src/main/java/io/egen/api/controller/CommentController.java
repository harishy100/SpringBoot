package io.egen.api.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.egen.api.entity.*;
import io.egen.api.service.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="comment")
public class CommentController {
	@Autowired
	private CommentService service;
	
	@RequestMapping(method=RequestMethod.GET, value="{id}")
	@ApiOperation(value = "Get Comments By MovieID", notes = "Retrieves all the comments recieved by a particular movie by specifying movieID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),@ApiResponse(code = 404, message = "NotFound"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<Comment> getmoviecomments(@PathVariable("id") String id){
		return service.getmoviecomments(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ApiOperation(value = "Insert Comments", notes = "Stores the comment of a movie by a user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Comment insertcomment(@RequestBody Comment cmt){
		return service.insertcomment(cmt);
	}
}
