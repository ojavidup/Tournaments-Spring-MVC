package com.oscarspring.tournaments.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oscarspring.tournaments.models.Tournament;

public interface TournamentDAO extends JpaRepository<Tournament, Long>{
	
	@Query(value = "select t.id_tournament,\r\n" + 
			"t.tournament_name,\r\n" + 
			"t.teams_number,\r\n" + 
			"t.players_no,\r\n" + 
			"t.players_in_game,\r\n" + 
			"t.inscription_cost,\r\n" + 
			"t.start_date,\r\n" + 
			"id_field from tournaments t inner join users u on t.id_user=u.id_user where u.email=?1", nativeQuery = true)
	List<Tournament> findAllByUserId(String userEmail);

	Tournament findById(int theId);
	
	Long deleteTournamentById(int theId);
}
