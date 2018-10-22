package com.oscarspring.tournaments.models;

import java.sql.Date;
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
@Table(name="players")
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_player")
	private int id;
	
	@Column(name="player_name")
	private String name;
	
	@Column(name="birthdate")
	private java.sql.Date birthdate;
	
	@Column(name="positions")
	private String positions;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="id_team")
	private Team idTeam;
	
	@OneToMany(mappedBy="idPlayer", cascade= {CascadeType.ALL})
	private List<GoalDetail> goalDetails;
	
	@OneToMany(mappedBy="idPlayer", cascade= {CascadeType.ALL})
	private List<CardDetail> cardDetails;

	public Player() {
	}

	public Player(int id, String name, Date birthdate, String positions) {
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.positions = positions;
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

	public java.sql.Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(java.sql.Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getPositions() {
		return positions;
	}

	public void setPositions(String positions) {
		this.positions = positions;
	}

	public Team getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(Team idTeam) {
		this.idTeam = idTeam;
	}

	public List<GoalDetail> getGoalDetails() {
		return goalDetails;
	}

	public void setGoalDetails(List<GoalDetail> goalDetails) {
		this.goalDetails = goalDetails;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", birthdate=" + birthdate + ", positions=" + positions + "]";
	}

}
