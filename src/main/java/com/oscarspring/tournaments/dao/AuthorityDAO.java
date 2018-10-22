package com.oscarspring.tournaments.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oscarspring.tournaments.models.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, Long>{
	
	Authority findAllByAuthority(String theAuthority);

}
