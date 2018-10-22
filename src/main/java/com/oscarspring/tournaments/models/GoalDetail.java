package com.oscarspring.tournaments.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="goals_details")
public class GoalDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_goal")
	private int id;
	
	@Column(name="goal_type")
	private String goalType;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="id_match")
	private Match idMatch;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="id_player")
	private Player idPlayer;

	public GoalDetail() {
	}

	public GoalDetail(int id, String goalType) {
		this.id = id;
		this.goalType = goalType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGoalType() {
		return goalType;
	}

	public void setGoalType(String goalType) {
		this.goalType = goalType;
	}

	public Match getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(Match idMatch) {
		this.idMatch = idMatch;
	}

	public Player getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(Player idPlayer) {
		this.idPlayer = idPlayer;
	}

	@Override
	public String toString() {
		return "GoalDetail [id=" + id + ", goalType=" + goalType + "]";
	}

}
