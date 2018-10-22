package com.oscarspring.tournaments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oscarspring.tournaments.dao.TournamentDAO;
import com.oscarspring.tournaments.models.Tournament;

@Service
public class TournamentServiceImpl implements TournamentService {
	
	@Autowired
	private TournamentDAO tournamentDAO;

	@Override
	@Transactional
	public List<Tournament> getTournaments() {
		
		return tournamentDAO.findAll();
	}

	@Override
	@Transactional
	public void saveTournament(Tournament theTournament) {
		
		tournamentDAO.save(theTournament);
	}
	
	@Override
	@Transactional
	public List<Tournament> findByUserEmail(String userEmail) {
		
		return tournamentDAO.findAllByUserId(userEmail);
	}

	@Override
	@Transactional
	public Tournament getTournamentById(int theId) {
		
		return tournamentDAO.findById(theId);
	}

	@Override
	@Transactional
	public void deleteTournamentById(int theId) {
		
		tournamentDAO.deleteTournamentById(theId);
		
	}
	
	
}
