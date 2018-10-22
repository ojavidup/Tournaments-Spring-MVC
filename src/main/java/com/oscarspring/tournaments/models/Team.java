package com.oscarspring.tournaments.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="teams")
public class Team {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_team")
	private int id;
	
	@Column(name="team_name")
	private String name;
	
	@Column(name="points")
	private int points;
	
	@Column(name="gp")
	private int gamesPlayed;
	
	@Column(name="gw")
	private int gamesWon;
	
	@Column(name="gl")
	private int gameslost;
	
	@Column(name="gt")
	private int gamesTied;
	
	@Column(name="goals_s")
	private int goalsScored;
	
	@Column(name="goals_a")
	private int goalsAgainst;
	
	@Column(name="dif")
	private int goalsdDif;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_tournament")
	private Tournament idTournament;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_agent")
	private Agent idAgent;
	
	@OneToMany(mappedBy="idTeamL", cascade= {CascadeType.ALL})
	private List<Match> matchesL;
	
	@OneToMany(mappedBy="idTeamV", cascade= {CascadeType.ALL})
	private List<Match> matchesV;
	
	@OneToMany(mappedBy="idTeam", cascade= {CascadeType.ALL})
	private List<Player> players;

	public Team() {
	}

	public Team(int id, String name, int points, int gamesPlayed, int gamesWon, int gameslost, int gamesTied,
			int goalsScored, int goalsAgainst, int goalsdDif) {
		this.id = id;
		this.name = name;
		this.points = points;
		this.gamesPlayed = gamesPlayed;
		this.gamesWon = gamesWon;
		this.gameslost = gameslost;
		this.gamesTied = gamesTied;
		this.goalsScored = goalsScored;
		this.goalsAgainst = goalsAgainst;
		this.goalsdDif = goalsdDif;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public int getGamesWon() {
		return gamesWon;
	}

	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}

	public int getGameslost() {
		return gameslost;
	}

	public void setGameslost(int gameslost) {
		this.gameslost = gameslost;
	}

	public int getGamesTied() {
		return gamesTied;
	}

	public void setGamesTied(int gamesTied) {
		this.gamesTied = gamesTied;
	}

	public int getGoalsScored() {
		return goalsScored;
	}

	public void setGoalsScored(int goalsScored) {
		this.goalsScored = goalsScored;
	}

	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}

	public int getGoalsdDif() {
		return goalsdDif;
	}

	public void setGoalsdDif(int goalsdDif) {
		this.goalsdDif = goalsdDif;
	}

	public Tournament getIdTournament() {
		return idTournament;
	}

	public void setIdTournament(Tournament idTournament) {
		this.idTournament = idTournament;
	}

	public Agent getIdAgent() {
		return idAgent;
	}

	public void setIdAgent(Agent idAgent) {
		this.idAgent = idAgent;
	}

	public List<Match> getMatchesL() {
		return matchesL;
	}

	public void setMatchesL(List<Match> matchesL) {
		this.matchesL = matchesL;
	}

	public List<Match> getMatchesV() {
		return matchesV;
	}

	public void setMatchesV(List<Match> matchesV) {
		this.matchesV = matchesV;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", points=" + points + ", gamesPlayed=" + gamesPlayed
				+ ", gamesWon=" + gamesWon + ", gameslost=" + gameslost + ", gamesTied=" + gamesTied + ", goalsScored="
				+ goalsScored + ", goalsAgainst=" + goalsAgainst + ", goalsdDif=" + goalsdDif + "]";
	}

}
