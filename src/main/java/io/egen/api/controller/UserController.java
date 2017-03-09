package io.egen.api.controller;

import java.util.List;

import io.egen.api.datatransfer.*;
import io.egen.api.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import io.egen.api.entity.User;
import io.egen.api.service.*;

@RestController
@RequestMapping(value= "user")
@Api(tags="user")
public class UserController {

		@Autowired
		private UserService service;
		
		@RequestMapping(method=RequestMethod.POST, value= "login")
		@ApiOperation(value = "USER Login", notes = "Verifies the login credentials of a User")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
				@ApiResponse(code = 500, message = "Internal Server Error"), })
		public Boolean login( @RequestBody dataLogin login){
			return service.login(login);
		}
		
		@RequestMapping(method=RequestMethod.POST)
		@ApiOperation(value = "Create User", notes = "Creates a user in the app with unique email")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
				@ApiResponse(code = 400, message = "Bad Request"),
				@ApiResponse(code = 500, message = "Internal Server Error"), })
		public User create(@RequestBody User usr){
			return service.create(usr);	
		}
		
	}
