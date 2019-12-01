package com.my.api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.my.api.Exceptions.UserIdNotFoundException;
import com.my.api.domain.User;
import com.my.api.service.UserServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

/**
 *  The Class UserController.
 * 
 */
@Slf4j
@RestController
public class UserController {
	 @Autowired
	 private UserServiceImpl userService;
	 
	 @GetMapping("/users")
	 @ApiOperation(value = "/users- All users",
     notes = "Get all users")
	 public ResponseEntity<List<User>> getUsers(){
	     return ResponseEntity.ok(userService.getAllUsers());
	 }
	 
	 
	 @GetMapping("/user/{id}")
	 @ApiOperation(value = "/bureau/juror/{jurorId} - Get user by id",
     notes = "Retrieve user by his/her id")
	 public ResponseEntity<User> getUsersById(@ApiParam(value = "Valid user id", required = true)
	      @PathVariable String id) {
		  User user = userService.getUserById(id);
		  if (user == null) {
			  throw new UserIdNotFoundException("Invalid user id : " + id);
		  }
	      return ResponseEntity.ok().body(userService.getUserById(id));
	 }
	 
	 
	 @GetMapping("/instructions")
	 @ApiOperation(value = "/instructions - Get Api instructions",
     notes = "Retrieve Api instructions")
	 public ResponseEntity<String> getInstructions() {
	      return ResponseEntity.ok(userService.getInstructions());
	 }
	 
	 
	 @GetMapping("/city/{city}/users")
	 @ApiOperation(value = "/city/{city}/users - Get users by city",
     notes = "Retrieve people who are listed as either living in London, "
     		+ "or whose current coordinates are within 50 miles of London ")
	 public ResponseEntity<List<User>> getUsersByCity(@ApiParam(value = "City name", required = true)
	     @PathVariable String city) throws IOException {
	     return ResponseEntity.ok(userService.getUsersByCity(city));
	 }
}
