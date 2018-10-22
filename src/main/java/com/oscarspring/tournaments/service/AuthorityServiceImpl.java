package com.oscarspring.tournaments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oscarspring.tournaments.dao.AuthorityDAO;
import com.oscarspring.tournaments.models.Authority;

@Service
public class AuthorityServiceImpl implements AuthorityService {
	
	@Autowired
	private AuthorityDAO authorityDAO;

	@Override
	public Authority findAllByAuthority(String theAuthority) {
		
		return authorityDAO.findAllByAuthority(theAuthority);
	}

	@Override
	public List<Authority> getAuthorities() {
		return authorityDAO.findAll();
	}

}
