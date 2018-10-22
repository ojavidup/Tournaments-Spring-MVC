package com.oscarspring.tournaments.service;

import java.util.List;

import com.oscarspring.tournaments.models.Authority;

public interface AuthorityService {

	public Authority findAllByAuthority(String theAuthority);
	
	public List<Authority> getAuthorities();

}
