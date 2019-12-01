package com.my.api.service;

import java.io.IOException;
import java.util.List;

import com.my.api.Exceptions.UserIdNotFoundException;
import com.my.api.domain.User;

/**
 * The Class UserService.
 * 
 */
public interface UserService {
	
	/**
	 * Get all users
	 * 
	 * @return List of the users
	 */
	public List<User> getAllUsers();
	
	/**
	 * Get user by id
	 * 
	 * @return user
	 * @throws UserIdNotFoundException 
	 */
	public User getUserById(String id) throws UserIdNotFoundException;

	/**
	 * Get instructions
	 * 
	 * @return instructions
	 */
	String getInstructions();

	/**
	 * Get user by city
	 * 
	 * @return List of the users
	 */
	List<User> getUsersByCity(String city) throws IOException;

}
