package com.exam.service;

import com.exam.model.User;

/**
 * 
 * @author Tejas
 *
 */
public interface UserService {
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	public User findUserByEmail(String email);
	
	/**
	 * 
	 * @param user
	 */
	public void saveUser(User user);
}
