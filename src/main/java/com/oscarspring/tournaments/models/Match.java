package com.oscarspring.tournaments.models;

import java.sql.Timestamp;
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
@Table(name="matches")
public class Match {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_match")
	private int id;
	
	@Column(name="date_time")
	private java.sql.Timestamp dateTime;
	
	@Column(name="referee")
	private String referee;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="id_tournament")
	private Tournament idTournament;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="id_team_l")
	private Team idTeamL;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="id_team_v")
	private Team idTeamV;
	
	@OneToMany(mappedBy="idMatch", cascade= {CascadeType.ALL})
	private List<GoalDetail> goalDetails;
	
	@OneToMany(mappedBy="idMatch", cascade= {CascadeType.ALL})
	private List<CardDetail> cardDetails;

	public Match() {
	}

	public Match(int id, Timestamp dateTime, String referee) {
		this.id = id;
		this.dateTime = dateTime;
		this.referee = referee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.sql.Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(java.sql.Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public String getReferee() {
		return referee;
	}

	public void setReferee(String referee) {
		this.referee = referee;
	}

	public Tournament getIdTournament() {
		return idTournament;
	}

	public void setIdTournament(Tournament idTournament) {
		this.idTournament = idTournament;
	}

	public Team getIdTeamL() {
		return idTeamL;
	}

	public void setIdTeamL(Team idTeamL) {
		this.idTeamL = idTeamL;
	}

	public Team getIdTeamV() {
		return idTeamV;
	}

	public void setIdTeamV(Team idTeamV) {
		this.idTeamV = idTeamV;
	}

	public List<GoalDetail> getGoalDetails() {
		return goalDetails;
	}

	public void setGoalDetails(List<GoalDetail> goalDetails) {
		this.goalDetails = goalDetails;
	}

	public List<CardDetail> getCardDetails() {
		return cardDetails;
	}

	public void setCardDetails(List<CardDetail> cardDetails) {
		this.cardDetails = cardDetails;
	}

	@Override
	public String toString() {
		return "Match [id=" + id + ", dateTime=" + dateTime + ", referee=" + referee + "]";
	}
	
}
