package com.oscarspring.tournaments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.oscarspring.tournaments.dao.UsersDAO;
import com.oscarspring.tournaments.models.User;

@Service
public class UsersServiceImpl implements UserService{
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UsersDAO usersDAO;

	@Override
	public List<User> getUsers() {

		return usersDAO.findAll();
	}
	
	@Override
	public User findUserByEmail(String email) {
		
		return usersDAO.findByEmail(email);
		
	}
	
	@Override
	public void saveUser(User theUser) {

		theUser.setPassword(bCryptPasswordEncoder.encode(theUser.getPassword()));
		
		theUser.setEnable(1);

		usersDAO.save(theUser);
	}

	@Override
	public User findAllByEmail(String theUserEmail) {
		
		return usersDAO.findAllByEmail(theUserEmail);
	}

}
