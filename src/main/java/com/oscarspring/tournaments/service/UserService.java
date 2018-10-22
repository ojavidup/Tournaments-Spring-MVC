package com.oscarspring.tournaments.service;

import java.util.List;

import com.oscarspring.tournaments.models.User;

public interface UserService {
	
	public User findUserByEmail(String email);
	
	public List<User> getUsers();
	
	public void saveUser(User theUser);

	public User findAllByEmail(String theUserEmail);

}
