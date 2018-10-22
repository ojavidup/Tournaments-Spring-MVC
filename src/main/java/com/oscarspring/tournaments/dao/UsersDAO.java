package com.oscarspring.tournaments.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oscarspring.tournaments.models.User;

public interface UsersDAO extends JpaRepository<User, Long>{
	
	User findByEmail(String email);

	User findAllByEmail(String theUserEmail);
	
}
