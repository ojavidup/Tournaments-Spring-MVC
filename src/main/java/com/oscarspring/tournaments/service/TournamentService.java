package com.oscarspring.tournaments.service;

import java.util.List;

import com.oscarspring.tournaments.models.Tournament;

public interface TournamentService {
	
	public List<Tournament> getTournaments();

	public void saveTournament(Tournament theTournament);

	public List<Tournament> findByUserEmail(String userEmail);

	public Tournament getTournamentById(int theId);

	public void deleteTournamentById(int theId);

}
